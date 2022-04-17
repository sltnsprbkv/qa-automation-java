package com.tcs.edu;

import com.tcs.edu.model.Severity;
import com.tcs.edu.service.MessageService;

class Application {
    public static void main(String[] args) {
        MessageService.init(Severity.MAJOR, "qwewqewq");
        MessageService.init(Severity.MINOR, "dsadsa");
        MessageService.init(Severity.REGULAR, "zxcxz");
        MessageService.init(Severity.REGULAR, "hfgfh");
        MessageService.init(Severity.MINOR, "uyiiy");
    }
}
