package ru.widget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.widget.entity.WidgetEntity;

import java.util.List;

@Repository
public interface WidgetRepository extends JpaRepository<WidgetEntity, Long> {

    WidgetEntity findByZ(int zIndex);

    @Query("from WidgetEntity widget order by widget.z asc")
    List<WidgetEntity> findAllOrderByZ();

}
