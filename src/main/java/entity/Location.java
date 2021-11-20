package entity;

import javax.persistence.*;

@Entity
@Table(name = "LL_LOCATION")
@NamedQueries({
        @NamedQuery(
                name = "Location.findByName",
                query = "select l from Location l where l.name like: NAME"
        )
})
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LO_ID")
    private Long id;

    @Column(name = "LO_NAME")
    private String name;

    public Location() {
    }

    public Location(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Location(String station) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


