package ru.widget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.widget.dto.WidgetDto;
import ru.widget.service.WidgetService;

import java.util.List;

@RestController
@RequestMapping("/widget")
public class WidgetController {

    @Autowired
    private WidgetService widgetService;

    @GetMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/create/{id}")
    public void create(@PathVariable("id") int value) {
        widgetService.create(value);
    }

    @PostMapping("/create")
    public void createWidget(@RequestBody WidgetDto newWidget) {
        widgetService.createWidget(newWidget);
    }

    @DeleteMapping("/delete")
    public void deleteWidgetById(Long id) {
        widgetService.deleteWidgetById(id);
    }

    @GetMapping("/{id}")
    public WidgetDto create(@PathVariable Long id) {
        return widgetService.getWidgetById(id);
    }

    @GetMapping("/list")
    public List<WidgetDto> getList() {
        return widgetService.getWidgets();
    }

}