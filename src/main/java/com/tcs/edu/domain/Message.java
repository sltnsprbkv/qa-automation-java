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
        if (body == null || severity == null) {
            throw new IllegalArgumentException("body or severity of message is null");
        }
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
        if (body == null) {
            throw new IllegalArgumentException("body of message is null");
        }
        this.body = body;
        this.severity = Severity.REGULAR;
    }

    /**
     * Конструктор класса Message.
     *
     * @param message сообщение
     * @param body тело сообщения, не может быть null
     *
     * **/
    public Message(Message message, String body) {
        if (body == null || message == null) {
            throw new IllegalArgumentException("message or body of message is null");
        }
        this.severity = message.severity;
        this.body = body;
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
}
