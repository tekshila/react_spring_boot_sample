package tekshila.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tekshila.sample.model.Course;
import tekshila.sample.model.User;
import tekshila.sample.repo.CourseRepository;
import tekshila.sample.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Stream;

@Component
public class InitializeDB implements CommandLineRunner {

    private UserRepository userRepository;
    private CourseRepository courseRepository;

    @Autowired
    public InitializeDB(UserRepository userRepository,
                        CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        // create a student
        User student = new User("John Doe", "jdoe@jgak.com");

        // save the student
        userRepository.save(student);

        // create three courses
        Course course1 = new Course("Machine Learning");
        Course course2 = new Course("Database Systems");
        Course course3 = new Course("Web Basics");

        // save courses
        courseRepository.saveAll(Arrays.asList(course1, course2, course3));

        // add courses to the student
        student.getCourses().addAll(Arrays.asList(course1, course2, course3));

        // update the student
        userRepository.save(student);

    }


}
