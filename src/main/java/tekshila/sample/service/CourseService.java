package tekshila.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tekshila.sample.exception.CourseExistException;
import tekshila.sample.model.Course;
import tekshila.sample.repo.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Course addCourse(String courseName) {
        if(null != courseRepository.findByName(courseName))
            throw new CourseExistException("Course Exist");

        Course c = new Course();
            c.setName(courseName);
            return courseRepository.save(c);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(Integer courseId, String withStudents) {
        Course c = null;
        if(null != withStudents && "y".equalsIgnoreCase(withStudents)) {
           c  = courseRepository.findById(courseId).get();
        }
        return c;
    }
}
