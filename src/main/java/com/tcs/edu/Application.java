package com.tcs.edu;

import com.tcs.edu.model.Severity;
import com.tcs.edu.service.MessageService;

class Application {
    public static void main(String[] args) {
        MessageService.init(Severity.MAJOR, "qwewqewq");
        MessageService.init(Severity.MINOR, "dsadsa", "uyiiy");
        MessageService.init(Severity.REGULAR, "zxcxz", "hfgfh", "plmd");
        MessageService.init(Severity.MAJOR, "zxcvnmm");
    }
}
