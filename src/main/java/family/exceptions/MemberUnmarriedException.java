package family.exceptions;

public class MemberUnmarriedException extends Exception{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MemberUnmarriedException(String error) {
        super(error);
    }
}
