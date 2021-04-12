package tekshila.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tekshila.sample.model.Course;
import tekshila.sample.model.User;
import tekshila.sample.repo.CourseRepository;
import tekshila.sample.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
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


        Course c1 = new Course();
               c1.setName("java spring boot");
               courseRepository.save(c1);

        Course c2 = new Course();
               c2.setName("nodejs");
               courseRepository.save(c2);

        User user1 = new User();
             user1.setName("user1");
             user1.setEmail("user1@tekshila.com");
             userRepository.save(user1);

        User user2 = new User();
             user2.setName("user2");
             user2.setEmail("user2@tekshila.com");
             userRepository.save(user2);

        Set<Course> clist1 = new HashSet<>();
           clist1.add(courseRepository.findByName("nodejs"));

           User u1 = userRepository.findByEmail("user1@tekshila.com");
                u1.setCourses(clist1);
                userRepository.save(u1);

                Set<Course> clist2 = new HashSet<>();
//        clist2.add(courseRepository.findByName("nodejs"));

        clist2.add(courseRepository.findByName("java spring boot"));
        User u2 = userRepository.findByEmail("user2@tekshila.com");
             u2.setCourses(clist2);
        userRepository.save(u2);


    }


}
