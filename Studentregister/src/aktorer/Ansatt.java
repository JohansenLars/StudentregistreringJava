package aktorer;

import java.io.Serializable;
import java.util.ArrayList;

import medlemmer.Enhet;

public class Ansatt extends Person implements Serializable {
	
	private static final long serialVersionUID = 4797815798718699768L;
	private ArrayList<Enhet> enheter = new ArrayList<>();
	
	/**
	 * Oppretter object av typen Ansatt
	 * @param fNavn - Setter fornavn
	 * @param eNavn - setter etternavn
	 * @param iD - setter ID
	 */
	public Ansatt(String fNavn, String eNavn, String iD) {
		super(fNavn, eNavn, iD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		return getfNavn() + " " + geteNavn();
	}
	

	/**
	 * get-metode for ArrayListen Enheter
	 * @return Enheter
	 */
	public ArrayList<Enhet> getEnheter() {
		return enheter;
	}


}
