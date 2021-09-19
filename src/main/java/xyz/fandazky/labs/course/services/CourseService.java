package xyz.fandazky.labs.course.services;

import xyz.fandazky.labs.course.models.dto.CourseDto;
import xyz.fandazky.labs.course.models.dto.SearchDto;

import java.util.List;

public interface CourseService {

    int addCourse(CourseDto courseDto);

    List<CourseDto> search(SearchDto searchDto);
}