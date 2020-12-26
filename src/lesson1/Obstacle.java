
package lesson1;

public class Obstacle {
    int sizeValue;

    public Obstacle(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public boolean isOvercome(int maxJumpRun) {
        return maxJumpRun > sizeValue;
    }


}
