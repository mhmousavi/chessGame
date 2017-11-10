package Views;

import Models.MainModel;

import java.util.Scanner;

public class MainView {
    private MainModel mainModel;

    public MainView(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void showBoard(){
        System.out.println("Board : ");
        for(int i = 0; i < 8; i ++) {
            for (int j = 0; j < 8; j++) {
                if(mainModel.getPiece(i, j) > 0)
                    System.out.print("+");
                if(mainModel.getPiece(i, j) == 0)
                    System.out.print(" ");

                System.out.print(mainModel.getPiece(i, j) + " ");
            }
            System.out.println();
        }
    }

    public void getMove(int player){
        Scanner in = new Scanner(System.in);
        System.out.println("Player " + player + "'s Move : ");
        int x1, x2, y1, y2;

        while(true){
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            x1 --; x2 --; y1 --; y2 --;
            if(!mainModel.move(x1, y1, x2, y2, player)){
                System.out.println("Wrong Move!");
                System.out.println("Player " + player + "'s Move : ");
            }
            else{
                break;
            }
        }
    }

}
