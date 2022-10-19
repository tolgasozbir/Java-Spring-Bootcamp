package business;

import java.util.List;

import dataAccess.IDatabase;
import dummyData.DummyData;
import entities.Course;

public class CourseManager {
    private IDatabase database;

    public CourseManager(IDatabase database) {
        this.database = database;
    }

    public void add(Course course){
        try {
            if (course.getPrice() < 0) {
                throw new Exception("The course price cannot be less than 0");
            }
            for (Course c : DummyData.dummyCourses) {
                if (c.getName() == course.getName()) {
                    throw new Exception("A course with this name already exists");
                }
            }
            
            database.addCourse(course);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Course> getAllCourse(){
        return database.getCourseList();
    }
}
