package Models;

public class Board {
    private Piece[][] map = new Piece[8][8];

    public Piece getPiece(int x, int y){
        return map[x][y];
    }

    public void setPiece(Piece piece){
        map[piece.getX()][piece.getY()] = piece;
    }


    public Board(){

        for(int i = 2; i < 6; i++)
            for(int j = 0; j < 8; j++)
                map[i][j]= new Piece(i, j, 0, 0, 0, this);

        for(int i = 0; i < 8; i ++){
            map[1][i] = new Piece(1, i, 1, i, 1, this);
            map[6][i] = new Piece(6, i, 1, i, -1, this);
        }
        // 2

        map[0][0] = new Piece(0, 0, 2, 0, 1, this);
        map[0][7] = new Piece(0, 7, 2, 1, 1, this);

        map[7][0] = new Piece(7, 0, 2, 0, -1, this);
        map[7][7] = new Piece(7, 7, 2, 1, -1, this);

        // 3

        map[0][1] = new Piece(0, 1, 3, 0, 1, this);
        map[0][6] = new Piece(0, 6, 3, 1, 1, this);

        map[7][1] = new Piece(7, 1, 3, 0, -1, this);
        map[7][6] = new Piece(7, 6, 3, 1, -1, this);

        // 4

        map[0][2] = new Piece(0, 2, 4, 0, 1, this);
        map[0][5] = new Piece(0, 5, 4, 1, 1, this);

        map[7][2] = new Piece(7, 2, 4, 0, -1, this);
        map[7][5] = new Piece(7, 5, 4, 1, -1, this);

        // 5

        map[0][3] = new Piece(0, 3, 5, 0, 1, this);

        map[7][3] = new Piece(7, 3, 5, 0, -1, this);

        // 6


        map[0][4] = new Piece(0, 4, 6, 0, 1, this);

        map[7][4] = new Piece(7, 4, 6, 0, -1, this);
    }

    public boolean move(int x1, int y1, int x2, int y2, int player){
        if(map[x1][y1].move(x2, y2, player)){
            map[x1][y1] = new Piece(x1, y1, 0, 0, 0, this);
            return true;
        }
        return false;
    }

}


/*
    private int[][] map = new int[][]{
            {+2, +3, +4, +5, +6, +4, +3, +2},
            {+1, +1, +1, +1, +1, +1, +1, +1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {-1, -1, -1, -1, -1, -1, -1, -1},
            {-2, -3, -4, -5, -6, -4, -3, -2}
    };
 */