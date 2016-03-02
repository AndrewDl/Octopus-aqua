/**
 * Created by Andrew on 02.03.2016.
 */
public class Presenter implements IPresenter{
    IView View;
    IModel OctopusLogic;

    public Presenter(IModel model, IView view){
        OctopusLogic = model;
        View = view;
    }
}
