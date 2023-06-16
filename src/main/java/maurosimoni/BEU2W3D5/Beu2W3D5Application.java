package maurosimoni.BEU2W3D5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Beu2W3D5Application {

	public static void main(String[] args) {
		SpringApplication.run(Beu2W3D5Application.class, args);

		ControlCenterImpl controlCenter = new ControlCenterImpl();
		ControlCenterProxy proxy = new ControlCenterProxy(controlCenter);
		ControlProcess process = new ControlProcess(proxy);


		SmokeSensor s1 = SmokeSensorFactory.createSmokeSensor(1, 45.4642, 9.1900);
		process.addSensor(s1);

		SmokeSensor s2 = SmokeSensorFactory.createSmokeSensor(2, 41.9028, 12.4964);
		process.addSensor(s2);

		s1.setSmokeLevel(6);
	}
}
