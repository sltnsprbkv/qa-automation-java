package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;

import java.util.stream.Stream;

public interface MessageService {

    void print(Stream<Message> messages);
    void print(Message... messages);
    void print(MessageOrder messageOrder, Message... messages);
    void print(MessageOrder messageOrder, Doubling doubling, Message... messages);
}
