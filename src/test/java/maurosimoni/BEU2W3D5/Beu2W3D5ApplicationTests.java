package maurosimoni.BEU2W3D5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		sensor.setSmokeLevel(1);
		assertEquals(1, sensor.getSmokeLevel());

	}
	@Test
	void testSmokeLevelAlarm() {
		process.addSensor(sensor);
		sensor.setSmokeLevel(6);
		assertTrue(controlCenter.isAlarmSent());
	}
}
