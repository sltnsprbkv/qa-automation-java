package com.tcs.edu.printer;

import com.tcs.edu.repository.Printer;

/**
 * {@code com.tcs.edu.printer.ConsolePrinter} выводит сообщения на консоль
 *
 * @author s.saparbekov
 * **/

public class ConsolePrinter implements Printer {

    /**
     * Принимает строку и выводит на консоль сообщение.
     * Метод содержит сайд эффект
     *          <p> при вызове {@code System.out.println} изменяется состояние машины </p>
     *
     * @param message строка, которая будет выведена на консоль.
     * **/
    public void print(String message) {
        System.out.println(message);
    }
}
