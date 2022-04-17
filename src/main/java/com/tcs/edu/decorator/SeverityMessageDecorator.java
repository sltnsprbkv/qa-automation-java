package com.tcs.edu.decorator;

import com.tcs.edu.model.Severity;

/**
 * Декорирование сообщений с операцией добавления уровня важности сообщения
 *
 * @author s.saparbekov
 * **/
public class SeverityMessageDecorator {

    /**
     * Метод возвращает строку с уровнем важности (severity).
     *
     * @param message строка, которая будет сконкатинирована с ее уровнем важности
     * @param severity уровень важности
     *
     * **/
    public static String decorate(Severity severity, String message) {
        String severitySign;
        switch (severity) {
            case MAJOR:
                severitySign = "(!!!)";
                break;
            case REGULAR:
                severitySign = "(!)";
                break;
            case MINOR:
                severitySign = "()";
                break;
            default:
                throw new AssertionError("Unknown severity value");
        }
        return String.format("%s %s", message, severitySign);
    }
}
