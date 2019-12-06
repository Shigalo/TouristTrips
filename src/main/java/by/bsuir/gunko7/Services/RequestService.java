package by.bsuir.gunko7.Services;

import by.bsuir.gunko7.Entities.Request;
import by.bsuir.gunko7.Entities.User;
import by.bsuir.gunko7.Repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public void addRequest(Request request) {
        requestRepository.save(request);
    }

    public List<Request> getRequestList(User user) {
        return requestRepository.findByUser(user);
    }

    public Request getById(String id) {
        return requestRepository.findById(Integer.valueOf(id));
    }

    public void RequestRemoveById(int id) {
        requestRepository.deleteById(id);
    }

    public List<Request> findAll() {
        return requestRepository.findAll();
    }
}
