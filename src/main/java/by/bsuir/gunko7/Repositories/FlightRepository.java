package by.bsuir.gunko7.Repositories;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
//    public Flight findByName(String name);

    public Flight findById(Integer id);

    @Transactional
    public void deleteById(Integer id);

    public List<Flight> findByTarget(String target);

/*    @Transactional
    @Modifying
//    @Query("update Flight set complete = true where id = ?1")
    @Query("update Flight r set r.complete = true where r.id = ?1")
    public void setComplete(Integer id);*/

}
