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

    @Column(name = "outp")
    String out;
    String target;
    Timestamp departure;
    Timestamp arrival;
    int places;

    public Flight(String out, String target, int places, Timestamp departure, Timestamp arrival) {
        this.out = out;
        this.target = target;
        this.departure = departure;
        this.arrival = arrival;
        this.places = places;
    }

    public Flight() {
    }
}
