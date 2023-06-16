package maurosimoni.BEU2W3D5.sensors.factories;

import maurosimoni.BEU2W3D5.sensors.SmokeSensor;

public class SmokeSensorFactory {
    public static SmokeSensor createSmokeSensor(int id, double latitude, double longitude) {
        return new SmokeSensor(id, latitude, longitude);
    }
}
