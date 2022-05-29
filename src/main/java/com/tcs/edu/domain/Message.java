package com.tcs.edu.domain;

import com.tcs.edu.model.Severity;

import java.util.Objects;

/**
 * Представление сообщений в виде объектов
 *
 * @author s.saparbekov
 */

public class Message {

    private final String body;
    private final Severity severity;

    /**
     * Конструктор класса Message
     *
     * @param severity уровень важности, не может быть null
     * @param body тело сообщения, не может быть null
     *
     * **/
    public Message(String body, Severity severity) {
        this.body = body;
        this.severity = severity;
    }

    /**
     * Конструктор класса Message. По-умолчанию уровень важности - REGULAR.
     *
     * @param body тело сообщения, не может быть null
     *
     * **/
    public Message(String body) {
        this(body, Severity.REGULAR);
    }

    /**
     * Конструктор класса Message.
     *
     * @param message сообщение
     * @param body тело сообщения, не может быть null
     *
     * **/
    public Message(Message message, String body) {
        this(body, message.severity);
    }

    /**
     * Получение тело сообщения.
     *
     * **/
    public String getBody() {
        return body;
    }

    /**
     * Получение уровня важности сообщения.
     *
     * **/
    public Severity getSeverity() {
        return severity;
    }

    /**
     * Операция сравнения сообщений.
     *
     * @param object сравниваемый объект
     *
     * **/
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (!(object instanceof Message)) {
            return false;
        }

        Message message = (Message) object;

        return (this.body.equals(message.body) && this.severity.equals(message.severity));
    }

    /**
     * Операция создания хеша объекта.
     *
     * **/
    @Override
    public int hashCode() {
        return Objects.hash(body, severity);
    }

    /**
     * Возвращает строку, представляющую объект.
     *
     * **/
    @Override
    public String toString() {
        return String.format("Message(%s, %s)", body, severity);
    }
}
