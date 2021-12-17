package ru.widget.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TestTable")
public class WidgetEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Integer z;

    @Column
    private Integer width;

    @Column
    private Integer height;

    @Column
    private Integer x;

    @Column
    private Integer y;

    @Column
    private LocalDateTime lastModifiedDate;

}
