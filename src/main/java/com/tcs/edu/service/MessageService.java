package com.tcs.edu.service;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeparateDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.model.Severity;
import com.tcs.edu.printer.ConsolePrinter;

import java.util.Arrays;
import java.util.Objects;

/**
 * Сервис для вывода декорированных сообщений
 *
 * @author s.saparbekov
 * **/
public class MessageService {

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param messages строка, которая будет сконкатинирована с ее уровнем важности
     * @param severity уровень важности
     *
     * **/
    public static void print(Severity severity, String... messages) {
        Arrays.stream(messages)
                .filter(Objects::nonNull)
                .map(TimestampMessageDecorator::decorate)
                .map(NumerateMessageDecorator::decorate)
                .map(message -> SeverityMessageDecorator.decorate(severity, message))
                .map(SeparateDecorator::decorate)
                .forEach(ConsolePrinter::print);
    }
}
