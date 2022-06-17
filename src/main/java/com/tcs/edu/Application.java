package com.tcs.edu;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeparateDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.interfaces.MessageRepository;
import com.tcs.edu.model.Severity;
import com.tcs.edu.repository.HashMapMessageRepository;
import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.interfaces.MessageService;
import com.tcs.edu.service.OrderedDistinctedMessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Application {
    public static void main(String[] args) {
        Message message = Message.builder()
                .body("123")
                .severity(Severity.MINOR)
                .build();

        System.out.println(message);


        //---------------------------------------------------------------------------------------

        Message m1 = new Message("message 3", Severity.MAJOR);
        Message m2 = new Message("message 7", Severity.MAJOR);

        System.out.println(m1);


        MessageRepository messageRepository = new HashMapMessageRepository();
        ArrayList<Message> lst = new ArrayList<>();

        lst.add(new Message("message 1", Severity.MAJOR));
        lst.add(new Message("message 2", Severity.MAJOR));
        lst.add(m1);
        lst.add(new Message("message 4", Severity.MAJOR));
        lst.add(new Message(null, Severity.MAJOR));             // тут исключение с "caused by"
        lst.add(new Message("message 5", Severity.MAJOR));

        List<UUID> uuids = new ArrayList<>();
        uuids.add(m1.getUuid());
        uuids.add(m2.getUuid());

//        var t = messageRepository.saveAll(lst);
//        messageRepository.delete(m1);
//        System.out.println(messageRepository.count());
//        System.out.println(messageRepository.findAll());

        //--------------------------------------------------------------------------------------

        MessageDecorator separateDecorator = new SeparateDecorator();
        MessageDecorator severityMessageDecorator = new SeverityMessageDecorator(separateDecorator);
        MessageDecorator numerateMessageDecorator = new NumerateMessageDecorator(severityMessageDecorator);
        MessageDecorator timestampMessageDecorator = new TimestampMessageDecorator(numerateMessageDecorator);

        MessageService service = new OrderedDistinctedMessageService(
                messageRepository,
                timestampMessageDecorator
        );

        service.log(m1, m2);

        System.out.println(messageRepository.findAll());
    }
}
