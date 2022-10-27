public class RubberDuck {
    final private Color color;
    final private boolean hasHat;


    public RubberDuck(Color color, boolean hasHat) {
        if (color == null) {
            this.color = Color.YELLOW;
        } else {
            this.color = color;
        }
        this.hasHat = hasHat;
    }
    public RubberDuck() {
        this.color = Color.YELLOW;;
        this.hasHat = true;
    }
    public String toString() {
        return String.format("a %s rubber duck %s a hat.", color.toString(), hasHat ? "with" : "without");
    }
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
