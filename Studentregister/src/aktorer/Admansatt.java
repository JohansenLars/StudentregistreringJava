package aktorer;

import java.io.Serializable;

public class Admansatt extends Ansatt implements Serializable {

	
	private static final long serialVersionUID = 7226545863599570134L;
	/**
	 * Constructor
	 * Oppretter Admansatt
	 * 
	 * @param fNavn - Setter fornavn
	 * @param eNavn - Setter etternavn
	 * @param iD - setter id
	 */
	public Admansatt(String fNavn, String eNavn, String iD) {
		super(fNavn, eNavn, iD);
		// TODO Auto-generated constructor stub
	}

}
