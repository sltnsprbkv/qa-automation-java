package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.interfaces.MessageRepository;
import com.tcs.edu.interfaces.MessageService;
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
    private final MessageRepository messageRepository;

    /**
     * Конструктор класса. Задает начальное состояние
     *
     * @param messageRepository объект вывода сообщений
     * @param decorator объекты декораторы
     *
     * **/
    public OrderedDistinctedMessageService(MessageRepository messageRepository, MessageDecorator decorator) {
        this.decorator = decorator;
        this.messageRepository = messageRepository;
    }

    /**
     * Метод выводит декорированные сообщения
     *
     * @param messages декорируемые сообщения
     *
     * **/
    @Override
    public void log(Stream<Message> messages) {
        messages
                .filter(Objects::nonNull)
                .map(decorator::decorate)
                .forEach(messageRepository::save);
    }

    /**
     * Метод выводит декорированные сообщения, кроме значений null
     *
     * @param messages декорируемые сообщения
     *
     * **/
    @Override
    public void log(Message... messages) {
        log(Arrays.stream(messages));
    }

    /**
     * Метод выводит отсортированные декорированные сообщения, кроме значений null
     *
     * @param messageOrder порядок сортировки
     * @param messages декорируемые сообщения
     *
     * **/
    @Override
    public void log(MessageOrder messageOrder, Message... messages) {
        var finalMessages = messages;
        if (messageOrder.equals(MessageOrder.DESC)) {
            CustomCollectionOperations.reverse(finalMessages);
        }
        log(finalMessages);
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
    public void log(
            MessageOrder messageOrder,
            Doubling doubling,
            Message... messages
    ) {
        log(messageOrder, doubling.equals(Doubling.DISTINCT)
                ? new HashSet<>(Arrays.asList(messages)).toArray(messages)
                : messages);
    }
}
