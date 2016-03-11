/**
 * Created by Andrew on 02.03.2016.
 */
public class Terminal implements IDeviceI2C {
    private SensorSet sensorSet;
    private int address;
    private String name;


    public void SetSensorSet(SensorSet sensorSet){
        this.sensorSet = sensorSet;
    }

    @Override
    public SensorSet GetSensorData() {
        return sensorSet;
    }

    @Override
    public int GetDeviceAddress() {
        return address;
    }

    @Override
    public void SetDeviceAddress(int address) {
        this.address = address;
    }

    @Override
    public String GetDeviceName() {
        return name;
    }

    @Override
    public void SetDeviceName(String name) {
        this.name = name;
    }

}
