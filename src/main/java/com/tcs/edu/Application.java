package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

class Application {
    public static void main(String[] args) {
        String str = "Hello world!";
        ConsolePrinter.print(TimestampMessageDecorator.decorate(str));
        ConsolePrinter.print(TimestampMessageDecorator.decorate(str));
        ConsolePrinter.print(TimestampMessageDecorator.decorate(str));
    }
}
