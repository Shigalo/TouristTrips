package by.bsuir.gunko7.Entities;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Data
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String target;
    private String name;
    private Integer places;
    private Boolean post;

    public Tour(String target, String name, Integer places, Boolean post) {
        this.target = target;
        this.name = name;
        this.places = places;
        this.post = post;
    }

    public Tour() {
    }
}
