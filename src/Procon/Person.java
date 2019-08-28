package Procon;

public class Person {
    private String NAME;
    private String LOCATION;
    private Exam EXAM;

    @Override
    public String toString() {
        return NAME + " - " + LOCATION + " (" + EXAM + ")";
    }

    public String getNAME() {
        return NAME;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public Exam getEXAM() {
        return EXAM;
    }
}
