package maurosimoni.BEU2W3D5.proxy;

import maurosimoni.BEU2W3D5.interfaces.Observer;
import maurosimoni.BEU2W3D5.sensors.SmokeSensor;

import java.util.ArrayList;
import java.util.List;

public class ControlProcess implements Observer {
    private List<SmokeSensor> sensors = new ArrayList<>();
    private ControlCenterProxy proxy;

    public ControlProcess(ControlCenterProxy proxy) {
        this.proxy = proxy;
    }

    public void addSensor(SmokeSensor sensor) {
        sensors.add(sensor);
        sensor.attach(this);
    }
    public void rmSensor(SmokeSensor sensor) {
        sensors.remove(sensor);
        sensor.deAttach(this);
    }
    public List<SmokeSensor> getSensors() {
        return sensors;
    }

    @Override
    public void update(SmokeSensor sensor) {
        if (sensor.getSmokeLevel() > 5) {
            proxy.sendAlarm(sensor);
        }
    }
}
