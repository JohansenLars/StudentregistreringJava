package aktorer;

import java.io.Serializable;

import medlemmer.Enhet;
import medlemmer.Kull;

public class Elev extends Person implements Serializable {

	private static final long serialVersionUID = -4436536562795708849L;
	private Kull kull;
	private Enhet enhet;
	/**
	 * Oppretter Elev-objekt
	 * @param fNavn - Setter fornavn
	 * @param eNavn - setter etternavn
	 * @param iD - setter D
	 * @param kull - setter kull
	 */
	public Elev(String fNavn, String eNavn, String iD, Kull kull) {
		super(fNavn, eNavn, iD);
		this.enhet = enhet;
		this.kull = kull;
	}
	/**
	 * get-metode for elevens kull
	 * @return kullobjekt
	 */
	public Kull getKull() {
		return kull;
	}
	/**
	 * set-metode for elevens kull
	 * @param kull - kull-objekt
	 */
	public void setKull(Kull kull) {
		this.kull = kull;
	}
	/**
	 * get-metode for elevens lånte enhet
	 * @return - enhet objekt
	 */
	public Enhet getEnhet() {
		return enhet;
	}
	/**
	 * set-metode for elevens lnte enhet
	 * @param enhet - enhet-objekt
	 */
	public void setEnhet(Enhet enhet) {
		this.enhet = enhet;
	}

	@Override
	public String toString() {
		return  getfNavn() + " " + geteNavn();
	}
	
	
	
	}
	
	

