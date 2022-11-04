/**
 * @author esaddler3
 * @version 1.0
 * A class that extends PersonOfInterest representing a suspect who can be stored at police station.
 */
public class Suspect extends PersonOfInterest {
    private int height = 150;

    /**
     * A constructor that checks to make sure height is above otherwise it will remain 150.
     * @param hairColor hair color of the suspect.
     * @param proximity the miles from the crime scene.
     * @param rubberDuck a RubberDuck object.
     * @param height the height in cm of suspect.
     */
    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);

        if (height > 150) {
            this.height = height;
        }
    }
    /**
     * A constructor that sets height default to 160.
     * @param proximity the miles from the crime scene.
     * @param rubberDuck a RubberDuck object.
     */
    public Suspect(int proximity, RubberDuck rubberDuck) {
        super(proximity, rubberDuck);
        this.height = 160;
    }
    @Override
    public String toString() {
        return String.format("Possible Suspect: %s They were observed to be %d cm tall.%n%n", super.toString(), height);
    }
    @Override
    public boolean equals(Object obj) {
        // make sure classes being different is not messing up method
        if (super.equals(obj)) {
            Suspect suspect = (Suspect) obj;
            return this.height == suspect.height;
        }
        return false;
    }
}