package maurosimoni.BEU2W3D5;

public class SmokeDetectorFactory {
    public static SmokeDetector createSmokeDetector(int id, double latitude, double longitude) {
        return new SmokeDetector(id, latitude, longitude);
    }
}
