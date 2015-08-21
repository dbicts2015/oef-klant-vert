package persoon.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import persoon.Klant;
import persoon.Vertegenwoordiger;
import persoon.event.VertegenwoordigerEvent;

@Named("vertegenwoordiger")
@SessionScoped
public class VertegenwoordigerBean implements Serializable {

	/**
	 * De versie id van de huidige bean
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * De vertegenwoordiger voor deze bean
	 */
	private Vertegenwoordiger vertegenwoordiger;
	
	/**
	 * De klant bean voor de huidige request
	 */
	@Inject private KlantBean klant;
	
	/**
	 * Het object dat de events afhandelt voor deze klasse
	 */
	@Inject private Event<VertegenwoordigerEvent> vertegenwoordigerEvents;
	
	public VertegenwoordigerBean() {
		this.vertegenwoordiger = new Vertegenwoordiger();
	}

	/**
	 * Luistert naar vertegenwoordiger events en zal dan een bericht sturen als
	 * er 10 of meer klanten al aanwezig zijn.
	 * 
	 * @param event
	 */
	public void onVertegenwoordigerEvent(@Observes VertegenwoordigerEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Deze vertegenwoordiger bevat al 10 klanten"));
	}

	public void add() {
		if (vertegenwoordiger.getAantalKlanten() >= 10) {
			vertegenwoordigerEvents.fire(new VertegenwoordigerEvent());
		}
		else vertegenwoordiger.voegKlantToe(klant.getNummer(), klant.getNaam());
	}

	public void remove() {
		vertegenwoordiger.verwijderKlant(klant.getNummer());
	}

	public List<Klant> getKlanten() {
		return vertegenwoordiger.getKlanten();
	}

	public Vertegenwoordiger getVertegenwoordiger() {
		return vertegenwoordiger;
	}

	public void setVertegenwoordiger(Vertegenwoordiger vertegenwoordiger) {
		this.vertegenwoordiger = vertegenwoordiger;
	}

}