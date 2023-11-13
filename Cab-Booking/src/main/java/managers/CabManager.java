package main.java.managers;

import main.java.entities.Cab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CabManager {
    private final Map<String, Cab> licenseToCabMap;

    private static CabManager cabManagerInstance = null;

    private CabManager() {
        licenseToCabMap = new HashMap<>();
    }

    public static CabManager getCabManagerInstance() {
        if (cabManagerInstance == null) {
            cabManagerInstance = new CabManager();
        }
        return cabManagerInstance;
    }

    public void addCabToDatabase(Cab cab) {
        String license = cab.getLicense();
        if (!licenseToCabMap.containsKey(license)) {
            licenseToCabMap.put(license, cab);
        }
    }

    public void removeCabFromDatabase(Cab cab) {
        String license = cab.getLicense();
        licenseToCabMap.remove(license);
    }

    public Cab findCab(String licenceNo) {
        if(licenseToCabMap.containsKey(licenceNo))
            return licenseToCabMap.get(licenceNo);

        return null;
    }

    public ArrayList<Cab> findAvailableCabs() {


        ArrayList<Cab> availableCabs = new ArrayList<>();
        for (Map.Entry<String,Cab> e : licenseToCabMap.entrySet()){
            Cab cab = e.getValue();
            if(cab.isAvailable())
                availableCabs.add(cab);
        }

        return availableCabs;
    }

    public Map<String, Cab> getLicenseToCabMap() {
        return licenseToCabMap;
    }
}
