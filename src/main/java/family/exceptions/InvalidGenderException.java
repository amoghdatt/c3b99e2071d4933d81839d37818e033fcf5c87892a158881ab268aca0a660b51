package family.exceptions;

public class InvalidGenderException extends Exception{

    /**
	 *
	 */
	private static final long serialVersionUID = -8582139269388666790L;

	public InvalidGenderException(String error){
        super(error);
    }
}
