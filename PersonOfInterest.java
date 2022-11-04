/**
 * @author esaddler3
 * @version 1.0
 * A class representing a potential person of interest for a police station. Impliments comparable.
 */
public class PersonOfInterest implements Comparable<PersonOfInterest> {
    private Color hairColor;
    private int proximity;
    private RubberDuck rubberDuck;

    /**
     * A constructor that sets proximity to absolute value of input and rubber duck to YELLOW and true if null.
    * @param proximity the miles from the crime scene.
    * @param rubberDuck a RubberDuck object.
        */
    public PersonOfInterest(int proximity, RubberDuck rubberDuck) {
        this.hairColor = Color.BLONDE;
        this.proximity = proximity < 0 ? proximity * -1 : proximity;
        if (rubberDuck == null) {
            this.rubberDuck = new RubberDuck(Color.YELLOW, true);
        } else {
            this.rubberDuck = rubberDuck;
        }
    }
    /**
     * A constructor that calls 2-arg contructor and sets hair color to black if null.
     * @param hairColor hair color of the suspect.
     * @param proximity the miles from the crime scene.
     * @param rubberDuck a RubberDuck object.
     */
    public PersonOfInterest(Color hairColor, int proximity, RubberDuck rubberDuck) {
        this(proximity, rubberDuck);
        if (hairColor == null) {
            this.hairColor = Color.BLACK;
        } else {
            this.hairColor = hairColor;
        }
    }
    @Override
    public String toString() {
        return String.format("A POI with %s hair was last seen %d miles away holding %s", hairColor.toString(),
                proximity, rubberDuck.toString());
    }
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        PersonOfInterest poi = (PersonOfInterest) obj;
        if (this.hairColor == poi.hairColor && this.proximity == poi.proximity
                && this.rubberDuck.equals(poi.rubberDuck)) {
            return true;
        }
        return false;
    }
    /**
     * Implimentation of compareTo that compares two persons of interest.
     * @param poi PersonOfInterest to be compared to this object.
     * @return an integer representing result of the comparison.
     */
    public int compareTo(PersonOfInterest poi) {
        if (poi == null) {
            return -1;
        }
        if (this.proximity == poi.proximity && this.hairColor == poi.hairColor) {
            return 0;
        }
        if (this.proximity < poi.proximity) {
            return -1;
        } else if (this.proximity > poi.proximity) {
            return 1;
        }
        return this.hairColor.compareTo(poi.hairColor);
    }
    /**
     * getter method for rubberduck object.
     * @return RubberDuck of this person of interest.
     */
    public RubberDuck getDuck() {
        return rubberDuck;
    }
}