/**
 * Created by Andrew on 03/14/16.
 */
public interface IBusI2C {
    public void SendData(int[] dataPackage, int address);
    public int[] GetData(int address);
}
