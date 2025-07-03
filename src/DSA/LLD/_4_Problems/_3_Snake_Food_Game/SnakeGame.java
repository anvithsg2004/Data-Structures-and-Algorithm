package DSA.LLD._4_Problems._3_Snake_Food_Game;

import DSA.LLD._4_Problems._3_Snake_Food_Game.Movement.HumanMovement;
import DSA.LLD._4_Problems._3_Snake_Food_Game.Movement.Movement;

import java.util.*;

public class SnakeGame {
    private GameBoard board;
    private Deque<Pair> snake;
    private Map<Pair, Boolean> snakeMap;
    private int[][] food;
    private int foodIndex; // To track which is the next food in the food matrix
    private Movement movementStrategy;

    public SnakeGame(int width, int height, int[][] food) {
        this.board = GameBoard.getInstance(width, height);
        this.food = food;
        this.foodIndex = 0;

        this.snake = new LinkedList<>();
        this.snakeMap = new HashMap<>();
        Pair initialPosition = new Pair(0, 0);
        this.snake.offerFirst(initialPosition);
        this.snakeMap.put(initialPosition, true);

        this.movementStrategy = new HumanMovement();
    }

    public void setMovementStrategy(Movement strategy) {
        this.movementStrategy = strategy;
    }

    public int move(String direction) {

        Pair currentPosition = this.snake.peekFirst();

        Pair newPosition = this.movementStrategy.getNextPosition(currentPosition, direction);
        int newHeadRow = newPosition.getRow();
        int newHeadCol = newPosition.getCol();

        boolean crossesBoundary = newHeadRow < 0 || newHeadRow >= this.board.getHeight() ||
                newHeadCol < 0 || newHeadCol >= this.board.getWidth();

        Pair currentTail = this.snake.peekLast();

        boolean bitesItself = this.snakeMap.containsKey(newPosition) ||
                !(newPosition.getRow() == currentTail.getRow() && newPosition.getCol() == currentTail.getCol());

        // Game over conditions
        if (crossesBoundary || bitesItself) {
            return -1;
        }

        // Check if snake eats food
        boolean ateFood = (this.foodIndex < this.food.length) &&
                (this.food[this.foodIndex][0] == newHeadRow) &&
                (this.food[this.foodIndex][1] == newHeadCol);

        if (ateFood) {
            // Increment food index to move to next food
            this.foodIndex++;
        } else {
            // If no food eaten, remove tail
            this.snake.pollLast();
            this.snakeMap.remove(currentTail);
        }

        // Add new head
        this.snake.addFirst(newPosition);
        this.snakeMap.put(newPosition, true);
        // Calculate ans return score
        int score = this.snake.size() - 1;
        return score;

    }

}
