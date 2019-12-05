package by.bsuir.gunko7.Repositories;

import by.bsuir.gunko7.Entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    public Point findByName(String name);

    public List<Point> findByWayNull();

    public List<Point> findByNameNotNull();

    public Point findById(Integer id);

    @Transactional//при изменении бд
    @Modifying//модификация метода (запрос вручную)
    @Query("update Point p set p.name = ?1 where p.id = ?2")
    public void setUserInfoById(String name, Integer id);

    @Transactional
    public void deleteById(Integer id);

    public List<Point> findByWay_Id(Integer id);
}
