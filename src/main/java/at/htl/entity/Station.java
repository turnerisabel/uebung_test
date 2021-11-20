package at.htl.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STATION")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Line line;

    @ManyToOne
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    private Station prevStation;

    public Station() {
    }

    public Station(Long id, Line line, Location location, Station prevStation) {
        this.id = id;
        this.line = line;
        this.location = location;
        this.prevStation = prevStation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Station getPrevStation() {
        return prevStation;
    }

    public void setPrevStation(Station prevStation) {
        this.prevStation = prevStation;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", line=" + line +
                ", location=" + location +
                ", prevStation=" + prevStation +
                '}';
    }
}


