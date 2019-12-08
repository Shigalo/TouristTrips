package by.bsuir.gunko7.Entities;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

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
    private Timestamp date;
    private Blob picture;
    private String about;

    public Tour(String target, String name, Integer places, Boolean post, Timestamp date, Blob picture, String about) {
        this.target = target;
        this.name = name;
        this.places = places;
        this.post = post;
        this.date = date;
        this.picture = picture;
        this.about = about;
    }

    public Tour(String target, String name, Integer places, Boolean post, Timestamp date) {
        this.target = target;
        this.name = name;
        this.places = places;
        this.post = post;
        this.date = date;
        this.picture = null;
        this.about = null;
    }

    public Tour() {
    }
}
