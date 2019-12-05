package by.bsuir.gunko7.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private Double cost;

    public Request(Tour tour, User user, Double cost) {
        this.tour = tour;
        this.user = user;
        this.cost = cost;
    }

    public Request() {

    }
}
