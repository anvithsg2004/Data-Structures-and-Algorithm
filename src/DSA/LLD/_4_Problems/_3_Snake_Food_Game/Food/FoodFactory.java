package DSA.LLD._4_Problems._3_Snake_Food_Game.Food;

public class FoodFactory {

    public static FoodItem createFood(int[] position, String type) {
        if ("bonus".equals(type)) {
            return new SpecialFood(position[0], position[1]);
        }
        return new NormalFood(position[0], position[1]);
    }

}
