package lesson2;

import java.util.Random;

public class Lesson2 {

    public static Random random = new Random();
    public static final int SIZE_ARRAY = 4;

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        // Задаем массив из рандомных строк.
        System.out.println("Начальный массив из строк");
        String[][] array = { { "3", "3", "3", "3"}, {}, {}, {}};
                //new String[SIZE_ARRAY][SIZE_ARRAY];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
              // array[i][j] = Integer.toString(random.nextInt(10));
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

       // array [0][0] = "1"; // записываем строку, вместо цифры

        // Вызываем метод с созданным массивом array
        try {
            System.out.print("\nСумма элеметнов массива = " + foo(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }



    public static int foo (String[][]array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        System.out.println();
        System.out.println("Массив числовой");
        if (array.length != 4 && array[4].length != 4) {
            throw new MyArraySizeException();  // ловим исключение MyArraySizeException
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]); // Переводим массив в числа
                    System.out.print(sum + " ");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    throw new MyArrayDataException();  // ловим MyArrayDataException
                }
            }
            System.out.println();
        }
        return sum;
    }
}



