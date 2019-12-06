package by.bsuir.gunko7.Services;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.User;
import by.bsuir.gunko7.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public void addFlight(Flight flight) {
        System.out.println(flight);
        flightRepository.save(flight);
    }

    public Flight getById(String id) {
        return flightRepository.findById(Integer.valueOf(id));
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public void removeById(int id) {
        flightRepository.deleteById(id);
    }
}