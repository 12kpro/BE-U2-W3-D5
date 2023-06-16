package maurosimoni.BEU2W3D5;

public class ControlCenterProxy implements ControlCenter{
    private ControlCenterImpl controlCenter;

    public ControlCenterProxy(ControlCenterImpl controlCenter) {
        this.controlCenter = controlCenter;
    }

    @Override
    public void sendAlarm(SmokeDetector detector) {
        // Send alarm to control center using HTTP
        String url = "http://host/alarm?idsonda=" + detector.getId() +
                "&lat=" + detector.getLatitude() +
                "&lon=" + detector.getLongitude() +
                "&smokelevel=" + detector.getSmokeLevel();
        // ...
        controlCenter.sendAlarm(detector);
    }

}
