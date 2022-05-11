package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;

import java.util.stream.Stream;

public interface MessageService {

    void print(Stream<Message> messages);
    void print(Message... messages);
}
