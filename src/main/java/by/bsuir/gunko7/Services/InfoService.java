package by.bsuir.gunko7.Services;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.Info;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Repositories.FlightRepository;
import by.bsuir.gunko7.Repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    InfoRepository infoRepository;

    public void addInfo(Info info) {
        infoRepository.save(info);
    }

    public Info getById(String id) {
        return infoRepository.findById(Integer.valueOf(id));
    }

    public List<Info> findAll() {
        return infoRepository.findAll();
    }

    public void removeById(int id) {
        infoRepository.deleteById(id);
    }

    public List<Info> findByTour(Tour tour) {
        return infoRepository.findByTour(tour);
    }

    public void clear(Tour tour) {
        infoRepository.deleteByTour(tour);
    }
}
