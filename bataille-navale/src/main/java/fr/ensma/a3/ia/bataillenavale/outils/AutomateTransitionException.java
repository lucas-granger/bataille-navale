package fr.ensma.a3.ia.bataillenavale.outils;

public class AutomateTransitionException extends Exception {

    private String message;

    public AutomateTransitionException() {}
    public AutomateTransitionException(final String mess) {
        message = mess;
    }

    @Override
    public String getMessage() {
        return message + " --> " + super.getMessage();
    }
}
