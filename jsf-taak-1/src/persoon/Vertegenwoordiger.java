package persoon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * @author user104
 *
 */
public class Vertegenwoordiger {
	
	/**
	 * De collectie van klanten
	 */
	private final Set<Klant> klanten = new HashSet<>();

	/**
	 * Voegt een nieuwe klant toe met een gegeven naam en nummer
	 * 
	 * @param nummer
	 * @param naam
	 */
	public void voegKlantToe(String nummer, String naam) {
		voegKlantToe(new Klant(nummer, naam));
	}
	
	/**
	 * Voegt de gegeven klant toe
	 * 
	 * @param nummer
	 * @param naam
	 */
	public void voegKlantToe(Klant klant) {
		klanten.add(klant);
	}

	/**
	 * Verwijdert een collectie van klanten uit de lijst van klanten
	 * 
	 * @param klanten
	 */
	public void verwijderKlant(Collection<Klant> klanten) {
		klanten.removeAll(klanten);
	}

	/**
	 * Verwijdert de gegeven klant van de lijst
	 * 
	 * @param klant
	 */
	public void verwijderKlant(Klant klant) {
		verwijderKlant(klant);
	}

	/**
	 * Verwijdert alle klanten uit de lijst die als nummer de gegeven
	 * nummer hebben
	 * 
	 * @param nummer
	 */
	public void verwijderKlant(String nummer) {
		verwijderKlant(klanten.stream().filter(k -> k.getNummer().equals(nummer)).collect(Collectors.toList()));
	}

	/**
	 * Geeft een read-only list terug met alle klanten
	 * 
	 * @return
	 */
	public List<Klant> getKlanten() {
		return Collections.unmodifiableList(new ArrayList<>(klanten));
	}

	/**
	 * Geeft de huidige hoeveelheid klanten terug
	 * 
	 * @return
	 */
	public int getAantalKlanten() {
		return klanten.size();
	}

}