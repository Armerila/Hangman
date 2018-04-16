import java.util.*;
import java.io.*;

public class Sanalista {
	private String fileName;
	
	public List<String> annaSanat () throws IOException {
		List <String> sanat = new ArrayList<String>();
		BufferedReader reader = new BufferedReader (new FileReader(fileName));
		String rivi; 
			while ((rivi = reader.readLine()) != null){
				sanat.add(rivi);
			}
		reader.close();
		return sanat;
		}
	
	
	public List<String> sanatJoidenPituusOn (int pituus) throws IOException {
		List <String> uudetsanat = new ArrayList<String>();
		List <String> sanat = annaSanat();
		for (int i = 0; i < sanat.size(); i++) {
			if(sanat.get(i).length() == pituus) {
				uudetsanat.add(sanat.get(i));
			}
		}
		return uudetsanat;
	}  
	/*
	public List<String> sanaJoissaMerkit (String mjono) throws IOException {
		List <String> sanat = annaSanat();
		List <String> uudetsanat = new ArrayList<String>();
		for (int i = 0; i < sanat.size(); i++) {
			System.out.println(sanat.get(i));
				for ( int j = 0; j < sanat.get(i).length(); j++) {
				}
		}
			return uudetsanat;		

	} */
	
	//sanalista konstruktori
	public Sanalista (String fileName) throws IOException {
		this.fileName = fileName;	
	}
}
		

	
	


