package com.tcs.edu;

import com.tcs.edu.domain.Message;
import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.model.Severity;
import com.tcs.edu.service.MessageService;

class Application {
    public static void main(String[] args) {
        MessageService.print(new Message("message 1", Severity.MINOR));
        MessageService.print(new Message("message 2", Severity.MAJOR), null); // Здесь пропускаем null
        MessageService.print(
                new Message("message 2", Severity.MAJOR),
                new Message("message 3"),
                new Message("message 4", Severity.REGULAR));
//        MessageService.print(new Message("😎", null)); // Тут выбрасывается исключение

        System.out.println("\n\n\n");
        MessageService.print(MessageOrder.DESC,
                new Message("😪", Severity.MINOR),
                new Message("😑", Severity.REGULAR),
                new Message("😃", Severity.MAJOR),
                new Message("😎" )
        );

        System.out.println("\n\n\n");
        MessageService.print(MessageOrder.DESC, Doubling.DISTINCT,
                new Message("😪", Severity.MINOR),
                new Message("😎" ),
                new Message("😑", Severity.REGULAR),
                new Message("😃", Severity.MAJOR),
                new Message("😎" )
        );
    }
}
