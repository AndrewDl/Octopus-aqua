/**
 * Created by Andrew on 02.03.2016.
 */
public class I2CBusConnector implements IBusI2C{
    @Override
    public void SendData(int[] dataPackage, int address) {

    }

    @Override
    public int[] GetData(int address) {
        return new int[0];
    }

    //TODO: sends i2c requests
}
