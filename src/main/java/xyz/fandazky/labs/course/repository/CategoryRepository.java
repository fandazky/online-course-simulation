package xyz.fandazky.labs.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.fandazky.labs.course.models.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}