package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;

public abstract class MessageDecorator implements Decorator<Message> {
    public MessageDecorator nextDecorator;

    public MessageDecorator() {
        this.nextDecorator = null;
    }

    public MessageDecorator(MessageDecorator nextDecorator) {
        this.nextDecorator = nextDecorator;
    }
}
