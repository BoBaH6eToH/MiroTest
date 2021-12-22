package ru.widget.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.widget.dto.WidgetDto;
import ru.widget.entity.WidgetEntity;
import ru.widget.exception.WidgetNotFoundException;
import ru.widget.exception.WidgetWithoutIdException;
import ru.widget.repository.WidgetRepository;
import ru.widget.service.WidgetService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    private WidgetRepository widgetRepository;

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
    public WidgetDto getWidgetByZ(Integer z) {
        WidgetEntity widgetEntity = widgetRepository.findByZ(z.intValue());
        return entityToDto(widgetEntity);
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
    public Page<WidgetDto> getWidgets(Pageable pageable) {
        /*return widgetRepository.findAllOrderByZ(pageable).stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());*/
        Page<WidgetEntity> page = widgetRepository.findAllOrderByZ(pageable);
        Page<WidgetDto> dtoPage = page.map(new Function<WidgetEntity, WidgetDto>() {
            @Override
            public WidgetDto apply(WidgetEntity entity) {
                return entityToDto(entity);
            }
        });
        return dtoPage;
    }

    @Override
    public WidgetDto updateWidget(WidgetDto updatedWidget) {
        if (updatedWidget.getId() == null) {
            throw new WidgetWithoutIdException();
        }

        WidgetEntity widgetEntity = widgetRepository.findById(updatedWidget.getId())
                .orElse(null);
        if (widgetEntity == null) {
            throw new WidgetNotFoundException();
        }

        fillWidgetEntity(widgetEntity, updatedWidget);
        widgetEntity = widgetRepository.saveAndFlush(widgetEntity);
        return entityToDto(widgetEntity);
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

    private WidgetEntity dtoToEntity(WidgetDto dto){
        WidgetEntity widgetEntity = new WidgetEntity();
        widgetEntity.setId(dto.getId());
        widgetEntity.setX(dto.getX());
        widgetEntity.setY(dto.getY());
        widgetEntity.setZ(dto.getZ());
        widgetEntity.setHeight(dto.getHeight());
        widgetEntity.setWidth(dto.getWidth());
        widgetEntity.setLastModifiedDate(dto.getLastModifiedDate());
        return widgetEntity;
    }

    private void fillWidgetEntity(WidgetEntity widgetEntity, WidgetDto dto){
        widgetEntity.setX(dto.getX());
        widgetEntity.setY(dto.getY());
        widgetEntity.setZ(dto.getZ());
        widgetEntity.setHeight(dto.getHeight());
        widgetEntity.setWidth(dto.getWidth());
        widgetEntity.setLastModifiedDate(LocalDateTime.now());
    }


}

