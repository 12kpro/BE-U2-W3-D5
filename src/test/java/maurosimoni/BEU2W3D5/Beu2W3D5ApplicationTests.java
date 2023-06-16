package maurosimoni.BEU2W3D5;

import lombok.extern.slf4j.Slf4j;
import maurosimoni.BEU2W3D5.exceptions.SensorError;
import maurosimoni.BEU2W3D5.proxy.ControlCenterImpl;
import maurosimoni.BEU2W3D5.proxy.ControlCenterProxy;
import maurosimoni.BEU2W3D5.proxy.ControlProcess;
import maurosimoni.BEU2W3D5.sensors.SmokeSensor;
import maurosimoni.BEU2W3D5.sensors.factories.SmokeSensorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@Slf4j
@SpringBootTest
class Beu2W3D5ApplicationTests {
	ControlCenterImpl controlCenter;
	ControlCenterProxy proxy;
	ControlProcess process;
	SmokeSensor sensor;
@BeforeEach
public void starter(){
	controlCenter = new ControlCenterImpl();
 	proxy = new ControlCenterProxy(controlCenter);
	process = new ControlProcess(proxy);

	sensor = SmokeSensorFactory.createSmokeSensor(1, 45.4642, 23.1900);

	}

	@Test
	void testSmokeLevel() {
		try{
			sensor.setSmokeLevel(1);
		} catch (SensorError e) {
			log.error(e.getMessage());
		}

		assertEquals(1, sensor.getSmokeLevel());

	}
	@Test
	void testSmokeLevelAlarm() {
		process.addSensor(sensor);
		try{
			sensor.setSmokeLevel(6);
		} catch (SensorError e) {
			log.error(e.getMessage());
		}
		assertTrue(controlCenter.isAlarmSent());
	}
}
