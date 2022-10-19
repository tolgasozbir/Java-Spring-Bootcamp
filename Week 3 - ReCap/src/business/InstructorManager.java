package business;

import core.logging.ILogger;
import dataAccess.IDatabase;
import dummyData.DummyData;
import entities.Instructor;

public class InstructorManager {
    private IDatabase database;
    private ILogger[] loggers;

    public InstructorManager(IDatabase database, ILogger[] loggers){
        this.database = database;
        this.loggers = loggers;
    }

    public void add(Instructor instructor){
        try {
            addProccess(instructor);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void addProccess(Instructor instructor) throws Exception{
        for (Instructor i : DummyData.dummyInstructors) {
            if (i.getName() == instructor.getName()) {
                throw new Exception("Instructor with this name has already been added : " + instructor.getName());
            }
        }
        database.addInstructor(instructor);

        for (ILogger logger : loggers) {
            logger.log(instructor.getName());
        }
    }
}
