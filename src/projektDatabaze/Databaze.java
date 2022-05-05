package projektDatabaze;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Databaze {
	public Databaze(int pocetPrvku) {
		prvkyDatabaze=new HashMap<Integer,Student>();
		sc=new Scanner(System.in);
	}
	public void vlozeniStudentu() throws znamkaException {
		prvkyDatabaze.put(1, new techStudent("petr", "brablik", 2000, 1, 1));
		prvkyDatabaze.get(1).setZnamky(1);
		prvkyDatabaze.get(1).setZnamky(1);
		prvkyDatabaze.get(1).setZnamky(1);
		prvkyDatabaze.put(2, new humStudent("jan", "hoj", 1902, 12, 20));
		prvkyDatabaze.get(2).setZnamky(1);
		prvkyDatabaze.get(2).setZnamky(2);
		prvkyDatabaze.put(3, new humStudent("ahoj", "vura", 5743, 9, 18));
		prvkyDatabaze.get(3).setZnamky(1);
		prvkyDatabaze.get(3).setZnamky(4);
		prvkyDatabaze.put(4, new obStudent("test", "fjdsl", 2371, 4, 3));
		prvkyDatabaze.get(4).setZnamky(1);
		prvkyDatabaze.get(4).setZnamky(2);
		prvkyDatabaze.get(4).setZnamky(3);
		prvkyDatabaze.get(4).setZnamky(4);
	}
	
	public void setStudent() throws znamkaException {
		System.out.println("Chcete pøidat studenta technického (1) nebo humanitního oboru (2) nebo studenta obou oborù (3)?");
		int volba = sc.nextInt();
		String jmeno;
		String prijmeni;
		int rok;
		int mesic;
		int den;
		int idx;
		switch (volba) {
		case 1:
			System.out.println("Zadejte index, jmeno, prijmeni, a datum narozeni studenta");
			idx = Test.pouzeCelaCisla(sc);
			jmeno=sc.next();
			prijmeni = sc.next();
			rok=Test.pouzeCelaCisla(sc);
			mesic=Test.pouzeCelaCisla(sc);
			den=Test.pouzeCelaCisla(sc);
			prvkyDatabaze.put(idx, new techStudent(jmeno, prijmeni, rok, mesic, den));
			prvkyDatabaze.get(idx).setZnamky(1);
			posledniStudent++;
			break;
		case 2:
			System.out.println("Zadejte index, jmeno, prijmeni, a datum narozeni studenta");
			idx = Test.pouzeCelaCisla(sc);
			jmeno=sc.next();
			prijmeni = sc.next();
			rok=Test.pouzeCelaCisla(sc);
			mesic=Test.pouzeCelaCisla(sc);
			den=Test.pouzeCelaCisla(sc);
			prvkyDatabaze.put(idx, new humStudent(jmeno, prijmeni, rok, mesic, den));
			prvkyDatabaze.get(idx).setZnamky(1);
			posledniStudent++;
			break;
		case 3:
			System.out.println("Zadejte index, jmeno, prijmeni, a datum narozeni studenta");
			idx = Test.pouzeCelaCisla(sc);
			jmeno=sc.next();
			prijmeni = sc.next();
			rok=Test.pouzeCelaCisla(sc);
			mesic=Test.pouzeCelaCisla(sc);
			den=Test.pouzeCelaCisla(sc);
			prvkyDatabaze.put(idx, new obStudent(jmeno, prijmeni, rok, mesic, den));
			prvkyDatabaze.get(idx).setZnamky(1);
			posledniStudent++;
			break;
		}
	}
	
	public Student getStudent(int idx) {
		return prvkyDatabaze.get(idx);
	}
	
	public boolean schopnostRok(int idx) {
		return prvkyDatabaze.get(idx).prestupnyRok();
	}
	
	public void schopnostKruh(int idx) {
		prvkyDatabaze.get(idx).znameniKruhu();
	}
	
	public void setZnamka(int idx, int znamka) throws znamkaException {
		if (prvkyDatabaze.get(idx)==null)
			throw new znamkaException();;
		prvkyDatabaze.get(idx).setZnamky(znamka);
	}
	
	public boolean ulozDatabazi(String jmenoSouboru) throws znamkaException {
		try {
			FileWriter fw = new FileWriter(jmenoSouboru);
			BufferedWriter out = new BufferedWriter(fw);			
			for (Integer i : prvkyDatabaze.keySet()) {
				out.write(i +","+prvkyDatabaze.get(i).getJmeno() +"," + prvkyDatabaze.get(i).getPrijmeni() +"," 
						+ prvkyDatabaze.get(i).getRok()+","+prvkyDatabaze.get(i).getDen()+","
						+ prvkyDatabaze.get(i).getMesic());
				out.newLine();
				}
			out.close();
			fw.close();
		}
		catch (IOException e) {
			System.out.println("Soubor nelze vytvorit");
			return false;
		}
		return true;
	}
	public boolean nactiDatabazi(String jmenoSouboru) throws FileNotFoundException {
		Path pathToFile = Paths.get(jmenoSouboru);
		 File soubor = new File(jmenoSouboru);
		 if (soubor.exists()) {
	            try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)){
	                String radek = br.readLine();
	                while (radek != null) {
	                    String[] atributy = radek.split(",");
	                    int idx = Integer.parseInt(atributy[0]);
	                    String jmeno = atributy[1];
	                    String prijmeni = atributy[2];
	                    int rok = Integer.parseInt(atributy[3]);
	                    int mesic = Integer.parseInt(atributy[4]);
	                    int den = Integer.parseInt(atributy[5]);
	                    prvkyDatabaze.put(idx, new techStudent(jmeno, prijmeni, rok, mesic, den));
	                    radek = br.readLine();

	                }
	                return true;
	            } catch(IOException e) {e.printStackTrace();}
	                System.out.println("Data ze souboru byla úspìšnì nahrána do databáze");
	        }else {
	            System.out.println("Soubor neexistuje nejdøív nahrajte data do souboru");
	        }
		 return false;
	}
	
	public void vypisDatabazi() throws znamkaException {		
		for (Integer i : prvkyDatabaze.keySet()) {
			System.out.println(prvkyDatabaze.get(i).getJmeno() +" " + prvkyDatabaze.get(i).getPrijmeni() +" " 
					+ "datum narozeni: "+ prvkyDatabaze.get(i).getDen()+"."+ prvkyDatabaze.get(i).getMesic() + "." + 
					prvkyDatabaze.get(i).getRok()+" " + prvkyDatabaze.get(i).getZnamky() + 
					" prumer:"+ prvkyDatabaze.get(i).vypoctiPrumer());
			}
	}
	public void smazat(int idx) {
		prvkyDatabaze.remove(idx);
		System.out.println("student smazan");
	}
	
	public void prumerOboru() {
		float pocTech = 0;
		float soucetTech = 0;
		
		float pocHum = 0;
		float soucetHum = 0;
		
		for (Integer i : prvkyDatabaze.keySet()) {
			if (prvkyDatabaze.get(i) instanceof techStudent) {
				pocTech++;
				float docasny = prvkyDatabaze.get(i).vypoctiPrumer();
				soucetTech = soucetTech + docasny;
			}
			if (prvkyDatabaze.get(i) instanceof humStudent) {
				pocHum++;
				float docasny = prvkyDatabaze.get(i).vypoctiPrumer();
				soucetHum = soucetHum + docasny;
			}
			if (prvkyDatabaze.get(i) instanceof obStudent) {
				pocTech++;
				pocHum++;
				float docasny = prvkyDatabaze.get(i).vypoctiPrumer();
				soucetTech = soucetTech + docasny;
				soucetHum = soucetHum + docasny;
			}
		}
		float prumerTech = soucetTech/pocTech;
		System.out.println("technicky obor " + prumerTech);
		float prumerHum = soucetHum/pocHum;
		System.out.println("humanitni obor " + prumerHum);
	}
	public void pocetOboru() {
		int pocTech = 0;
		int pocHum = 0;
		int pocOb = 0;
		for (Integer i : prvkyDatabaze.keySet()) {
			if (prvkyDatabaze.get(i) instanceof techStudent)
				pocTech++;
			if (prvkyDatabaze.get(i) instanceof humStudent)
				pocHum++;
			if (prvkyDatabaze.get(i) instanceof obStudent)
				pocOb++;
		}
		System.out.println("technicky obor " + pocTech);
		System.out.println("humanitarni obor " + pocHum);
		System.out.println("kombinovany obor " + pocOb);
	}
	
	public void vypsaniDoDatabaze() {
		int idx = 0;
		String obor = "ahoj";
		SqlConnection pripojeni = new SqlConnection();
		for (Integer i : prvkyDatabaze.keySet()) {
			idx++;
			pripojeni.insertToSQL(idx, prvkyDatabaze.get(i).getJmeno(), prvkyDatabaze.get(i).getPrijmeni(), 
					prvkyDatabaze.get(i).vypoctiPrumer(), obor, prvkyDatabaze.get(i).getDen(), 
					prvkyDatabaze.get(i).getMesic(), prvkyDatabaze.get(i).getRok());
			}
	}
	public void stazeniDatabaze() {
		SqlConnection pripojeni = new SqlConnection();
		for (int i = 0; i < 10; i++) {
			pripojeni.loadFromSQL(i);
		}
	}
	
	private Scanner sc;
	private Map<Integer,Student> prvkyDatabaze;
	private int posledniStudent;
	
}