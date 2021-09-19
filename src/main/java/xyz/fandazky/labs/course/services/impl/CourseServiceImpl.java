package xyz.fandazky.labs.course.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fandazky.labs.course.models.dto.CourseDto;
import xyz.fandazky.labs.course.models.dto.SearchDto;
import xyz.fandazky.labs.course.models.entity.Course;
import xyz.fandazky.labs.course.repository.CourseRepository;
import xyz.fandazky.labs.course.services.CourseService;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public int addCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setImage(courseDto.getImage());
        course.setHourCount(courseDto.getHourCount());
        course.setViewCount(0);
        course.setPrice(courseDto.getPrice());
        course.setDesc(courseDto.getDescription());
        course.setContent(courseDto.getContent());
        course.setCateId(courseDto.getCategoryId());
        course.setLastUpdate(new Date());

        int id = courseRepository.saveAndFlush(course).getId();
        return id;
    }

    @Override
    public List<CourseDto> search(SearchDto searchDto) {
        return null;
    }
}