package tekshila.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tekshila.sample.model.Course;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CourseDTO implements Serializable {
    private Integer id;
    private String name;

    public CourseDTO(Course c) {
        this.id = c.getId();
        this.name = c.getName();
    }

}
