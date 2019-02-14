package aktorer;

import java.io.Serializable;
import java.util.ArrayList;
public class Person implements Serializable{

	private static final long serialVersionUID = -3499031886317169592L;
private String fNavn;
 private String eNavn;
 private String iD;
 public static ArrayList<Person> personer = new ArrayList<>();
/**
 * Oppretter Person-objekt
 * @param fNavn - setter fornavn
 * @param eNavn - setter etternavn
 * @param iD - setter ID
 */
 public Person(String fNavn, String eNavn, String iD) {
	super();
	this.fNavn = fNavn;
	this.eNavn = eNavn;
	this.iD = iD;
	personer.add(this);
}
 /**
  * get-metode for personens fornavn
  * @return fornavn
  */
public String getfNavn() {
	return fNavn;
}
/**
 * set-metode for personens fornavn
 * @param fNavn- foprnavn
 */
public void setfNavn(String fNavn) {
	this.fNavn = fNavn;
}
/**
 * get-metode for personens etternavn
 * @return etternavn
 */
public String geteNavn() {
	return eNavn;
}
/**
 * set-metode for perosnens etternavn
 * @param eNavn - etternavn
 */
public void seteNavn(String eNavn) {
	this.eNavn = eNavn;
}
/**
 * get-metode for personens id
 * @return id
 */
public String getId() {
	return iD;
}
/**
 * set-metode for personens id
 * @param id - id
 */
public void setId(String id) {
	this.iD = iD;
}

 
}

