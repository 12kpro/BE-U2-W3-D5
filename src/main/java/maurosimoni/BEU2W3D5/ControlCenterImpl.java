package maurosimoni.BEU2W3D5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControlCenterImpl implements ControlCenter{
    private boolean alarmSent = false;
    @Override
    public void sendAlarm(SmokeSensor sensor) {
        alarmSent = true;
    }

    public boolean isAlarmSent() {
        return alarmSent;
    }
}
