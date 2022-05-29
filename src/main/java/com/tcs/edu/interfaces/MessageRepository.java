package com.tcs.edu.interfaces;

import com.tcs.edu.domain.Message;

import java.util.UUID;

public interface MessageRepository extends CrudRepository<Message, UUID> {}

