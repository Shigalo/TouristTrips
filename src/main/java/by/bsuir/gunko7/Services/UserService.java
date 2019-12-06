package by.bsuir.gunko7.Services;

import by.bsuir.gunko7.Entities.Role;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Entities.User;
import by.bsuir.gunko7.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAll() { return userRepository.findAll(); }

    public User getCurrentUser(){
        try {
            org.springframework.security.core.userdetails.User authUser =
                    (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
                            .getAuthentication().getPrincipal();

            return findByName(authUser.getUsername());
        }catch (Exception e){
//            e.printStackTrace();
            return null;
        }
    }

    public boolean isAdmin() {
        if(getCurrentUser() != null) {
            return getCurrentUser().getRoles().contains(Role.ADMIN);
        }
        return false;
    }
    public boolean isLogin() {
        return getCurrentUser() != null;
    }
}
