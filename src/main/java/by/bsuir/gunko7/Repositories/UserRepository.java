package by.bsuir.gunko7.Repositories;

import by.bsuir.gunko7.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByNameAndPassword(String name, String password);

    public User findByName(String username);
}
