/**
 * Created by Andrew on 02.03.2016.
 */
public class Terminal implements IDeviceI2C {
    private SensorSet sensorSet = new SensorSet();
    private int address;
    private String name;

    IBusI2C i2c = new I2CBusModelConnector();

    public Terminal(int address){
        SetDeviceAddress(address);
    }

    public void SetSensorSet(SensorSet sensorSet){
        this.sensorSet = sensorSet;
    }

    private void RequestData(){
        int[] buffer = i2c.GetData(address);
        sensorSet = ParseData(buffer);
    }

    private int parseDeviceID(int data){
        return data >> 5 & 0x07;
    }

    private int parseDeviceNumber(int data){
        return data >> 2 & 0x07;
    }

    private int parseDeviceData(int[] data){
        return ( (data[0]<<8) | data[1] ) & 0x3FF;
    }

    private SensorSet ParseData (int[] dataPackage){

        SensorSet sensors = new SensorSet();

        int[] buffer;

        for(int i = 2;i<dataPackage.length; i+=2){
            switch(parseDeviceID(dataPackage[i])){
                case 1:
                    buffer = new int[2];
                    System.arraycopy(dataPackage,i,buffer,0,2);
                    sensors.SensorMoistureList.add(
                            new Moisture(
                                    parseDeviceNumber(dataPackage[i]),
                                    parseDeviceData(buffer)
                            )
                    );
                    break;
                case 2:
                    buffer = new int[2];
                    System.arraycopy(dataPackage,i,buffer,0,2);
                    sensors.SensorLightList.add(
                            new Photo(
                                    parseDeviceNumber(dataPackage[i]),
                                    parseDeviceData(buffer)
                            )
                    );
                    break;
                case 3:
                    buffer = new int[2];
                    System.arraycopy(dataPackage,i,buffer,0,2);
                    sensors.SensorTemperatureList.add(
                            new Temperature(
                                    parseDeviceNumber(dataPackage[i]),
                                    parseDeviceData(buffer)
                            )
                    );
                    break;
                default:
                    break;
            }
        }
        return sensors;
    }

    @Override
    public SensorSet GetSensorData() {
        RequestData();
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

