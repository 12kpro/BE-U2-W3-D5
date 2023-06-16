package maurosimoni.BEU2W3D5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Beu2W3D5Application {

	public static void main(String[] args) {
		SpringApplication.run(Beu2W3D5Application.class, args);
	}
	ControlCenterImpl controlCenter = new ControlCenterImpl();
	ControlCenterProxy proxy = new ControlCenterProxy(controlCenter);
	ControlProcess process = new ControlProcess(proxy);


	SmokeDetector detector1 = SmokeDetectorFactory.createSmokeDetector(1, 45.4642, 9.1900);
     this.process.addDetector(detector1);

	SmokeDetector detector2 = SmokeDetectorFactory.createSmokeDetector(2, 41.9028, 12.4964);
    //  process.addDetector(detector2);

	// Simulate smoke detection
    //  detector1.setSmokeLevel(6);
}
