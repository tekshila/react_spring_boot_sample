package tekshila.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tekshila.sample.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
     public Course findByName(String name);

//     @Query("SELECT p FROM Course p LEFT JOIN FETCH p.users where p.id = ?1")
//     public Course findWithoutNPlusOne(Integer courseId);
}
