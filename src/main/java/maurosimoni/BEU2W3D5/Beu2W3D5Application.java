package maurosimoni.BEU2W3D5;

import lombok.extern.slf4j.Slf4j;
import maurosimoni.BEU2W3D5.exceptions.SensorError;
import maurosimoni.BEU2W3D5.proxy.ControlCenterImpl;
import maurosimoni.BEU2W3D5.proxy.ControlCenterProxy;
import maurosimoni.BEU2W3D5.proxy.ControlProcess;
import maurosimoni.BEU2W3D5.sensors.SmokeSensor;
import maurosimoni.BEU2W3D5.sensors.factories.SmokeSensorFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
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


		try{
			s1.setSmokeLevel(6);
			s2.setSmokeLevel(-1);
		} catch (SensorError e) {
			log.error(e.getMessage());
		}
	}
}
