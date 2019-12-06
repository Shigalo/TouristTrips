package by.bsuir.gunko7.Services;

import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    @Autowired
    TourRepository tourRepository;

    public Tour getById(String id) {
        return tourRepository.findById(Integer.valueOf(id));
    }

    public void tourRemoveById(int id) {
        tourRepository.deleteById(id);
    }

    public List<Tour> findAll() { return tourRepository.findAll(); }

}
