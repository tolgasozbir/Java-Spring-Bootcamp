package business;

import dataAccess.IDatabase;
import dummyData.DummyData;
import entities.Instructor;

public class InstructorManager {
    private IDatabase database;

    public InstructorManager(IDatabase database){
        this.database = database;
    }

    public void add(Instructor instructor){
        try {
            for (Instructor i : DummyData.dummyInstructors) {
                if (i.getName() == instructor.getName()) {
                    throw new Exception("Instructor with this name has already been added : " + instructor.getName());
                }
            }
            database.addInstructor(instructor);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
