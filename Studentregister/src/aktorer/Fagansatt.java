package aktorer;

import java.io.Serializable;
import java.util.ArrayList;

import medlemmer.Kull;

public class Fagansatt extends Ansatt implements Serializable {

	private static final long serialVersionUID = -8046109123024516099L;
	private ArrayList<Kull> kull = new ArrayList();
	/**
	 * Oppretter Fagansatt-objekt
	 * @param fNavn - setter fornavn
	 * @param eNavn - setter etternavn
	 * @param iD - setter D
	 */
	public Fagansatt(String fNavn, String eNavn, String iD) {
		super(fNavn, eNavn, iD);
		
	}
	
	@Override
	public String toString(){
		return getfNavn() + " " + geteNavn();
	}
	
	}

	
