package DSA.LLD._4_Problems._2_Chess_Game.Game;

public class Player {
    private String name;
    private boolean isWhite;

    public Player(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public boolean isWhite() {
        return isWhite;
    }
}
