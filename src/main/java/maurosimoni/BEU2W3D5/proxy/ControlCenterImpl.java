package maurosimoni.BEU2W3D5.proxy;

import lombok.extern.slf4j.Slf4j;
import maurosimoni.BEU2W3D5.interfaces.ControlCenter;
import maurosimoni.BEU2W3D5.sensors.SmokeSensor;

@Slf4j
public class ControlCenterImpl implements ControlCenter {
    private boolean alarmSent = false;
    @Override
    public void sendAlarm(SmokeSensor sensor) {
        alarmSent = true;
        String url = "http://host/alarm?idsonda=" + sensor.getId() +
                "&lat=" + sensor.getLatitude() +
                "&lon=" + sensor.getLongitude() +
                "&smokelevel=" + sensor.getSmokeLevel();
        log.error(url);
    }

    public boolean isAlarmSent() {
        return alarmSent;
    }
}
