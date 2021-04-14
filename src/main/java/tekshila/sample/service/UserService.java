package tekshila.sample.service;

import org.springframework.stereotype.Service;
import tekshila.sample.exception.CourseNotFoundException;
import tekshila.sample.exception.UserExistException;
import tekshila.sample.exception.UserNotFoundException;
import tekshila.sample.model.Course;
import tekshila.sample.model.User;
import tekshila.sample.repo.CourseRepository;
import tekshila.sample.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public UserService(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }


    @Transactional
    public User addUser(User user) {
        if(null != userRepository.findByEmail(user.getEmail()))
            throw new UserExistException("User already exists");

        userRepository.save(user);

        return userRepository.findByEmail(user.getEmail());
    }

    @Transactional
    public User enrolCourse(Integer userId, Integer courseId) {
        User u = null;
        Optional<User> userOpt = userRepository.findById(userId);
            if(userOpt.isPresent()) {
                u = userOpt.get();
            }
            else {
                throw new UserNotFoundException("User doesnot exist");
            }

        Course course = new Course();
               course.setId(courseId);
//        Optional<Course> c = courseRepository.findById(courseId);
//        if(!c.isPresent()) {
//            throw new CourseNotFoundException("Course not found");
//        }
            u.getCourses().add(course);
            userRepository.save(u);

            return new User();
    }

    public User getUser(Integer userId) {
        User user = userRepository.findById(userId).get();
            user.getCourses();
            return user;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
