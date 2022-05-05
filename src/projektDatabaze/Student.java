package projektDatabaze;
import java.util.ArrayList;

abstract class Student {
	public Student(String jmeno, String prijmeni, int rok, int mesic, int den) {
		this.jmeno=jmeno;
		this.prijmeni=prijmeni;
		this.rok=rok;
		this.mesic=mesic;
		this.den=den;
	}
	
	public String getJmeno() {
		return jmeno;
	}
	
	public String getPrijmeni() {
		return prijmeni;
	}

	public int getRok() {
		return rok;
	}
	public int getMesic() {
		return mesic;
	}

	public void setMesic(int mesic) {
		this.mesic = mesic;
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		this.den = den;
	}
	
	public ArrayList<Integer> getZnamky() throws znamkaException {
		if (Znamky.size()==0)
			throw new znamkaException();
		return Znamky;
	}

	public void setZnamky(int Znamka) throws znamkaException {
		if (Znamka<1||Znamka>5)
			throw new znamkaException("Zadana spatna znamka");
		Znamky.add(Znamka);
	}
	public float vypoctiPrumer() {
		float pocet = Znamky.size();
		float soucet = 0;
		for (float i : Znamky) {
			soucet = soucet + i;
		}
		float prumer = soucet/pocet;
		return prumer;
	}
	public boolean prestupnyRok() {
		return false;
	}
	abstract public void znameniKruhu();
	

	private String jmeno;
	private String prijmeni;
	protected int rok;
	protected int mesic;
	protected int den;
	private ArrayList<Integer> Znamky = new ArrayList<Integer>();
}
