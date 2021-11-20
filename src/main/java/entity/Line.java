package entity;

import javax.persistence.*;

@Entity
@Table(name = "LL_LINE")
@NamedQueries({
        @NamedQuery(
                name = "Line.findByName",
                query = "select l from Line l where l.name like: NAME"
        )
})
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LI_ID")
    private Long id;

    @Column(name = "LI_NAME", unique = true)
    private String name;

    public Line() {
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
        return "Line{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
