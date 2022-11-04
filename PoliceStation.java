import java.util.ArrayList;

/**
 * @author esaddler3
 * @version 1.0
 *          This class represents a police station object which contains
 *          suspects and accomplices.
 */
public class PoliceStation {
    private String name;
    private ArrayList<Suspect> suspects;
    private ArrayList<Accomplice> accomplices;

    /**
     * Constructor that takes in a name and creates empty ArrayLists.
     * @param name a String representing the name of the station.
     */
    public PoliceStation(String name) {
        if (name == null) {
            this.name = "Station 1331";
        } else {
            this.name = name;
        }
        this.suspects = new ArrayList<Suspect>();
        this.accomplices = new ArrayList<Accomplice>();
    }

    /**
     * A method that adds a person of interest to either the suspect or accomplice list.
     * @param poi a PersonOfInterest object that is added to either a suspect or accomplice list.
     */
    public void addPersonOfInterest(PersonOfInterest poi) {
        if (poi.getClass().getName().equals("Suspect")) {
            Suspect suspect = (Suspect) poi;
            suspects.add(suspect);
        } else if (poi.getClass().getName().equals("Accomplice")) {
            Accomplice accomplice = (Accomplice) poi;
            accomplices.add(accomplice);
        }
    }

    /**
     * A method that sorts the suspects arraylist based on the compareTo method, least to greatest.
     */
    public void sortSuspects() {
        int length = suspects.size();
        Suspect swap;
        int min;
        for (int n = 0; n < length - 1; n++) {
            min = n;
            for (int m = n + 1; m < length; m++) {
                if (suspects.get(min).compareTo(suspects.get(m)) > 0) {
                    min = m;
                }
            }
            swap = suspects.get(min);
            suspects.set(min, suspects.get(n));
            suspects.set(n, swap);
        }
    }

    /**
     * Method that removes duplicates from suspects array then adds them to a list that is returned.
     * @return an ArrayList of suspects that contains the duplicates.
     */
    public ArrayList<Suspect> removeDuplicates() {
        ArrayList<Suspect> newSuspects = new ArrayList<Suspect>();
        sortSuspects();
        int m = suspects.size();
        int n = 0;
        while (n < m) {
            if (n != 0 && suspects.get(n).equals(suspects.get(n - 1))) {
                suspects.remove(n);
                n--;
                m--;
                continue;
            } else if (n != m - 1 && suspects.get(n).equals(suspects.get(n + 1))) {
                newSuspects.add(suspects.get(n));
            }
            n++;
        }
        return newSuspects;
    }
    /**
     * A method that uses binary search to find the suspect that matches the inputed suspect object.
     * @param suspect a Suspect that is to be found with the same hair and proximity.
     * @return a Suspect object from the array that matches the parameter.
     */
    public Suspect findSuspect(Suspect suspect) {
        sortSuspects();
        removeDuplicates();
        int max = suspects.size() - 1;
        int min = 0;
        int index = 0;
        while (min <= max) {
            index = min + (max - min) / 2;
            if (suspects.get(index).compareTo(suspect) == 0) {
                return suspects.get(index);
            } else if (suspects.get(index).compareTo(suspect) == -1) {
                min = index + 1;
            } else {
                max = index - 1;
            }
        }
        return null;
    }
    /**
     * Finds the mastermind based on if they have an accomplice with the same duck and can code.
     * @param suspect the suspect who may be the mastermind.
     * @return the accomplice of the mastermind.
     */
    public Accomplice findMastermind(Suspect suspect) {
        for (Accomplice accomplice : accomplices) {
            if (accomplice.getDuck().equals(suspect.getDuck()) && accomplice.getCode()) {
                return accomplice;
            }
        }
        return null;
    }
    /**
     * Main method that runs the code and creates objects.
     * @param args not used.
     */
    public static void main(String[] args) {
        RubberDuck duck = new RubberDuck(Color.BLACK, true);
        RubberDuck duck1 = new RubberDuck(Color.BLUE, false);
        RubberDuck duck2 = new RubberDuck();

        Suspect suspect = new Suspect(Color.BLONDE, 3, duck, 180);
        Suspect suspect1 = new Suspect(12, duck1);
        Suspect suspect2 = new Suspect(Color.BROWN, 30, duck2, 170);
        Suspect suspect3 = new Suspect(Color.BROWN, 40, duck2, 170);

        Accomplice accomplice = new Accomplice(Color.BROWN, 100, duck2, true);
        Accomplice accomplice1 = new Accomplice(Color.BROWN, 120, duck2, false);

        PoliceStation station = new PoliceStation("Gaming");

        station.addPersonOfInterest(suspect3);
        station.addPersonOfInterest(suspect3);
        station.addPersonOfInterest(suspect1);
        station.addPersonOfInterest(suspect3);
        station.addPersonOfInterest(suspect);
        station.addPersonOfInterest(suspect1);
        station.addPersonOfInterest(suspect2);

        station.addPersonOfInterest(accomplice);
        station.addPersonOfInterest(accomplice1);

        station.sortSuspects();

        for (Suspect sus : station.suspects) {
            System.out.println(sus.toString());
        }

        station.removeDuplicates();

        for (Suspect sus : station.suspects) {
            if (sus != null) {
                System.out.println(sus.toString());
            }
        }

        System.out.println(station.findSuspect(suspect2));

        System.out.println(station.findMastermind(suspect3));
    }
}
