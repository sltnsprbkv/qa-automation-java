package com.tcs.edu.interfaces;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Severity;

import java.util.Collection;
import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {

    /**
     *
     * @param severity уровень важности
     * @return возвращает сообщения с уровнем важности severity
     */
    Collection<Message> findBySeverity(Severity severity);
}
