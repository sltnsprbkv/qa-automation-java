package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Severity;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SeverityMessageDecoratorTest {

    private final SeverityMessageDecorator decorator = new SeverityMessageDecorator();

    @ParameterizedTest
    @MethodSource("messageBodyProvider")
    void shouldReturnSevDecoratedMessageTest(Message message, String expectedMessageBody) {
        var decoratedMessage = decorator.decorate(message);
        assertEquals(decoratedMessage.getBody(), expectedMessageBody);
    }

    static Stream<Arguments> messageBodyProvider() {
        var minorMessage = new Message(RandomStringUtils.randomAlphabetic(10), Severity.MINOR);
        var regularMessage = new Message(RandomStringUtils.randomAlphabetic(10), Severity.REGULAR);
        var majorMessage = new Message(RandomStringUtils.randomAlphabetic(10), Severity.MAJOR);
        return Stream.of(
                arguments(minorMessage, String.format("%s ()", minorMessage.getBody())),
                arguments(regularMessage, String.format("%s (!)", regularMessage.getBody())),
                arguments(majorMessage, String.format("%s (!!!)", majorMessage.getBody()))
        );
    }
}
