package Controllers;

import Models.MainModel;
import Views.MainView;

public class MainControll {
    private MainView mainView;

    public MainControll(MainView mainView) {
        this.mainView = mainView;
    }

    public void start(){
        while (true){
            mainView.showBoard();
            mainView.getMove(+1);
            mainView.showBoard();
            mainView.getMove(-1);
        }
    }
}
