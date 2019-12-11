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
    String target;//tour
    Timestamp departure;//from tour
    Timestamp arrival;
    Double cost;

    public Flight(String out, String target, Double cost, Timestamp departure, Timestamp arrival) {
        this.out = out;
        this.target = target;
        this.departure = departure;
        this.arrival = arrival;
        this.cost = cost;
    }

    public Flight() {
    }
}
