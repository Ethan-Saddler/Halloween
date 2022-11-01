import java.lang.Math;

public class PersonOfInterest implements Comparable<PersonOfInterest> {
    protected Color hairColor;
    protected int proximity;
    protected RubberDuck rubberDuck;

    public PersonOfInterest(int proximity, RubberDuck rubberDuck) {
        this.hairColor = Color.BLONDE;
        this.proximity = abs(proximity);
        if (this.rubberDuck == null) {
            this.rubberDuck = new RubberDuck(Color.YELLOW, true);
        } else {
            this.rubberDuck = rubberDuck;
        }
    }

    public PersonOfInterest(Color hairColor, int proximity, RubberDuck rubberDuck) {
        this(proximity, rubberDuck);
        if (hairColor == null) {
            this.hairColor == Color.BLACK;
        } else {
            this.hairColor = hairColor;
        }
    }

    public String toString() {
        return String.format("A POI with %s hair was last seen %d miles away holding %s",
            hairColor.toString(), proximity, rubberDuck.toString());
    }

    @override
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

    @override
    public int compareTo(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return -1;
        }
        PersonOfInterest poi = (PersonOfInterest) obj;

        if (this.proximity == poi.proximity && this.hairColor == poi.hairColor) {
            return 0;
        }

        if (this.proximity < poi.proximity) {
            return -1;
        } else {
            return 1;
        }
        return this.hairColor.compareTo(poi.hairColor);
    }



}