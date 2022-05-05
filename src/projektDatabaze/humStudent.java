package projektDatabaze;

public class humStudent extends Student{
	public humStudent(String jmeno, String prijmeni, int rok, int mesic, int den) {
		super (jmeno, prijmeni, rok, mesic, den);
	}
	@Override
	public void znameniKruhu() {
		if((this.mesic == 4) || (this.mesic == 3)) {
			System.out.println("beran");
		}
		else if((this.mesic == 5) || (this.mesic == 4)) {
			System.out.println("byk");
		}
		else if((this.mesic == 6) && (this.mesic == 5)) {
			System.out.println("blizenci");
		}
		else if((this.mesic == 7) && (this.mesic == 6)) {
			System.out.println("rak");
		}
		else if((this.mesic == 8) && (this.mesic == 7)) {
			System.out.println("lev");
		}
		else if((this.mesic == 8) && (this.mesic == 9)) {
			System.out.println("panna");
		}
		else if((this.mesic == 10) && (this.mesic == 9)) {
			System.out.println("vahy");
		}
		else if((this.mesic == 11) && (this.mesic == 10)) {
			System.out.println("stir");
		}
		else if((this.mesic == 12) && (this.mesic == 11)) {
			System.out.println("strelec");
		}
		else if(((this.mesic == 12) || (this.mesic == 1))) {
			System.out.println("kozoroh");
		}
		else if((this.mesic == 2) && (this.mesic == 1)) {
			System.out.println("vodnar");
		}
		else if((this.mesic == 3) && (this.mesic == 2)) {
			System.out.println("ryby");
		}
		else {
			System.out.println("zadny");
		}
	}
}

/*
Beran
21.3. – 19.4.
Býk
20.4. – 20.5.
Blíženci
21.5. – 21.6.
Rak
22.6. – 22.7.
Lev
23.7. – 22.8.
Panna
23.8. – 22.9.
Váhy
23.9. – 23.10.
Štír
24.10. – 22.11.
Støelec
23.11. – 21.12.
Kozoroh
22.12. – 20.1.
Vodnáø
21.1. – 18.2.
Ryby
19.2. – 20.3.	
*/