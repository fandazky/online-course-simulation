package xyz.fandazky.labs.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.fandazky.labs.course.models.dto.CourseDto;
import xyz.fandazky.labs.course.services.CourseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity create(@RequestBody CourseDto courseDto) {
        try {
            int id = courseService.addCourse(courseDto);
            Map<String, String> result = new HashMap<>();
            result.put("id", String.valueOf(id));

            return new ResponseEntity(result, HttpStatus.CREATED);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity search(@RequestParam String keyword) {
        try {
            List<CourseDto> dtos = courseService.search(keyword);
            return new ResponseEntity<Object>(dtos, HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}