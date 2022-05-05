package projektDatabaze;

public class znamkaException extends java.lang.Exception {
	public znamkaException() {
		super("Nezadana zadna znamka");
	}
	public znamkaException(String text) {
		super(text);	
	}

}
