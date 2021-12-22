package ru.widget.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.widget.dto.WidgetDto;
import ru.widget.entity.WidgetEntity;

import java.util.List;

/**
 * JavaDoc
 */
public interface WidgetService {

    WidgetDto createWidget(WidgetDto newWidget);

    void deleteWidgetById(Long id);

    WidgetDto getWidgetById(Long id);

    WidgetDto getWidgetByZ(Integer z);

    Page<WidgetDto> getWidgets(Pageable pageable);

    WidgetDto updateWidget(WidgetDto updatedWidget);

}
