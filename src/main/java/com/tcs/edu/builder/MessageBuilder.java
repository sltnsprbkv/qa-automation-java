package com.tcs.edu.builder;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Severity;

import java.util.UUID;

public class MessageBuilder {

    private String body;
    private Severity severity;
    private UUID uuid;

    public MessageBuilder() {}

    public MessageBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public MessageBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    public MessageBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public Message build() {
        return uuid == null ? new Message(body, severity) : new Message(body, severity, uuid);
    }
}
