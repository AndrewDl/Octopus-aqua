import java.io.File;
import java.util.Scanner;

/**
 * Created by Andrew on 03/14/16.
 */
public class I2CBusModelConnector implements IBusI2C {


    @Override
    public void SendData(int[] dataPackage, int address) {

    }

    @Override
    public int[] GetData(int address) {
        String _address = new String("octopus-model\\" + Integer.toString(address) + ".txt");
        File file = new File( _address );
        String[] data = null;
        int[] dataPackage;

        try(Scanner scaner = new Scanner(file)){
            String content = scaner.nextLine();
            data = content.split("-");
        }
        catch (Exception ex){

        }

        dataPackage = new int[data.length*2+2];

        for (int i = 0; i < data.length; i++){
            dataPackage[i*2+1+2] = (Integer.parseInt(data[i]) & 0x00FF );
            dataPackage[i*2+2] = ( (Integer.parseInt(data[i])>>8) & 0x00FF );
        }

        return dataPackage;

    }
}
