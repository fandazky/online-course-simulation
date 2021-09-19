package xyz.fandazky.labs.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.fandazky.labs.course.models.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {


}
