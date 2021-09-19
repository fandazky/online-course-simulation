package xyz.fandazky.labs.course.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_courses")
public class UserCourse {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserCourseKey id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    public UserCourse() {

    }

    public UserCourse(UserCourseKey id) {
        this.id = id;
    }

    public UserCourseKey getId() {
        return id;
    }

    public void setId(UserCourseKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}