package credentials;

public class OldPasswordConflictException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int passwordConflictIndex;
	
	public OldPasswordConflictException(String msg, int passwordConflictIndex) {
		super(msg);
		this.passwordConflictIndex = passwordConflictIndex;
	}
	
	public int getPasswordConflictIndex(){ 
		return passwordConflictIndex;
	}

}
