package com.tcs.edu.service;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.repository.HashMapMessageRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OrderedDistinctedMessageServiceTest {

    @Test
    void shouldSaveStreamToMessageRepository() {
        var decorator = new TimestampMessageDecorator();
        var messageRepository = new HashMapMessageRepository();
        var messageService = new OrderedDistinctedMessageService(
                messageRepository, decorator
        );
        var message1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message3 = new Message(RandomStringUtils.randomAlphabetic(10));
        var messages = Stream.of(
                message1, message2
        );

        messageService.log(messages);

        Assertions.assertThat(messageRepository.count()).isNotEqualTo(0);
        Assertions.assertThat(messageRepository.existsById(message1.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message2.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message3.getUuid())).isFalse();
    }

    @Test
    void shouldSaveArrayToMessageRepository() {
        var decorator = new TimestampMessageDecorator();
        var messageRepository = new HashMapMessageRepository();
        var messageService = new OrderedDistinctedMessageService(
                messageRepository, decorator
        );
        var message1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message3 = new Message(RandomStringUtils.randomAlphabetic(10));
        var messages = new Message[] {
                message1, message2
        };

        messageService.log(messages);

        Assertions.assertThat(messageRepository.count()).isNotEqualTo(0);
        Assertions.assertThat(messageRepository.existsById(message1.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message2.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message3.getUuid())).isFalse();
    }

    @Test
    void shouldSaveArrayToMessageRepositoryDesc() {
        var decorator = new TimestampMessageDecorator();
        var messageRepository = new HashMapMessageRepository();
        var messageService = new OrderedDistinctedMessageService(
                messageRepository, decorator
        );
        var message1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message3 = new Message(RandomStringUtils.randomAlphabetic(10));
        var messages = new Message[] {
                message1, message2
        };

        messageService.log(MessageOrder.DESC, messages);

        Assertions.assertThat(messageRepository.count()).isNotEqualTo(0);
        Assertions.assertThat(messageRepository.existsById(message1.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message2.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message3.getUuid())).isFalse();
    }

    @Test
    void shouldSaveArrayToMessageRepositoryDoubl() {
        var decorator = new TimestampMessageDecorator();
        var messageRepository = new HashMapMessageRepository();
        var messageService = new OrderedDistinctedMessageService(
                messageRepository, decorator
        );
        var message1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var message3 = new Message(RandomStringUtils.randomAlphabetic(10));
        var messages = new Message[] {
                message1, message2, message1
        };

        messageService.log(MessageOrder.DESC, Doubling.DISTINCT, messages);

        Assertions.assertThat(messageRepository.count()).isNotEqualTo(0);
        Assertions.assertThat(messageRepository.existsById(message1.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message2.getUuid())).isTrue();
        Assertions.assertThat(messageRepository.existsById(message3.getUuid())).isFalse();
    }

}
