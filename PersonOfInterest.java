public class PersonOfInterest implements Comparable<PersonOfInterest> {
    private Color hairColor;
    private int proximity;
    private RubberDuck rubberDuck;

    public PersonOfInterest(int proximity, RubberDuck rubberDuck) {
        this.hairColor = Color.BLONDE;
        this.proximity = proximity < 0 ? proximity * -1 : proximity;
        if (this.rubberDuck == null) {
            this.rubberDuck = new RubberDuck(Color.YELLOW, true);
        } else {
            this.rubberDuck = rubberDuck;
        }
    }

    public PersonOfInterest(Color hairColor, int proximity, RubberDuck rubberDuck) {
        this(proximity, rubberDuck);
        if (hairColor == null) {
            this.hairColor = Color.BLACK;
        } else {
            this.hairColor = hairColor;
        }
    }

    public String toString() {
        return String.format("A POI with %s hair was last seen %d miles away holding %s",
            hairColor.toString(), proximity, rubberDuck.toString());
    }
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        PersonOfInterest poi = (PersonOfInterest) obj;
        if (this.hairColor == poi.hairColor && this.proximity == poi.proximity && this.rubberDuck.equals(poi.rubberDuck)) {
            return true;
        }
        return false;
    }
    public int compareTo(PersonOfInterest poi) {
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
    public RubberDuck getDuck() {
        return rubberDuck;
    }
}