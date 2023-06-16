package maurosimoni.BEU2W3D5;

import java.util.ArrayList;
import java.util.List;

public class ControlProcess implements Observer{
    private List<SmokeDetector> detectors = new ArrayList<>();
    private ControlCenterProxy proxy;

    public ControlProcess(ControlCenterProxy proxy) {
        this.proxy = proxy;
    }

    public void addDetector(SmokeDetector detector) {
        detectors.add(detector);
        detector.attach(this);
    }

    @Override
    public void update(SmokeDetector detector) {
        if (detector.getSmokeLevel() > 5) {
            proxy.sendAlarm(detector);
        }
    }
}
