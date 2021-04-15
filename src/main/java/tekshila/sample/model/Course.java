package tekshila.sample.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "courses")
public class Course implements Serializable {

    public Course(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

//    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<User> students = new HashSet<>();

}
