package com.tcs.edu.service;

import com.tcs.edu.decorator.NumerateMessageDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.model.Severity;
import com.tcs.edu.printer.ConsolePrinter;

/**
 * Сервис для вывода декорированных сообщений
 *
 * @author s.saparbekov
 * **/
public class MessageService {
    public static int PAGE_SIZE = 3;

    /**
     * Метод выводит декорированные сообщения, и разделяет их согласно PAGE_SIZE
     *
     * @param message строка, которая будет сконкатинирована с ее уровнем важности
     * @param severity уровень важности
     *
     * **/
    public static void init(Severity severity, String... message) {
        for (String currentMessage: message) {
            String numeratedTimestampMessage =
                    NumerateMessageDecorator.decorate(TimestampMessageDecorator.decorate(currentMessage));
            String severityNumeratedTimestampMessage =
                    SeverityMessageDecorator.decorate(severity, numeratedTimestampMessage);
            String finalMessage = NumerateMessageDecorator.messageCount % PAGE_SIZE == 0
                    ? severityNumeratedTimestampMessage + "\n---"
                    : severityNumeratedTimestampMessage;
            ConsolePrinter.print(finalMessage);
        }
    }
}
