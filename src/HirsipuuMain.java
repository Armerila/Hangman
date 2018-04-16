

import java.io.IOException;
import java.util.*;

public class HirsipuuMain {
	static Scanner syote = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		//uusi sanalista tiedostosta
		Sanalista sanalista = new Sanalista("soittimet.txt");
		//sanojen säilytykseen
		List<String> sanat = sanalista.annaSanat();
		//uusi hirsipuupeli kuudella arvauksella
		Hirsipuu hirsipuu = new Hirsipuu (6, sanat);
		String piilosana = "";	
		//kutsuu hirsipuussa arvotun sanan
		String salasana = hirsipuu.sana();
		//apumuuttuja pieneen kirjaimeen vaihtamiseen
		Character kirjain;
		Character kirjainIso;
		
		
		//luo salasanan "***" muotoon
		for (int i = 0; i < salasana.length(); i++) {
			piilosana = ""+ piilosana +"*";
		}
		//Stringbuilder helpompaan merkkijonojen käsittelyyn
		StringBuilder arvattusana = new StringBuilder (piilosana);
		
		
		System.out.println("Tervetuloa hirsipuupeliin!");
		do {
		System.out.println("Arvaa kirjain sanasta "+arvattusana);
		kirjainIso = syote.nextLine().charAt(0);
		kirjain = Character.toLowerCase(kirjainIso);
		
		//tarkistaa arvauslistasta onko syotettu kirjain jo syotettu
		if (hirsipuu.arvaukset().contains(kirjain)) {
			System.out.println("Olet jo arvannut kirjaimen "+kirjain);
			continue;
		}
			//kutsuu/tulostaa arvaa metodia syottojen yhteydessa, laskee/kirjaa arvaukset
			hirsipuu.arvaa(kirjain);
			System.out.println("Olet arvannut seuraavat kirjaimet: "+hirsipuu.arvaukset());
			
				//vertaa syotettua kirjainta salaiseen sanaan ja korvaa tahdet osumien kohdalta
				for ( int i = 0; i < salasana.length(); i++ ) {
					if(salasana.charAt(i) == kirjain) {
						arvattusana.setCharAt(i, kirjain);
					}
				}
			// tarkistaa onko sana kokonaan arvattu,	
			if (salasana.equals(arvattusana.toString())) {
				System.out.println("Voitit pelin! Sana on "+salasana); 
				break;
			}
		//peli loppuu kun arvaukset loppuu
		}while (!hirsipuu.onLoppu());
	}
}