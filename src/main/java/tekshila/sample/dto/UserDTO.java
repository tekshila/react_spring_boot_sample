package tekshila.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tekshila.sample.model.Course;
import tekshila.sample.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO implements Serializable {
    private Integer id;

    private String name;

    private String email;

    private List<CourseDTO> courseDTOS;

    public UserDTO(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.email = u.getEmail();
        courseDTOS = new ArrayList<>();
        for(Course c: u.getCourses()) {
            courseDTOS.add(new CourseDTO(c));
        }
    }
}
