package com.tcs.edu.service;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeparateDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.repository.Decorator;
import com.tcs.edu.repository.MessageService;
import com.tcs.edu.repository.Printer;
import com.tcs.edu.utils.CustomCollectionOperations;

import java.util.*;
import java.util.stream.Stream;

/**
 * Сервис для вывода декорированных сообщений
 *
 * @author s.saparbekov
 * **/

public class OrderedDistinctedMessageService implements MessageService {

    private final Decorator<Message> severityMessageDecorator = new SeverityMessageDecorator();
    private final Decorator<String> timestampMessageDecorator = new TimestampMessageDecorator();
    private final Decorator<String> numerateMessageDecorator = new NumerateMessageDecorator();
    private final Decorator<String> separateDecorator = new SeparateDecorator();
    private final Printer printer = new ConsolePrinter();

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param messages декорируемые сообщения в stream
     *
     * **/
    public void print(Stream<Message> messages) {
        messages
                .filter(Objects::nonNull)
                .map(severityMessageDecorator::decorate)
                .map(timestampMessageDecorator::decorate)
                .map(numerateMessageDecorator::decorate)
                .map(separateDecorator::decorate)
                .forEach(printer::print);
    }

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param messages декорируемые сообщения
     *
     * **/
    public void print(Message... messages) {
        print(Arrays.stream(messages));
    }

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null
     *
     * @param messageOrder порядок сортировки
     * @param messages декорируемые сообщения
     *
     * **/
    public void print(MessageOrder messageOrder, Message... messages) {
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
    public void print(
            MessageOrder messageOrder,
            Doubling doubling,
            Message... messages
    ) {
        print(messageOrder, doubling.equals(Doubling.DISTINCT)
                ? new HashSet<>(Arrays.asList(messages)).toArray(messages)
                : messages);
    }
}
