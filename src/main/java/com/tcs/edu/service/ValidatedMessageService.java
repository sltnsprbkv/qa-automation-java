package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.interfaces.ValidatedService;

public class ValidatedMessageService implements ValidatedService<Message> {

    public void isArgsValid(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("message is null");
        }
        if (message.getBody() == null) {
            throw new IllegalArgumentException("message body is null");
        }
        if (message.getBody().length() == 0) {
            throw new IllegalArgumentException("message body is empty");
        }
        if (message.getSeverity() == null) {
            throw new IllegalArgumentException("message severity is null");
        }
        if (message.getUuid() == null) {
            throw new IllegalArgumentException("message uuid is null");
        }
    }
}
