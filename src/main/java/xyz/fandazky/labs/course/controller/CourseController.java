package xyz.fandazky.labs.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fandazky.labs.course.models.dto.CourseDto;
import xyz.fandazky.labs.course.services.CourseService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("")
    public Object create(@RequestBody CourseDto courseDto) {
        try {
            int id = courseService.addCourse(courseDto);
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));

            return new ResponseEntity(result, HttpStatus.CREATED);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}