import java.util.*;

public class Hirsipuu {
	private int arvaukset = 0;
	List <String> sanat;
	List<Character> arvausLista = new ArrayList<Character>();
	String salasana = "";
	
	
	public Hirsipuu (int arvaukset, List<String> sanat) {
		this.arvaukset = arvaukset;
		this.sanat = sanat;
		Collections.shuffle(sanat);
		salasana = sanat.get(0);
	}
	
	public boolean arvaa (Character merkki) {
		if (salasana.indexOf(merkki) >= 0) {
			System.out.println("Syotettu merkki "+merkki+" on sanassa!");
			arvausLista.add(merkki);
			return true;
		}
		else  {
			arvaukset--;
			arvausLista.add(merkki);
			System.out.println("Syotettua merkkia ei loytynyt, arvausten maara: "+arvaukset);
			return false;
		}
	}
	
	public List<Character> arvaukset () {
		return arvausLista;
	}
	
	public int arvauksiaOnjajljella() {
		return arvaukset;
	}
	
	public String sana() {
		return salasana;
	}
	
	public boolean onLoppu () {
		if (arvaukset <= 0) {
			System.out.println("Peli on loppu. Sana oli: "+salasana);
			return true;
		}
		else {
			return false;
		}
	}

}
