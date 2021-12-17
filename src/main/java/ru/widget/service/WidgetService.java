package ru.widget.service;

import ru.widget.dto.WidgetDto;
import ru.widget.entity.WidgetEntity;

import java.util.List;

public interface WidgetService {

    void create(int value);

    WidgetDto createWidget(WidgetDto newWidget);

    void deleteWidgetById(Long id);

    WidgetDto getWidgetById(Long id);

    List<WidgetDto> getWidgets();

}
