package com.tcs.edu.service;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeparateDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
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
     * @param messages декорируемые сообщения в stream
     *
     * **/
    public static void print(Stream<Message> messages) {
        messages
                .filter(Objects::nonNull)
                .map(message -> SeverityMessageDecorator.decorate(message.getSeverity(), message.getBody()))
                .map(TimestampMessageDecorator::decorate)
                .map(NumerateMessageDecorator::decorate)
                .map(SeparateDecorator::decorate)
                .forEach(ConsolePrinter::print);
    }

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param messages декорируемые сообщения
     *
     * **/
    public static void print(Message... messages) {
        print(Arrays.stream(messages));
    }

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null
     *
     * @param messageOrder порядок сортировки
     * @param messages декорируемые сообщения
     *
     * **/
    public static void print(MessageOrder messageOrder, Message... messages) {
        var finalMessages = messages;
        if (messageOrder.equals(MessageOrder.DESC)) {
            CustomCollectionOperations.reverse(finalMessages);
        }
        print(finalMessages);
    }

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null.
     * В зависимости от параметра дублирования выводит уникальные/дублирующиеся сообщения
     *
     * @param messageOrder порядок сортировки
     * @param doubling параметр дублирования
     * @param messages декорируемые сообщения
     *
     * **/
    public static void print(
            MessageOrder messageOrder,
            Doubling doubling,
            Message... messages
    ) {
        print(messageOrder, doubling.equals(Doubling.DISTINCT)
                ? new HashSet<>(Arrays.asList(messages)).toArray(messages)
                : messages);
    }
}
