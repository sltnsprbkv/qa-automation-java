package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.decorator.MessageDecorator;
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

    private final MessageDecorator decorator;
    private final Printer printer;

    /**
     * Конструктор класса. Задает начальное состояние
     *
     * @param printer объект вывода сообщений
     * @param decorator объекты декораторы
     *
     * **/
    public OrderedDistinctedMessageService(Printer printer, MessageDecorator decorator) {
        this.decorator = decorator;
        this.printer = printer;
    }

    /**
     * Метод выводит декорированные сообщения
     *
     * @param messages декорируемые сообщения
     *
     * **/
    @Override
    public void print(Stream<Message> messages) {
        messages
                .filter(Objects::nonNull)
                .map(decorator::decorate)
                .forEach(message -> printer.print(message.getBody()));
    }

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param messages декорируемые сообщения
     *
     * **/
    @Override
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
    @Override
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
    @Override
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
