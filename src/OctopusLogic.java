import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 02.03.2016.
 */
public class OctopusLogic implements IModel {

    List<Terminal> terminalsList = new ArrayList<Terminal>();

    @Override
    public void Start(){
        for (int i =1; i < 5; i++){
            addTerminal(i);
        }

        for (int i = 0; i < terminalsList.size(); i++){
            System.out.println("Terminal num: " + (i+1));
            SensorSet sensorsSet = terminalsList.get(i).GetSensorData();
            for (int j = 0; j < sensorsSet.SensorMoistureList.size(); j++){
                System.out.println("--- Moisture: "+sensorsSet.SensorMoistureList.get(j).GetData());
            }
            for (int j = 0; j < sensorsSet.SensorMoistureList.size(); j++){
                System.out.println("--- Temperature: "+sensorsSet.SensorTemperatureList.get(j).GetData());
            }
            for (int j = 0; j < sensorsSet.SensorMoistureList.size(); j++){
                System.out.println("--- Light: "+sensorsSet.SensorLightList.get(j).GetData());
            }
        }
    }

    public void addTerminal(int address){
        terminalsList.add(new Terminal(address));
    }

}
