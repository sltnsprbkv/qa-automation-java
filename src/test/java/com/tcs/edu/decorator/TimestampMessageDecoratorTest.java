package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimestampMessageDecoratorTest {

    private final TimestampMessageDecorator decorator = new TimestampMessageDecorator();

    @Test
    void shouldReturnTimDecoratedMessageTest() {
        // given
        var messageBody = "testmessage";
        var message = new Message(messageBody);
        // when
        var decoratedMessage = decorator.decorate(message);
        var wrds = decoratedMessage.getBody().split(" ");
        // then
        assertTrue(wrds[0].matches("^(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{2,10})Z$")); // 2022-06-02T16:02:38.063300600Z
        assertEquals(messageBody, wrds[1]);
    }

}
