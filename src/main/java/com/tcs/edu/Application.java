package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

class Application {
    public static void main(String[] args) {
        String timestampMessage = TimestampMessageDecorator.decorate("Hello world!");
        ConsolePrinter.print(timestampMessage);
    }
}
