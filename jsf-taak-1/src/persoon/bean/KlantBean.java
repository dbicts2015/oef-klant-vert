package persoon.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import persoon.Klant;

@Named("klant")
@RequestScoped
public class KlantBean implements Serializable {

	/**
	 * De versie id van de huidige bean
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * De naam die de gebruiker ingeeft
	 */
	@NotNull(message="Gelieve de naam in te vullen")
	@Size(min=1, message="Gelieve de naam niet leeg te laten")
	private String naam;
	
	/**
	 * De nummer die de gebruiker ingeeft
	 */
	@NotNull(message="Gelieve de nummer in te vullen")
	@Size(min=1, message="Gelieve de nummer niet leeg te laten")
	private String nummer;

	public Klant toKlant() {
		return new Klant(nummer, naam);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

}