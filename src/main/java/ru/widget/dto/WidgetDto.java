package ru.widget.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WidgetDto {

    private Long id;

    private Integer z;

    private Integer width;

    private Integer height;

    private Integer x;

    private Integer y;

    private LocalDateTime lastModifiedDate;
}
