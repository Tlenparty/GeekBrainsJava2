package lesson1;

public class Human implements Skills {

    private String name;
    private int maxRun;
    private int maxJump;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;

    }

    @Override
    public boolean jump(Obstacle sizeValue) {
        System.out.printf("Человек %s сделал прыжок и %n", name);
        if (sizeValue.isOvercome(maxJump)) {
            System.out.printf("Человек %s перепрыгнул %n", name);
            return true;
        } else {
            System.out.printf("Человек %s не смог перепрыгнуть %n", name);
        }
        return false;
    }

    @Override
    public boolean run(Obstacle sizeValue) {
        System.out.printf("Человек %s начал бежать и %n", name);
        if (sizeValue.isOvercome(maxRun)) {
            System.out.printf("Человек %s пробежал %n", name);
            return true;
        } else {
            System.out.printf("Человек %s не смог пробежать %n", name);
            return false;
        }
    }

}
