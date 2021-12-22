package ru.widget.exception;

public class WidgetWithoutIdException extends RuntimeException {
    public WidgetWithoutIdException(final Throwable cause) {
        super(cause);
    }

    public WidgetWithoutIdException() {
        super();
    }
}
