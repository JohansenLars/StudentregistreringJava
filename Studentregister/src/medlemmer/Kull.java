package medlemmer;

import java.io.Serializable;
import java.util.ArrayList;

import aktorer.Fagansatt;

public class Kull implements Serializable{
	private static final long serialVersionUID = 5937557212355577258L;
	private String startaar;
	 private Fagansatt ansvarlig;
	 public static ArrayList<Kull> kull = new ArrayList<>();
	/**
	 * Oppretter Kull-objekt
	 * @param startaar - setter startår
	 * @param ansvarlig - setter Fagansvarlig
	 */
	 public Kull(String startaar, Fagansatt ansvarlig) {
		 this.startaar = startaar;
		 this.ansvarlig = ansvarlig;
		 kull.add(this);
	
	 }
	 @Override
	 public String toString(){
		 return getStartaar() +  " - Fagansvarlig: " + getAnsvarlig();
	 }

	public String getStartaar() {
		return startaar;
	}

	public void setStartaar(String startaar) {
		this.startaar = startaar;
	}

	public Fagansatt getAnsvarlig() {
		return ansvarlig;
	}

	public void setAnsvarlig(Fagansatt ansvarlig) {
		this.ansvarlig = ansvarlig;
	} 
}

