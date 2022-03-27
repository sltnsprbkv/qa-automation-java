package com.tcs.edu.printer;

/**
 * {@code com.tcs.edu.printer.ConsolePrinter} выводит сообщения на консоль
 *
 * @author s.saparbekov
 * **/

public class ConsolePrinter {

    /**
     * Принимает строку и выводит на консоль приветственное сообщение
     * "Hello, {@code message}!!!". Метод содержит как минимум два сайд эффекта
     *          <p> 1. при вызове {@code System.out.println} изменяется состояние машины </p>
     *          <p> 2. внутри метода изменяется значение переданного аргумента {@code message} </p>
     *
     * @param message строка, которая будет изменена и выведена на консоль.
     * **/
    public static void print(String message) {
        message = "Hello, " + message + "!!!";
        System.out.println(message);
    }
}
