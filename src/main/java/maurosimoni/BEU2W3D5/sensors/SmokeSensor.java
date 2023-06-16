package maurosimoni.BEU2W3D5.sensors;

import maurosimoni.BEU2W3D5.exceptions.SensorError;
import maurosimoni.BEU2W3D5.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class SmokeSensor {
    private List<Observer> observers = new ArrayList<>();
    private int smokeLevel;
    private int id;
    private double latitude;
    private double longitude;

    public SmokeSensor(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void setSmokeLevel(int smokeLevel) throws SensorError {
        if (smokeLevel < 0 || smokeLevel > 10){
            throw new SensorError("Sensor Fault, detected value is" + smokeLevel + ".Allowed value is in range 0 - 10");
        }
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
