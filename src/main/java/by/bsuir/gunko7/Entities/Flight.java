package by.bsuir.gunko7.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    String outp;
    String target;
    Timestamp departure;
    Timestamp arrival;
    int places;
    int tickets = 0;

    public Flight(String outp, String target, Timestamp departure, Timestamp arrival, int places, int tickets) {
        this.outp = outp;
        this.target = target;
        this.departure = departure;
        this.arrival = arrival;
        this.places = places;
        this.tickets = tickets;
    }

    public Flight() {
    }
}
