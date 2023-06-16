package maurosimoni.BEU2W3D5.sensors;

import lombok.extern.slf4j.Slf4j;
import maurosimoni.BEU2W3D5.exceptions.SensorError;
import maurosimoni.BEU2W3D5.proxy.ControlCenterImpl;
import maurosimoni.BEU2W3D5.proxy.ControlCenterProxy;
import maurosimoni.BEU2W3D5.proxy.ControlProcess;
import maurosimoni.BEU2W3D5.sensors.factories.SmokeSensorFactory;
import maurosimoni.BEU2W3D5.sensors.payloads.SensorCreatePaylod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/sensors")
public class SensorController {

    ControlCenterImpl controlCenter = new ControlCenterImpl();
    ControlCenterProxy proxy = new ControlCenterProxy(controlCenter);
    ControlProcess process = new ControlProcess(proxy);

    @GetMapping("")
    public ResponseEntity<List<SmokeSensor>> getSensors() {
        return new ResponseEntity<>(process.getSensors(), HttpStatus.FOUND);
    }
    @GetMapping("/{sensorId}")
    public ResponseEntity<SmokeSensor> getSensor(@PathVariable int id) {

        return new ResponseEntity<>(process.getSensors().get(id), HttpStatus.FOUND);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public SmokeSensor saveSensor(@RequestBody @Validated SensorCreatePaylod body) {
        SmokeSensor s = SmokeSensorFactory.createSmokeSensor(body.getId(), body.getLatitude(),body.getLongitude());
        process.addSensor(s);
        return new ResponseEntity<>(s, HttpStatus.CREATED).getBody();
    }
    @PutMapping("/{sensorId}/{smokeLevel}")
    public SmokeSensor updateSensor(@PathVariable int sensorId, @PathVariable int smokeLevel) {
        SmokeSensor smokeSensor = null;
        Optional<SmokeSensor> sensor = process.getSensors().stream().filter(s -> s.getId() == sensorId).findFirst();

        try {
            if (sensor.isPresent()) {
                smokeSensor = sensor.get();
                smokeSensor.setSmokeLevel(smokeLevel);
            }

        } catch (SensorError e) {
            log.error(e.getMessage());
        }

        return smokeSensor;
    }
    @DeleteMapping("/{sensorId}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public SmokeSensor deleteSensor(@PathVariable int sensorId) {
        SmokeSensor smokeSensorRm = null;
        Optional<SmokeSensor> sensor =  process.getSensors().stream().filter(s -> s.getId() == sensorId).findFirst();
        if (sensor.isPresent()) {
                smokeSensorRm = sensor.get();
                process.rmSensor(smokeSensorRm);
        }
        return smokeSensorRm;
    }
}
