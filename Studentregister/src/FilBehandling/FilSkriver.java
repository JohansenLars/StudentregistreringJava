package FilBehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import medlemmer.Kull;

/**
 * 
 * @author Lali
 *
 *String path
 *String cmd
 *
 *Får inn path og kommando for lesing type "Kurs" eller "Student"
 *
 */
public class FilSkriver {
	private String path;
	private String cmd;
	
	
	public FilSkriver(String path, String cmd){
		this.path = path;
		this.cmd = cmd;
		checkCmd();
	}
	private void checkCmd(){
		switch(cmd){
		case("Kull"):
			writeKull();
			break;
		case("Ansatt"):
			writeAnsatt();
			break;
		default:
			System.out.println("Error");
		}
	}
	private void writeKull(){
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Kull k: Kull.kull){
				bw.write(k.getStartaar() + "¤" + k.getAnsvarlig());
				bw.newLine();
				bw.close();
				fw.close();
			}
			} 
		catch (IOException e) {
			System.out.println(e);
		}
	}
	private void writeAnsatt(){}
}
