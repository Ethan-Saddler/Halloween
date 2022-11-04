/**
 * @author esaddler3
 * @version 1.0
 * An child class of PersonOfInterest that represents an accomplice to a suspect.
 */
public class Accomplice extends PersonOfInterest {
    private boolean canCode;
    /**
     * A constructor that calls teh super constructor.
     * @param hairColor hair color of the suspect.
     * @param proximity the miles from the crime scene.
     * @param rubberDuck a RubberDuck object.
     * @param canCode a boolean representing whether the accomplice can code.
     */
    public Accomplice(Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }
    @Override
    public String toString() {
        return String.format("Possible Accomplice: %s They %s have the ability to hack doorbells.", super.toString(),
                canCode ? "do" : "do not");
    }
    @Override
    public boolean equals(Object obj) {
        // make sure classes being different is not messing up method
        if (super.equals(obj)) {
            Accomplice accomplice = (Accomplice) obj;
            return this.canCode == accomplice.canCode;
        }
        return false;
    }
    /**
     * Getter method that returns whether an accomplice can code.
     * @return boolean representing whether an accomplice can code.
     */
    public boolean getCode() {
        return canCode;
    }
}
