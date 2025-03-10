package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;
import com.tcs.edu.exception.CrudOperationException;
import com.tcs.edu.interfaces.MessageRepository;
import com.tcs.edu.model.Severity;
import com.tcs.edu.service.ValidatedMessageService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@code com.tcs.edu.printer.HashMapMessageRepository} Репозиторий сообщений с CRUD операциями
 *
 * @author s.saparbekov
 * **/

public class HashMapMessageRepository extends ValidatedMessageService implements MessageRepository {

    private final Map<UUID, Message> messages = new HashMap<>();

    @Override
    public long count() {
        return messages.size();
    }

    @Override
    public void delete(Message message) {
        try {
            super.isArgsValid(message);
            messages.remove(message.getUuid());
        } catch (IllegalArgumentException e) {
            throw new CrudOperationException("delete operation is cancelled", e);
        }
    }

    @Override
    public void deleteAll() {
        messages.clear();
    }

    @Override
    public void deleteAll(Iterable<? extends Message> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        uuids.forEach(this::deleteById);
    }

    @Override
    public void deleteById(UUID uuid) {
        messages.remove(uuid);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return messages.containsKey(uuid);
    }

    @Override
    public Collection<Message> findAll() {
        return messages.values();
    }

    @Override
    public Collection<Message> findAllById(Iterable<UUID> uuids) {
        Collection<Message> resultMessages = new ArrayList<>();
        uuids.forEach(uuid -> {
            Optional<Message> message = findById(uuid);
            message.ifPresent(resultMessages::add);
        });
        return resultMessages;
    }

    @Override
    public Optional<Message> findById(UUID uuid) {
        Message resultMessage = messages.get(uuid);
        return Optional.ofNullable(resultMessage);
    }

    @Override
    public <S extends Message> void save(S entity) {
        try {
            super.isArgsValid(entity);
            messages.put(entity.getUuid(), entity);
        } catch (IllegalArgumentException e) {
            throw new CrudOperationException("save operation is cancelled", e);
        }
    }

    @Override
    public <S extends Message> void saveAll(Iterable<S> entities) {
        entities.forEach(this::save);
    }

    @Override
    public Collection<Message> findBySeverity(Severity severity){
        return findAll().stream()
                .filter(message -> message.getSeverity().equals(severity))
                .collect(Collectors.toList());
    }
}
