package lesson5;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class lesson5 {


    /**
     * 1. Необходимо написать два метода, которые делают следующее: +
     * 1) Создают одномерный длинный массив, например: +
     * static final int size = 10000000; +
     * static final int h = size / 2; +
     * float[] arr = new float[size]; +
     * <p>
     * 2) Заполняют этот массив единицами; +
     * 3) Засекают время выполнения: long a = System.currentTimeMillis(); +
     * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле: +
     * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); +
     * 5) Проверяется время окончания метода System.currentTimeMillis(); +
     * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
     * Отличие первого метода от второго:
     * Первый просто бежит по массиву и вычисляет значения.
     * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы
     * обратно в один.
     * <p>
     * Пример деления одного массива на два:
     * System.arraycopy(arr, 0, a1, 0, h);
     * System.arraycopy(arr, h, a2, 0, h);
     * <p>
     * Пример обратной склейки:
     * System.arraycopy(a1, 0, arr, 0, h);
     * System.arraycopy(a2, 0, arr, h, h);
     * <p>
     * Примечание:
     * System.arraycopy() копирует данные из одного массива в другой:
     * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем
     * записывать данные в массив-назначение, сколько ячеек копируем)
     * По замерам времени:
     * Для первого метода надо считать время только на цикл расчета:
     * for (int i = 0; i < size; i++) {
     * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
     * }
     * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
     */

    //1)
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void firstMethod() {

        float[] arr = new float[SIZE];
        //2
        Arrays.fill(arr, 1);
        //3
        long TIME_STARTING = System.currentTimeMillis();
        //4
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        //5
        long TIME_ENDING = System.currentTimeMillis();
        long TIME_ACTION = TIME_ENDING - TIME_STARTING;
        //6
        System.out.print(Arrays.toString(arr));
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Время выполнения = " + TIME_ACTION);
    }

    public static void secondMethod() {
        float[] arr = new float[SIZE]; // исходный массив
        float[] arr1 = new float[H];   // массив в который запишем 1 часть от arr
        float[] arr2 = new float[H];  // массив в который запишем 2 часть от arr
        //2)
        Arrays.fill(arr, 1);
        //3)
        long TIME_STARTING = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);

        //4 Создаем первый поток деления массива arr на arr1
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        //4 Создаем второй поток деления массива arr на arr2
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < H; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        // Запуск потока 1 и 2
        thread1.start();
        thread2.start();

        try {
            thread1.join();  // приостанавливает выполнение 2 го потока пока не завершится 1й
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //     * Пример обратной склейки:
        //     * System.arraycopy(a1, 0, arr, 0, h);
        //     * System.arraycopy(a2, 0, arr, h, h);
        // Склеиваем массивы arr1 и arr2 в аrr
        System.arraycopy(arr1,0,arr,0,H);
        System.arraycopy(arr2,0,arr,H,H);

        //5
        long TIME_ENDING = System.currentTimeMillis();
        long TIME_ACTION = TIME_ENDING - TIME_STARTING;

        //6
        System.out.print(Arrays.toString(arr));
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Время выполнения = " + TIME_ACTION);

    }

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }
}
