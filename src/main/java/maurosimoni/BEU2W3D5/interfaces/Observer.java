package maurosimoni.BEU2W3D5.interfaces;

import maurosimoni.BEU2W3D5.sensors.SmokeSensor;

public interface Observer {
    void update(SmokeSensor sensor);
}
