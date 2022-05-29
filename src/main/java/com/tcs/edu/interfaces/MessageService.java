package com.tcs.edu.interfaces;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;

import java.util.stream.Stream;

public interface MessageService {

    void log(Stream<Message> messages);
    void log(Message... messages);
    void log(MessageOrder messageOrder, Message... messages);
    void log(MessageOrder messageOrder, Doubling doubling, Message... messages);
}
