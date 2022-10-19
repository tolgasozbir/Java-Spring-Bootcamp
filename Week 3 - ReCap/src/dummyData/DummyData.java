package dummyData;

import java.util.ArrayList;
import java.util.List;

import entities.Category;
import entities.Course;
import entities.Instructor;

public class DummyData {
    //disabled new instance creation
    private DummyData(){}

    public static List<Category> dummyCategories = new ArrayList<Category>() {{
        add(new Category(1, "C#"));
        add(new Category(2, "Java"));
        add(new Category(3, "JavaScript"));
    }};    
    
    public static List<Instructor> dummyInstructors = new ArrayList<Instructor>() {{
        add(new Instructor(1, "Veli Bacık"));
        add(new Instructor(2, "Kasım Adalan"));
    }};    
    
    public static List<Course> dummyCourses = new ArrayList<Course>() {{}};
}
