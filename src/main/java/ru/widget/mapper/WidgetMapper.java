//package ru.widget.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import ru.widget.dto.WidgetDto;
//import ru.widget.entity.WidgetEntity;
//
//@Mapper(componentModel = "spring")
//public interface WidgetMapper {
//
//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "x", target = "x")
//    @Mapping(source = "y", target = "y")
//    @Mapping(source = "z", target = "z")
//    @Mapping(source = "width", target = "width")
//    @Mapping(source = "height", target = "height")
//    @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
//    WidgetDto entityToDto(WidgetEntity entity);
//
//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "x", target = "x")
//    @Mapping(source = "y", target = "y")
//    @Mapping(source = "z", target = "z")
//    @Mapping(source = "width", target = "width")
//    @Mapping(source = "height", target = "height")
//    @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
//    WidgetEntity dtoToEntity(WidgetDto dto);
//
//}