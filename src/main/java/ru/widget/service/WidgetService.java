package ru.widget.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.widget.dto.WidgetDto;
import ru.widget.entity.WidgetEntity;

import java.util.List;

/**
 * Widget service class
 */
public interface WidgetService {

    /**
     * Widget creation
     * @param newWidget
     * @return WidgetDto
     */
    WidgetDto createWidget(WidgetDto newWidget);

    /**
     * Delete widget by ID
     * @param id
     */
    void deleteWidgetById(Long id);

    /**
     * Getting widget by id
     * @param id
     * @return WidgetDTO or null
     */
    WidgetDto getWidgetById(Long id);

    /**
     * Getting widget by zIndex
     * @param z zIndex
     * @return WidgetDTO or null
     */
    WidgetDto getWidgetByZ(Integer z);

    /**
     * Getting all widgets ordered by zIndex.
     * Pagination options may be defined in query parameters.
     * Default values:
     *  - page size = 10
     *  - pagination = true
     * @param pageable
     * @return
     */
    Page<WidgetDto> getWidgets(Pageable pageable);

    /**
     * Updation widget
     * @param updatedWidget
     * @return WidgetDto
     */
    WidgetDto updateWidget(WidgetDto updatedWidget);

}
