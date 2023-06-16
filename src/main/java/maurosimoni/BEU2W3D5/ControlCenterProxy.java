package maurosimoni.BEU2W3D5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControlCenterProxy implements ControlCenter{
    private ControlCenterImpl controlCenter;

    public ControlCenterProxy(ControlCenterImpl controlCenter) {
        this.controlCenter = controlCenter;
    }

    @Override
    public void sendAlarm(SmokeSensor sensor) {
        String url = "http://host/alarm?idsonda=" + sensor.getId() +
                "&lat=" + sensor.getLatitude() +
                "&lon=" + sensor.getLongitude() +
                "&smokelevel=" + sensor.getSmokeLevel();
        log.error(url);
        controlCenter.sendAlarm(sensor);
    }

}
