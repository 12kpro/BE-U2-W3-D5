package maurosimoni.BEU2W3D5.proxy;

import maurosimoni.BEU2W3D5.interfaces.ControlCenter;
import maurosimoni.BEU2W3D5.sensors.SmokeSensor;


public class ControlCenterProxy implements ControlCenter {
    private ControlCenterImpl controlCenter;

    public ControlCenterProxy(ControlCenterImpl controlCenter) {
        this.controlCenter = controlCenter;
    }

    @Override
    public void sendAlarm(SmokeSensor sensor) {

        controlCenter.sendAlarm(sensor);
    }

}
