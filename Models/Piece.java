package Models;

public class Piece {
    private int x;
    private int y;
    private int type;
    private int id;
    private int player;
    private Board board;

    private int dx[] = new int[]{+1, -1,  0,  0, 1, -1, +1, -1, +2, -2, +2, -2, +1, +1, -1, -1};
    private int dy[] = new int[]{ 0,  0, -1, +1, 1, -1, -1, +1, +1, +1, -1, -1, +2, -2, +2, -2};

    public boolean isval(int x, int y){
        return 0 <= x && x <  8 && 0 <= y && y < 8;
    }

    public boolean canMove(int x, int y, int player){
        if(!isval(x, y))
            return false;
        if(this.player != player)
            return  false;
        int st = -1, ed = -1, cnt = 0, limit = -1;
        if(this.type == 1){
            if(this.x == (player == 1 ? 1 : 6) && y == this.y && x == this.x + 2 * player && board.getPiece(x, y).getPlayer() == 0)
                return true;
            if(y == this.y && x == this.x + player && board.getPiece(x, y).getPlayer() == 0)
                return true;
            if(Math.abs(y - this.y) == 1 && x == this.x + player && board.getPiece(x, y).getPlayer() == -1 * player)
                return true;
            return false;
        }
        if(this.type == 2){
            st = 0;
            ed = 4;
        }
        if(this.type == 3){
            st = 8;
            ed = 16;
            limit = 1;
        }
        if(this.type == 4){
            st = 4;
            ed = 8;
        }
        if(this.type == 5){
            st = 0;
            ed = 8;
        }
        if(this.type == 6){
            st = 0;
            ed = 8;
            limit = 1;
        }
        for(int i = st; i < ed; ++i){
            cnt  = 0;
            int X = this.x + dx[i];
            int Y = this.y + dy[i];
            if(!isval(X, Y)) continue;
            while(isval(X, Y) && cnt != limit){
                if(board.getPiece(X, Y).getPlayer() == player) break;
                if(X == x && Y == y) return true;
                if(board.getPiece(X, Y).getPlayer() != 0) break;
                X += dx[i];
                Y += dy[i];
                cnt ++;
            }
        }
        return false;
    }

    public boolean move(int x, int y, int player){
        if(!canMove(x, y, player)) return false;
        this.x = x;
        this.y = y;
        board.setPiece(this);
        return true;
    }

    public Piece() {
    }

    public Piece(int x, int y, int type, int id, int player, Board board) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.id = id;
        this.player = player;
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
}
