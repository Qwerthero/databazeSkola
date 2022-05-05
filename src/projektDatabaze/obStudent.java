package projektDatabaze;

public class obStudent extends Student{
	public obStudent(String jmeno, String prijmeni, int rok, int mesic, int den) {
		super (jmeno, prijmeni, rok, mesic, den);
	}

	public boolean prestupnyRok(int narozeni) {
		if ((narozeni%4) == 0) {
			return true;
		}
		return false;
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