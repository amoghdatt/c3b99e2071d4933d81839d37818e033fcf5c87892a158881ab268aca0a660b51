package family.exceptions;

public class IllegalParentException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public IllegalParentException(String error) {
        super(error);
    }
}
