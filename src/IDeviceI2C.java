/**
 * Created by Andrew on 02.03.2016.
 */
public interface IDeviceI2C {
    public SensorSet GetSensorData();
    public int GetDeviceAddress();
    public void SetDeviceAddress(int address);
    public String GetDeviceName();
    public void SetDeviceName(String name);
}
