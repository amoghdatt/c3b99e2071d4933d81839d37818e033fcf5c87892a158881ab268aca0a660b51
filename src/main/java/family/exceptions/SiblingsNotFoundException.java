package family.exceptions;

public class SiblingsNotFoundException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public SiblingsNotFoundException(String error) {
        super(error);
    }
}
