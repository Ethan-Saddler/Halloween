import java.util.ArrayList;

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
        this.accomplices = new ArrayList<Accomplice>();
    }
    public void addPersonOfInterest(PersonOfInterest poi) {
        if (poi.getClass().getName() == "Suspect") {
            Suspect suspect = (Suspect) poi;
            suspects.add(suspect);
        } else {
            Accomplice accomplice = (Accomplice) poi;
            accomplices.add(accomplice);
        }
    }
    public void sortSuspects() {
        int length = suspects.size();
        Suspect swap;
        int min;
        for(int n = 0; n < length; n++) {
            min = n;
            for(int m = n + 1; m < length; m++) {
                if (suspects.get(min).compareTo(suspects.get(m)) == 1) {
                    min = m;
                }
            swap = suspects.get(min);
            suspects.set(min, suspects.get(n));
            suspects.set(n, swap);
            }
        }
    }
}
