package tekshila.sample.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tekshila.sample.model.Course;
import tekshila.sample.model.User;
import tekshila.sample.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User addUser(@Validated @RequestBody User user) {
        return userService.addUser(user);
    }

    @PatchMapping("/user/{user_id}")
    public User enrolCourseUpdUser(@PathVariable(name = "user_id",required = true) Integer userId, @RequestBody Course c) {
        return userService.enrolCourse(userId,c.getId());
    }

    @GetMapping("/user/{user_id}")
    public User getUser(@PathVariable(name="user_id") Integer userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
