package projektDatabaze;

public class techStudent extends Student{
	public techStudent(String jmeno, String prijmeni, int rok, int mesic, int den) {
		super (jmeno, prijmeni, rok, mesic, den);
	}
	public boolean prestupnyRok() {
		if ((this.rok%4) == 0) {
			return true;
		}
		return false;
	}
	@Override
	public void znameniKruhu() {}
}