package tekshila.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tekshila.sample.model.Course;
import tekshila.sample.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public Course addCourse(@RequestParam(name = "cn",required = true) String cName) {
        return courseService.addCourse(cName);
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }



}
