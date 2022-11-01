public class Suspect extends PersonOfInterest {
    private int height = 150;

    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);

        if (height > 150) {
            this.height = height;
        }
    }
    public Suspect(int proximity, RubberDuck rubberDuck) {
        super(proximity, rubberDuck);
        this.height = 160;
    }
    public String toString() {
        return String.format("Possible Suspect: %s They were observed to be %d cm tall.", super.toString(), height);
    }
    public boolean equals(Object obj) {
    // make sure classes being different is not messing up method
        if (super.equals(obj) == true) {
            Suspect suspect = (Suspect) obj;
            return this.height == suspect.height;
        }
        return false;
    }
}