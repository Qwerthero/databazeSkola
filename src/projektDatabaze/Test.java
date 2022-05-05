package projektDatabaze;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {
	public static int pouzeCelaCisla(Scanner sc) {
		int cislo = 0;
		try {
			cislo = sc.nextInt();
		}
		catch(Exception e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	public static float pouzeCisla(Scanner sc) {
		float cislo = 0;
		try {
			cislo = sc.nextFloat();
		}
		catch(Exception e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}

	public static void main(String[] args) throws znamkaException, FileNotFoundException {	
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		int idx;
		int znamka;
		int volba;
		boolean run=true;
		while(run) {
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni nove znamky studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. ulozeni do souboru");
			System.out.println("6 .. nacteni ze souboru");
			System.out.println("7 .. vypis databaze");
			System.out.println("8 .. propusteni studenta");
			System.out.println("9 .. aktivace schopnosti studenta");
			System.out.println("10 .. vypis obecneho prumeru oboru");
			System.out.println("11 .. vypis poctu studentu v oboru");
			System.out.println("12 .. ukonceni aplikace");
			System.out.println("13 .. ulozeni do databaze");
			System.out.println("14 .. stazeni z databaze");
			System.out.println("20.. vlozeni testovacích studentù");
			volba=pouzeCelaCisla(sc);
			switch(volba) {
				case 1:
					System.out.println("Zadejte pocet studentu");
					mojeDatabaze=new Databaze(pouzeCelaCisla(sc));
					break;
				case 2:
					try {
						mojeDatabaze.setStudent();
					}
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Nebylo mozno vytvorit novou polozku, databaze je plna");
					}
					break;
				case 3:
					System.out.println("Zadejte index a novou znamku studenta");
					idx= pouzeCelaCisla(sc);
					znamka = pouzeCelaCisla(sc);
					try {
						mojeDatabaze.setZnamka(idx,znamka);
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Vybrana polozka mimo rozsah databaze");
					}
					catch (NullPointerException e) {
						System.out.println("Vybrana polozka neexistuje");
					} 
					catch (znamkaException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Zadejte index studenta");
					idx=pouzeCelaCisla(sc);
					Student info = null;
					try {	
						info=mojeDatabaze.getStudent(idx);
						System.out.println("Jmeno: " + info.getJmeno() +" Prijmeni: " + info.getPrijmeni() +
								" datum narozeni: "+ info.getDen()+"."+ info.getMesic() + "." + 
								info.getRok() +" znamky: " + info.getZnamky() +	" prumer: " + info.vypoctiPrumer());
					}
					catch (znamkaException e) {
						System.out.println("Jmeno: " + info.getJmeno() + " datum narozeni: " + info.getZnamky() + " zadne znamky");
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Vybrana polozka mimo rozsah databaze");
					}
					catch (NullPointerException e) {
						System.out.println("Vybrana polozka neexistuje");
					}
					break;
				case 5:
					System.out.println("Zadejte jmeno souboru");
					if (mojeDatabaze.ulozDatabazi(sc.next()))
						System.out.println("Databaze ulozena");
					else
						System.out.println("Databazi nebylo mozno ulozit");
					break;
				case 6:
					System.out.println("Zadejte jmeno souboru");
					String soub = sc.next();
					if (mojeDatabaze.nactiDatabazi(soub))
						System.out.println("Databaze nactena");
					else
						System.out.println("Databazi nebylo mozno nacist");
					break;
				case 7:
					mojeDatabaze.vypisDatabazi();
					break;
				case 8:
					System.out.println("Zadejte index studenta, ktereho chcete smazat");
					idx= pouzeCelaCisla(sc);
					mojeDatabaze.smazat(idx);
					break;
				case 9:
					System.out.println("zadejte index studenta, ktereho chcete vyzkouset");
					idx= pouzeCelaCisla(sc);
					System.out.println(mojeDatabaze.getStudent(idx).getClass().getName());
					if (mojeDatabaze.getStudent(idx) instanceof techStudent) {
						System.out.println(mojeDatabaze.schopnostRok(idx));
					}
					else if (mojeDatabaze.getStudent(idx) instanceof humStudent) {
						mojeDatabaze.schopnostKruh(idx);
					}
					else if (mojeDatabaze.getStudent(idx) instanceof obStudent) {
						mojeDatabaze.schopnostKruh(idx);
						System.out.println(mojeDatabaze.schopnostRok(idx));
					}
					break;
				case 10:
					mojeDatabaze.prumerOboru();
					break;
				case 11:
					mojeDatabaze.pocetOboru();
					break;
				case 12:
					run=false;
					break;
				case 13:
					mojeDatabaze.vypsaniDoDatabaze();
					break;
				case 14:
					mojeDatabaze.stazeniDatabaze();
					break;
				case 20:
					mojeDatabaze.vlozeniStudentu();
					break;
			}
			
		}
	}

}