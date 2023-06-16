package maurosimoni.BEU2W3D5;

import java.util.ArrayList;
import java.util.List;

public class SmokeDetector {
    private List<Observer> observers = new ArrayList<>();
    private int smokeLevel;
    private int id;
    private double latitude;
    private double longitude;

    public SmokeDetector(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void setSmokeLevel(int smokeLevel) {
        this.smokeLevel = smokeLevel;
        notifyObservers();
    }

    public int getSmokeLevel() {
        return smokeLevel;
    }

    public int getId() {
        return id;
    }
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
