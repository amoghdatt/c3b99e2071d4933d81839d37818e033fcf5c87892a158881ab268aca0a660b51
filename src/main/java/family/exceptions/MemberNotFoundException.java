package family.exceptions;

public class MemberNotFoundException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 4752416862390664423L;

    public MemberNotFoundException(String error) {
        super(error);
    }
}
