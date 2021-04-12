package tekshila.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tekshila.sample.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
     public Course findByName(String name);
}
