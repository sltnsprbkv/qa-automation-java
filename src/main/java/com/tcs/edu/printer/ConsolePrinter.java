package com.tcs.edu.printer;

/**
 * {@code com.tcs.edu.printer.ConsolePrinter} выводит сообщения на консоль
 *
 * @author s.saparbekov
 * **/

public class ConsolePrinter {

    /**
     * Принимает строку и выводит на консоль сообщение.
     * Метод содержит сайд эффект
     *          <p> при вызове {@code System.out.println} изменяется состояние машины </p>
     *
     * @param message строка, которая будет выведена на консоль.
     * **/
    public static void print(String message) {
        System.out.println(message);
    }
}
