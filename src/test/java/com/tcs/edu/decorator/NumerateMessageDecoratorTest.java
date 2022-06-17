package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumerateMessageDecoratorTest {

    private final NumerateMessageDecorator decorator = new NumerateMessageDecorator();

    @Test
    void shouldReturnNumDecoratedMessageTest() {
        // given
        var messageBody = "test message";
        var message = new Message(messageBody);
        // when
        var decoratedMessage = decorator.decorate(message);
        // then
        assertEquals(String.format("1 %s", messageBody), decoratedMessage.getBody());
    }
}
