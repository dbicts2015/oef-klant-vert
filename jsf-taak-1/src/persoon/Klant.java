package persoon;

public class Klant {

	/**
	 * De nummer van de klant
	 */
	private String nummer;

	/**
	 * De naam van de klant
	 */
	private String naam;

	public Klant(String nummer, String naam) {
		this.nummer = nummer;
		this.naam = naam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Klant other = (Klant) obj;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		return true;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}
