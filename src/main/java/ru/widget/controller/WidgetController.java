package ru.widget.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.widget.dto.WidgetDto;
import ru.widget.service.WidgetService;

import java.util.List;

@RestController
@RequestMapping("/widget")
public class WidgetController {

    @Autowired
    private WidgetService widgetService;

    @ApiOperation(value = "Create widget", notes = "Create new widget")
    @PostMapping("/create")
    public void createWidget(@RequestBody WidgetDto newWidget) {
        widgetService.createWidget(newWidget);
    }

    @ApiOperation(value = "Delete widget", notes = "Removing an existing widget by id")
    @DeleteMapping("/delete")
    public void deleteWidgetById(Long id) {
        widgetService.deleteWidgetById(id);
    }

    @ApiOperation(value = "Create widget", notes = "Create new widget with id")
    @GetMapping("/{id}")
    public WidgetDto create(@PathVariable Long id) {
        return widgetService.getWidgetById(id);
    }

    @ApiOperation(value = "Get by Z", notes = "Get widget by zIndex")
    @GetMapping
    public WidgetDto getWidgetByZ(@PathVariable Integer z) {
        return widgetService.getWidgetByZ(z);
    }

    @ApiOperation(value = "Get list", notes = "Get pageable list ordered by zIndex")
    @GetMapping("/list")
    public Page<WidgetDto> getList(@ApiParam(value = "page", required = true, defaultValue = "0")
                                        @RequestParam("page") int page,
                                   @ApiParam(value = "page size", required = true, defaultValue = "10")
                                        @RequestParam("size") int size,
                                   Pageable pageable) {
        return widgetService.getWidgets(pageable);
    }

    @ApiOperation(value = "Update widget", notes = "Update widget")
    @PutMapping("/update")
    public WidgetDto updateWidget(@RequestBody WidgetDto updatedWidget) {
        return widgetService.updateWidget(updatedWidget);
    }

}