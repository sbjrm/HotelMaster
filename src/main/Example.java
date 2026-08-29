package main;

import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        int[] array = new int[5];
        try {
            //Фрагмент кода, где может возникнуть исключение
            array[6] = 10;
        } catch(Throwable e) { //catch(Класс исключения)
            //Фрагмент кода, который произойдет при возникновении исключения
            System.out.println("Была какая-то ошибка");
        }

        System.out.println("Недостижимый код");

        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Вбросили исключение сами");
        }

        exTryCatch();
        try {
            exThrows();
        } catch (IOException e) {
            System.out.println("Обработали 2");
        }
    }

    static void exTryCatch() {
        try {
            throw new IOException();
        } catch(IOException e) {
            System.out.println("Обработали");
        }
    }

    static void exThrows() throws IOException {
        throw new IOException();
    }
}
