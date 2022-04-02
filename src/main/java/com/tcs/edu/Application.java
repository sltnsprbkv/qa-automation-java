package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

class Application {
    public static void main(String[] args) {
        String str = "Hello world!";
        for (int i = 0; i < 5; i++){
            var decoratedMessage = TimestampMessageDecorator.decorate(str);
            ConsolePrinter.print(decoratedMessage);
        }
    }
}
