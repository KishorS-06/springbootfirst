package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.models.Task;
import com.example.springbootfirst.models.TaskAssigned;
import com.example.springbootfirst.repository.EmployeeRepository;
import com.example.springbootfirst.repository.TaskRepo;
import com.example.springbootfirst.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TaskService {

//    @Autowired
//    TaskAssigned taskAssigned;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    TaskRepo taskRepo;

    public Map<Integer, String> taskAssignedList(){
        Map<Integer, String> taskMap = new HashMap<>();
        for(TaskAssigned t : taskRepository.findAll()){
            String taskName = getTaskNameByTaskId(t.getTaskId());
            taskMap.put(t.getEmpId(), taskName);
        }
        return taskMap;
    }

    public String getTaskNameByTaskId(int taskId){
        String taskName = "";
        boolean taskFound = false;
        for(Task t : taskRepo.findAll()){
            if(t.getTaskId() == taskId){
                taskName = t.getTaskName();
                taskFound = true;
            }
        }

        if(!taskFound) return "";

        return taskName;
    }

    public String assignTask(TaskAssigned t){
        int empId = t.getEmpId();
        int taskId = t.getTaskId();

        boolean employeeFound = false;
        for(Employee e : empRepo.findAll()){
            if(e.getEmpId() == empId){
                employeeFound = true;
                break;
            }
        }

        if(!employeeFound) return "Employee Not Found";

        boolean taskFound = false;
        for(Task task : taskRepo.findAll()){
            if(task.getTaskId() == taskId){
                taskFound = true;
                break;
            }
        }

        if(!taskFound) return "Task Not Found";

        TaskAssigned assignedTask = new TaskAssigned();
        assignedTask.setEmpId(empId);
        assignedTask.setTaskId(taskId);
        taskRepository.save(assignedTask);

        return "Task Assigned!";
    }
}
