/**
 * Created by Andrew on 02.03.2016.
 */
public class Photo implements IReadable{
    private int data;
    private int number;

    public Photo(int number, int data){
        this.number = number;
        this.data = data;
    }
    @Override
    public int GetData() {
        return data;
    }

    public int getNumber() {
        return number;
    }
}
