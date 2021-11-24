package xyz.fandazky.labs.course.services.impl;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import xyz.fandazky.labs.course.models.dto.CourseDto;
import xyz.fandazky.labs.course.models.dto.SearchDto;
import xyz.fandazky.labs.course.models.entity.Course;
import xyz.fandazky.labs.course.models.entity.CourseElasticsearch;
import xyz.fandazky.labs.course.repository.CourseRepository;
import xyz.fandazky.labs.course.services.CourseService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

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

        return courseRepository.saveAndFlush(course).getId();
    }

    @Override
    public List<CourseDto> search(String keyword) {

        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", keyword);

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<CourseElasticsearch> courseHits = elasticsearchOperations
                .search(searchQuery, CourseElasticsearch.class, IndexCoordinates.of("course"));

        return courseHits.stream().map(courseHit -> {
            CourseElasticsearch courseElasticsearch = courseHit.getContent();
            CourseDto dto = new CourseDto();
            dto.setTitle(courseElasticsearch.getTitle());
            dto.setDescription(courseElasticsearch.getDescription());
            dto.setPrice(courseElasticsearch.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> search(SearchDto searchDto) {
        return courseRepository.searchCourse(searchDto);
    }
}