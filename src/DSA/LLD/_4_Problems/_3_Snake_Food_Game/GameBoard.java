package DSA.LLD._4_Problems._3_Snake_Food_Game;

public class GameBoard {

    int height;
    int width;
    public static GameBoard instance;

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static GameBoard getInstance(int width, int height) {
        if (instance == null) {
            instance = new GameBoard(width, height);
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
