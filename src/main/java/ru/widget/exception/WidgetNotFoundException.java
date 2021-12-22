package ru.widget.exception;

public class WidgetNotFoundException extends RuntimeException {
    public WidgetNotFoundException(final Throwable cause) {
        super(cause);
    }

    public WidgetNotFoundException() {
        super();
    }
}
