package by.bsuir.gunko7.Repositories;

import by.bsuir.gunko7.Entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TransportRepository extends JpaRepository<Transport, Long> {
    public Transport findByName(String name);

    public Transport findById(Integer id);

    @Transactional
    @Modifying
    @Query("update Transport t set t.name = ?1, t.max_capacity = ?2, t.unit_cost = ?3, t.speed = ?4, t.dangerous = ?6, t.fragile = ?7, t.perishable = ?8 where t.id = ?5")
    public void setUserInfoById(String name, Double max_capacity, Double unit_cost, Double speed, Integer id, Double dangerous, Double fragile, Double perishable);

    @Transactional
    public void deleteById(Integer id);
}