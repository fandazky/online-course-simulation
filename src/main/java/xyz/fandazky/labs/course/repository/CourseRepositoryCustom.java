package xyz.fandazky.labs.course.repository;

import xyz.fandazky.labs.course.models.dto.CourseDto;
import xyz.fandazky.labs.course.models.dto.SearchDto;

import java.util.List;

public interface CourseRepositoryCustom {

    List<CourseDto> searchCourse(SearchDto dto);
}