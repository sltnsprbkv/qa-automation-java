package com.tcs.edu;

import com.tcs.edu.model.Severity;
import com.tcs.edu.service.MessageService;

class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MAJOR, "qwewqewq");
        MessageService.print(Severity.MINOR, "dsadsa", null);
        MessageService.print(Severity.REGULAR, "zxcxz", "hfgfh", "plmd");
        MessageService.print(Severity.MAJOR, "null");
    }
}
