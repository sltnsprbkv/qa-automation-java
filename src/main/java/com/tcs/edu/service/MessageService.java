package com.tcs.edu.service;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeparateDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.model.Severity;
import com.tcs.edu.printer.ConsolePrinter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Сервис для вывода декорированных сообщений
 *
 * @author s.saparbekov
 * **/

public class MessageService {

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param severity уровень важности
     * @param messages декорируемая строка
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

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null
     *
     * @param severity уровень важности
     * @param messageOrder порядок сортировки
     * @param messages декорируемая строка
     *
     * **/
    public static void print(Severity severity, MessageOrder messageOrder, String... messages) {
        var finalMessages = Arrays.asList(messages);
        if (messageOrder.equals(MessageOrder.DESC)) Collections.reverse(finalMessages);
        print(severity, finalMessages.toArray(String[]::new));
    }

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null.
     * В зависимости от параметра дублирования выводит уникальные/дублирующиеся сообщения
     *
     * @param severity уровень важности
     * @param messageOrder порядок сортировки
     * @param doubling параметр дублирования
     * @param messages декорируемая строка
     *
     * **/
    public static void print(
            Severity severity,
            MessageOrder messageOrder,
            Doubling doubling,
            String... messages
    ) {
        var finalMessages = Arrays.asList(messages);
        if (doubling.equals(Doubling.DISTINCT)) finalMessages =
                finalMessages.stream().distinct().collect(Collectors.toList());
        print(severity, messageOrder, finalMessages.toArray(String[]::new));
    }
}
