package lesson1;

public class Lesson1 {

    public static void main(String[] args) {

        Skills[] user = new Skills[3];
        user[0] = new Cat("Барсик", 45, 10);
        user[1] = new Human("Иван", 30, 5);
        user[2] = new Robot("Пылесос", 1, 0);

        Obstacle[] obstacle = new Obstacle[2];
        obstacle[0] = new Wall(6);
        obstacle[1] = new Treadmill(20);

        for (Skills skills : user) {
            for (Obstacle value : obstacle) {

                if (value instanceof Treadmill) {
                    if (!skills.jump(value)) {
                        System.out.println();
                        break;
                    }

                } else {
                    if (!skills.run(value)) {
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }
}
