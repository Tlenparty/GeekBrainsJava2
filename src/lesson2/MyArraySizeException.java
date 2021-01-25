package lesson2;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(){
        System.out.println("\nОшибка! Размерность массива должна быть 4х4");
    }
}
