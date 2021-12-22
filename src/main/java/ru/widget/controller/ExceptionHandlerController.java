package ru.widget.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.widget.exception.WidgetNotFoundException;
import ru.widget.exception.WidgetWithoutIdException;

import java.net.SocketTimeoutException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(WidgetWithoutIdException.class)
    @ResponseBody
    public String widgetWithoutIdException() {
        return "Widget ID is null";
    }

    @ExceptionHandler(WidgetNotFoundException.class)
    @ResponseBody
    public String widgetNotFoundException() {
        return "Widget not found";
    }
}