/**
 * Created by Andrew on 02.03.2016.
 */
public class OctopusAqua {
    public static void main(String[] args) {
        IView View = new View();
        IModel Model = new OctopusLogic();
        IPresenter Presenter = new Presenter(Model,View);
    }
}
