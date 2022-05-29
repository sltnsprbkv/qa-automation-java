package com.tcs.edu;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeparateDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.model.Severity;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.repository.MessageService;
import com.tcs.edu.service.OrderedDistinctedMessageService;

class Application {
    public static void main(String[] args) {
        MessageDecorator separateDecorator = new SeparateDecorator();
        MessageDecorator severityMessageDecorator = new SeverityMessageDecorator(separateDecorator);
        MessageDecorator numerateMessageDecorator = new NumerateMessageDecorator(severityMessageDecorator);
        MessageDecorator timestampMessageDecorator = new TimestampMessageDecorator(numerateMessageDecorator);


        MessageService service = new OrderedDistinctedMessageService(
                new ConsolePrinter(),
                timestampMessageDecorator
        );
        service.print(new Message("message 1", Severity.MINOR));
        service.print(new Message("message 2", Severity.MAJOR), null); // Здесь пропускаем null
        service.print(
                new Message("message 2", Severity.MAJOR),
                new Message("message 3"),
                new Message("message 4", Severity.REGULAR));
//        service.print(new Message("😎", null)); // Тут выбрасывается исключение

        System.out.println("\n\n\n");
        service.print(MessageOrder.DESC,
                new Message("😪", Severity.MINOR),
                new Message("😑", Severity.REGULAR),
                new Message("😃", Severity.MAJOR),
                new Message("😎" )
        );

        System.out.println("\n\n\n");
        service.print(MessageOrder.DESC, Doubling.DISTINCT,
                new Message("😪", Severity.MINOR),
                new Message("😎" ),
                new Message("😑", Severity.REGULAR),
                new Message("😃", Severity.MAJOR),
                new Message("😎" )
        );

        System.out.println("\n\n\n");
        System.out.println(new Message("TO STRING", Severity.MAJOR));
    }
}
