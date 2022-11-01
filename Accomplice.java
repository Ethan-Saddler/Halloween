public class Accomplice extends PersonOfInterest {
    private boolean canCode;

    public Accomplice(Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }
    public String toString() {
        return String.format("Possible Accomplice: %s They %s have the ability to hack doorbells.", super.toString(), canCode ? "do" : "do not");
    }
    public boolean equals(Object obj) {
        // make sure classes being different is not messing up method
        if (super.equals(obj) == true) {
            Accomplice accomplice = (Accomplice) obj;
            return this.canCode == accomplice.canCode;
        }
        return false;
    }
}
