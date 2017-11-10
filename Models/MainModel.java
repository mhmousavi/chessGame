package Models;

public class MainModel {
    private Board board;

    public MainModel() {
        board = new Board();
    }

    public boolean move(int x1, int y1, int x2, int y2, int player){
        return board.move(x1, y1, x2, y2, player);
    }

    public int getPiece(int x, int y){
        Piece piece = board.getPiece(x, y);
        return piece.getType() * piece.getPlayer();
    }
}
