public class PoliceStation {
    private String name;
    private ArrayList<Suspect> suspects;
    private ArrayList<Accomplice> accomplices;

    public PoliceStation(String name) {
        if (name == null) {
            this.name = "Station 1331";
        } else {
            this.name = name;
        }
        this.suspects = new ArrayList<Suspect>();
        this.accomplice = new ArrayList<Accomplice>();
    }
    public void addPersonOfInterest(PersonOfInterest poi) {
        if (poi.getName() == "Suspect") {
            Suspect suspect = (Suspect) poi;
            suspects.add(suspect);
        } else {
            Accomplice accomplice = (Accomplice) poi;
            accomplices.add(accomplice);
        }
    }
    public void sortSuspects() {
        
    }
}
