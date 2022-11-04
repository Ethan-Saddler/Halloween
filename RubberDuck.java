
/**
 * @author esaddler3
 * @version 1.0
 * A class representing a rubber duck that a person of interest can have.
 */
public class RubberDuck {
    private final Color color;
    private final boolean hasHat;
    /**
     * Constructor that defaults color to YELLOW.
     * @param color an enum representing the color of the duck.
     * @param hasHat a boolean representing if the duck has a hat.
     */
    public RubberDuck(Color color, boolean hasHat) {
        if (color == null) {
            this.color = Color.YELLOW;
        } else {
            this.color = color;
        }
        this.hasHat = hasHat;
    }
    /**
     * No arg constructor - sets color to YELLOW and hasHat to true.
     */
    public RubberDuck() {
        this.color = Color.YELLOW;
        this.hasHat = true;
    }
    @Override
    public String toString() {
        return String.format("a %s rubber duck %s a hat.", color.toString(), hasHat ? "with" : "without");
    }
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        RubberDuck duck = (RubberDuck) obj;
        if (this.color == duck.color && this.hasHat == duck.hasHat) {
            return true;
        }
        return false;
    }
}
