package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Severity;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HashMapMessageRepositoryTest {

    @Test
    void shouldReturnEmptyHashMapMessageRepositoryCountTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();

        Assertions.assertEquals(hashMapMessageRepository.count(), 0);
    }

    @Test
    void shouldReturnNotEmptyHashMapMessageRepositoryCountTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));

        Assertions.assertEquals(hashMapMessageRepository.count(), 3);
    }

    @Test
    void shouldDeleteHashMapMessageRepositoryElementTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));
        hashMapMessageRepository.save(curMessage);

        hashMapMessageRepository.delete(curMessage);

        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage.getUuid()));
    }

    @Test
    void shouldDeleteAllHashMapMessageRepositoryElementsTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(curMessage1);
        hashMapMessageRepository.save(curMessage2);

        hashMapMessageRepository.deleteAll();

        Assertions.assertEquals(hashMapMessageRepository.count(), 0);
        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage1.getUuid()));
        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage2.getUuid()));
    }

    @Test
    void shouldDeleteAllByIdHashMapMessageRepositoryElementsTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(curMessage1);
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));
        hashMapMessageRepository.save(curMessage2);


        hashMapMessageRepository.deleteAllById(List.of(
                curMessage1.getUuid(),
                curMessage2.getUuid()
        ));

        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage1.getUuid()));
        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage2.getUuid()));
    }

    @Test
    void shouldDeleteByIdHashMapMessageRepositoryElementTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));
        hashMapMessageRepository.save(curMessage);

        hashMapMessageRepository.deleteById(curMessage.getUuid());

        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage.getUuid()));
    }

    @Test
    void shouldReturnIsExistsByIdHashMapMessageRepositoryElementTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));
        hashMapMessageRepository.save(curMessage1);
        hashMapMessageRepository.save(new Message(RandomStringUtils.randomAlphabetic(10)));

        Assertions.assertTrue(hashMapMessageRepository.existsById(curMessage1.getUuid()));
        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage2.getUuid()));
    }

    @Test
    void shouldFindAllHashMapMessageRepositoryElementsPositiveTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage3 = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(curMessage1);
        hashMapMessageRepository.save(curMessage2);

        Collection<Message> resultMessages = hashMapMessageRepository.findAll();

        Assertions.assertTrue(resultMessages.contains(curMessage1));
        Assertions.assertTrue(resultMessages.contains(curMessage2));
        Assertions.assertFalse(resultMessages.contains(curMessage3));
    }

    @Test
    void shouldFindAllByIdHashMapMessageRepositoryElementTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage3 = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(curMessage1);
        hashMapMessageRepository.save(curMessage2);

        Collection<Message> resultMessages = hashMapMessageRepository.findAllById(List.of(
                curMessage1.getUuid(),
                curMessage2.getUuid()
        ));

        Assertions.assertTrue(resultMessages.contains(curMessage1));
        Assertions.assertTrue(resultMessages.contains(curMessage2));
        Assertions.assertFalse(resultMessages.contains(curMessage3));
    }

    @Test
    void shouldFindByIdHashMapMessageRepositoryElementTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage3 = new Message(RandomStringUtils.randomAlphabetic(10));
        hashMapMessageRepository.save(curMessage1);
        hashMapMessageRepository.save(curMessage2);
        hashMapMessageRepository.save(curMessage3);

        Optional<Message> resultMessage = hashMapMessageRepository.findById(curMessage1.getUuid());

        Assertions.assertEquals(resultMessage.get(), curMessage1);
        Assertions.assertNotEquals(resultMessage.get(), curMessage2);
    }

    @Test
    void shouldSaveHashMapMessageRepositoryElementTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage = new Message(RandomStringUtils.randomAlphabetic(10));

        hashMapMessageRepository.save(curMessage);

        Assertions.assertEquals(hashMapMessageRepository.count(), 1);
        Assertions.assertTrue(hashMapMessageRepository.existsById(curMessage.getUuid()));
    }

    @Test
    void shouldSaveAllHashMapMessageRepositoryElementsTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10));
        var curMessage3 = new Message(RandomStringUtils.randomAlphabetic(10));

        hashMapMessageRepository.saveAll(List.of(
                curMessage2,
                curMessage3
        ));

        Assertions.assertEquals(hashMapMessageRepository.count(), 2);
        Assertions.assertTrue(hashMapMessageRepository.existsById(curMessage2.getUuid()));
        Assertions.assertTrue(hashMapMessageRepository.existsById(curMessage3.getUuid()));
        Assertions.assertFalse(hashMapMessageRepository.existsById(curMessage1.getUuid()));
    }

    @Test
    void shouldFindBySeverityHashMapMessageRepositoryElementTest() {
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        var curMessage1 = new Message(RandomStringUtils.randomAlphabetic(10), Severity.MINOR);
        var curMessage2 = new Message(RandomStringUtils.randomAlphabetic(10), Severity.REGULAR);
        var curMessage3 = new Message(RandomStringUtils.randomAlphabetic(10), Severity.MINOR);
        hashMapMessageRepository.save(curMessage1);
        hashMapMessageRepository.save(curMessage2);
        hashMapMessageRepository.save(curMessage3);

        Collection<Message> resultMessages = hashMapMessageRepository.findBySeverity(Severity.MINOR);

        Assertions.assertTrue(resultMessages.contains(curMessage1));
        Assertions.assertTrue(resultMessages.contains(curMessage3));
        Assertions.assertFalse(resultMessages.contains(curMessage2));
    }
}
