package com.tcs.edu.service;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeparateDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.model.Severity;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.utils.CustomCollectionOperations;

import java.util.*;
import java.util.stream.Stream;

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
     * @param messages декорируемые строки в stream
     *
     * **/
    public static void print(Severity severity, Stream<String> messages) {
        messages
                .filter(Objects::nonNull)
                .map(TimestampMessageDecorator::decorate)
                .map(NumerateMessageDecorator::decorate)
                .map(message -> SeverityMessageDecorator.decorate(severity, message))
                .map(SeparateDecorator::decorate)
                .forEach(ConsolePrinter::print);
    }

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param severity уровень важности
     * @param messages декорируемые строки
     *
     * **/
    public static void print(Severity severity, String... messages) {
        print(severity, Arrays.stream(messages));
    }

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null
     *
     * @param severity уровень важности
     * @param messageOrder порядок сортировки
     * @param messages декорируемые строки
     *
     * **/
    public static void print(Severity severity, MessageOrder messageOrder, String... messages) {
        var finalMessages = messages;
        if (messageOrder.equals(MessageOrder.DESC)) {
            CustomCollectionOperations.reverse(finalMessages);
        }
        print(severity, finalMessages);
    }

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null.
     * В зависимости от параметра дублирования выводит уникальные/дублирующиеся сообщения
     *
     * @param severity уровень важности
     * @param messageOrder порядок сортировки
     * @param doubling параметр дублирования
     * @param messages декорируемые строки
     *
     * **/
    public static void print(
            Severity severity,
            MessageOrder messageOrder,
            Doubling doubling,
            String... messages
    ) {
        print(severity, messageOrder, doubling.equals(Doubling.DISTINCT)
                ? Arrays.stream(messages).distinct().toArray(String[]::new)
                : messages);
    }
}
