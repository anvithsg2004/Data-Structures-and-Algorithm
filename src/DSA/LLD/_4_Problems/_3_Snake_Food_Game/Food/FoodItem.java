package DSA.LLD._4_Problems._3_Snake_Food_Game.Food;

abstract class FoodItem {

    int row;
    int col;
    int points;

    public FoodItem(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getPoints() {
        return points;
    }

    public int getCol() {
        return col;
    }
}
