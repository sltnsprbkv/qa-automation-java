package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

class Application {
    public static void main(String[] args) {
        String str = "Hello world!";
        var decoratedMessage = TimestampMessageDecorator.decorate(str);
        for (int i = 0; i < 5; i++){
            ConsolePrinter.print(decoratedMessage);
            decoratedMessage = TimestampMessageDecorator.decorate(str);
        }
    }
}
