import Controllers.MainControll;
import Models.MainModel;
import Views.MainView;

public class Main {
    public static void main(String[] args){
        MainModel mainModel = new MainModel();
        MainView mainView = new MainView(mainModel);
        MainControll mainControll = new MainControll(mainView);
        mainControll.start();
    }
}
