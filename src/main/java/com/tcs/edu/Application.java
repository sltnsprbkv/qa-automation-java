package com.tcs.edu;

import com.tcs.edu.model.Doubling;
import com.tcs.edu.model.MessageOrder;
import com.tcs.edu.model.Severity;
import com.tcs.edu.service.MessageService;

class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MAJOR, "qwewqewq");
        MessageService.print(Severity.MINOR, "dsadsa", null);
        MessageService.print(Severity.REGULAR, "zxcxz", "hfgfh", "plmd");
        MessageService.print(Severity.MAJOR, "null");

        System.out.println("\n\n\n");
        MessageService.print(Severity.REGULAR, MessageOrder.DESC, "message 1",
                "message 2", "message 3", "message 4", "message 5", null, "message 7");

        System.out.println("\n\n\n");
        MessageService.print(Severity.REGULAR, MessageOrder.DESC, Doubling.DISTINCT, "message 1",
                "message 2", "message 5", "message 5", "message 5", null, "message 7");
    }
}
