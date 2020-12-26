package lesson1;

public class Cat implements Skills {

    private String name;
    private int maxRun;
    private int maxJump;

    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;

    }

    @Override
    public boolean jump(Obstacle sizeValue) {
        System.out.printf("Кот %s сделал прыжок и %n", name);
        if (sizeValue.isOvercome(maxJump)) {
            System.out.printf("Кот %s перепрыгнул %n", name);
            return true;
        } else {
            System.out.printf("Кот %s не смог перепрыгнуть %n", name);
        }
        return false;
    }

    @Override
    public boolean run(Obstacle sizeValue) {
        System.out.printf("Кот %s начал бежать и %n", name);
        if (sizeValue.isOvercome(maxRun)) {
            System.out.printf("Кот %s пробежал %n", name);
            return true;
        } else {
            System.out.printf("Кот %s не смог пробежать %n", name);
            return false;
        }
    }
}

