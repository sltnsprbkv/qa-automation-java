package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Severity;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidatedMessageServiceTest {

    @ParameterizedTest
    @MethodSource("messageProvider")
    void shouldValidateMessageTest(Message message, Class clazz, String exceptionText) {
        assertThatExceptionOfType(clazz)
                .isThrownBy(() -> new ValidatedMessageService().isArgsValid(message))
                .withMessage(exceptionText);
    }

    static Stream<Arguments> messageProvider() {
        return Stream.of(
                arguments(null, IllegalArgumentException.class, "message is null"),
                arguments(new Message(null, Severity.MINOR),
                        IllegalArgumentException.class, "message body is null"),
                arguments(new Message("", Severity.MINOR),
                        IllegalArgumentException.class, "message body is empty"),
                arguments(new Message(RandomStringUtils.randomAlphabetic(10), null),
                        IllegalArgumentException.class, "message severity is null"),
                arguments(new Message(RandomStringUtils.randomAlphabetic(10), Severity.MINOR, null),
                        IllegalArgumentException.class, "message uuid is null")
        );
    }
}
