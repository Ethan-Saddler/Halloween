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
        for (int n = 0; n < length - 1; n++) {
            System.out.println("new iteration");
            min = n;
            for (int m = n + 1; m < length; m++) {
                if (suspects.get(min).compareTo(suspects.get(m)) == 1) {
                    System.out.println("okokok\n");
                    min = m;
                }
            }
            swap = suspects.get(min);
            suspects.set(min, suspects.get(n));
            suspects.set(n, swap);
            System.out.print("\n---NEW LIST---\n");
            for(Suspect suspect: suspects) {System.out.print(suspect.toString());}
        }
    }

    public ArrayList<Suspect> removeDuplicates() {
        ArrayList<Suspect> newSuspects = new ArrayList<Suspect>();
        sortSuspects();
        for(int n = 0; n < suspects.size(); n++) {
            if(n != 0 && suspects.get(n).equals(suspects.get(n - 1))) {
                continue;
            } else if (n != suspects.size() - 1 && suspects.get(n).equals(suspects.get(n + 1))) {
                newSuspects.add(suspects.get(n));
            } else if (n == suspects.size() - 1 && !suspects.get(n).equals(suspects.get(n - 1))) {
                newSuspects.add(suspects.get(n));
            } else {
                newSuspects.add(suspects.get(n));
            }
        }
        return newSuspects;
    }
    public Suspect findSuspect(Suspect suspect) {
        sortSuspects();
        removeDuplicates();
        int max = suspects.size() - 1;
        int min = 0;
        int index = (max + min) / 2;
        while (min <= max) {
            if (suspects.get(index).compareTo(suspect) == 0) {
                break;
            } else if (suspects.get(index).compareTo(suspect) == 1) {
                min = index + 1;
            } else {
                max = index;
            }
            index = (max + min) / 2;
        }
        if (max < min) {
            return null;
        } else {
            return suspects.get(index);
        }
    }

    public Accomplice findMastermind(Suspect suspect) {
        for(Accomplice accomplice : accomplices) {
            if (accomplice.getDuck().equals(suspect.getDuck()) && accomplice.getCode()) {
                return accomplice;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        RubberDuck duck = new RubberDuck(Color.BLACK, true);
        RubberDuck duck1 = new RubberDuck(Color.BLUE, false);
        RubberDuck duck2 = new RubberDuck();

        Suspect suspect = new Suspect(Color.BLONDE, 10, duck, 180);
        Suspect suspect1 = new Suspect(10, duck1);
        Suspect suspect2 = new Suspect(Color.BROWN, 30, duck2, 170);
        Suspect suspect3 = new Suspect(Color.BROWN, 30, duck2, 170);

        System.out.println(suspect.proximity);
        System.out.println(suspect1.proximity);
        System.out.println(suspect2.proximity);
        System.out.println(suspect3.proximity);

        PoliceStation station = new PoliceStation("Gaming");

        station.addPersonOfInterest(suspect3);
        station.addPersonOfInterest(suspect);
        station.addPersonOfInterest(suspect1);
        station.addPersonOfInterest(suspect2);
        
        station.sortSuspects();

        // for(Suspect sus: station.suspects) {
        //     System.out.println(sus.toString());
        // }

        // station.suspects = station.removeDuplicates();

        // for(Suspect sus: station.suspects) {
        //     System.out.println(sus.toString());
        // }

    }
}
