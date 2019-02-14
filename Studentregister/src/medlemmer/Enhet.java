package medlemmer;

import java.io.Serializable;
import java.util.ArrayList;

public class Enhet implements Serializable {
	private static final long serialVersionUID = -1216412129676708758L;
	private String navn;
	private String id;
	public static ArrayList<Enhet> enheter = new ArrayList<>();
	/**
	 * Oppretter Enhet-objekt
	 * @param navn - setter navn
	 * @param id - setter id
	 */
	public Enhet(String navn, String id){
		this.navn = navn;
		this.id = id;
		enheter.add(this);
		
	}
	
	
	@Override
	public String toString() {
		return getNavn() + " " + getId();
	}

	/**
	 * get-metode for enhetens navn
	 * @return navn
	 */
	public String getNavn() {
		return navn;
	}
	/**
	 * set-metode for enhetens navn
	 * @param navn - enhetens navn
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}
	/**
	 * get-metode for enhetens ID
	 * @return - enhetens id
	 */
	public String getId() {
		return id;
	}
	/**
	 * set-metode for enhetens id
	 * @param id- enhetens id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
