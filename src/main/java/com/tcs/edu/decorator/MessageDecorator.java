package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.Decorator;

public abstract class MessageDecorator implements Decorator<Message> {
    public MessageDecorator nextDecorator;

    public MessageDecorator() {
        this.nextDecorator = null;
    }

    public MessageDecorator(MessageDecorator nextDecorator) {
        this.nextDecorator = nextDecorator;
    }
}
