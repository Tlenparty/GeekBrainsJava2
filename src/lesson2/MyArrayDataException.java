package lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(){
        System.out.println("\nОшибка! В ячейке лежит не число!");
    }
}
