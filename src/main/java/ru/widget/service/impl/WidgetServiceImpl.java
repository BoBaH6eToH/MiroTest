package ru.widget.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.widget.dto.WidgetDto;
import ru.widget.entity.WidgetEntity;
import ru.widget.repository.WidgetRepository;
import ru.widget.service.WidgetService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    private WidgetRepository widgetRepository;

    @Override
    @Transactional
    public void create(int value) {
//        WidgetEntity widgetEntity = new WidgetEntity();
//        widgetEntity.setZIndex(value);
//        testRepository.saveAndFlush(widgetEntity);
    }

    @Override
    public WidgetDto createWidget(WidgetDto newWidget) {
        WidgetEntity widgetEntity = WidgetEntity.builder()
                .x(newWidget.getX())
                .y(newWidget.getY())
                .width(newWidget.getWidth())
                .height(newWidget.getHeight())
                .z(newWidget.getZ() == null ? 0 : newWidget.getZ())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        widgetRepository.saveAndFlush(widgetEntity);
        return null;
    }

    @Override
    public void deleteWidgetById(Long id) {
        widgetRepository.deleteById(id);
    }

    @Override
    public WidgetDto getWidgetById(Long id) {
        WidgetEntity widgetEntity = widgetRepository.findById(id)
                .orElse(null);
        return entityToDto(widgetEntity);
    }

    @Override
    public List<WidgetDto> getWidgets() {
        return widgetRepository.findAllOrderByZ().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private WidgetDto entityToDto(WidgetEntity entity){
        WidgetDto widgetDto = new WidgetDto();
        widgetDto.setId(entity.getId());
        widgetDto.setX(entity.getX());
        widgetDto.setY(entity.getY());
        widgetDto.setZ(entity.getZ());
        widgetDto.setHeight(entity.getHeight());
        widgetDto.setWidth(entity.getWidth());
        widgetDto.setLastModifiedDate(entity.getLastModifiedDate());
        return widgetDto;
    }

}

