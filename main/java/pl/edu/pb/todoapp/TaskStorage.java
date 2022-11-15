package pl.edu.pb.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {

    private static TaskStorage instance = null;
    private final List<Task> tasks;

    public List<Task> getTasks(){
        return tasks;
    }

    public static TaskStorage getInstance(){
        if(instance == null){
            instance = new TaskStorage();
        }
        return instance;
    }

    private TaskStorage() {
        tasks = new ArrayList<>();
        for(int i=1; i<=10; i++){
            Task task = new Task();
            task.setName("Ultra ważne zadanie numer " + i);
            if(i % 3 == 0){
                task.setCategory(Category.STUDIES);
            }else{
                task.setCategory(Category.HOME);
            }
            tasks.add(task);

        }
    }

    public Task getTask(UUID index) {
        for(Task t: tasks) {
            if(t.getId().equals(index)) {
                return t;
            }
        }
        return null;
    }

    public void addTask(Task task){
        tasks.add(task);
    }
}