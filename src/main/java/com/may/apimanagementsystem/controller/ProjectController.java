package com.may.apimanagementsystem.controller;

import com.may.apimanagementsystem.dto.ResponseEntity;
import com.may.apimanagementsystem.po.Project;
<<<<<<< HEAD
import com.may.apimanagementsystem.po.ProjectUserRef;
import com.may.apimanagementsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

=======
import com.may.apimanagementsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.may.apimanagementsystem.constant.ExceptionMessage.SUCCESS;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> addProject(Project project){
        projectService.addProject(project);
        return new ResponseEntity<>(200,SUCCESS,null);
    }

<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<Project> addProjectByUser(ProjectUserRef projectUserRef){
        projectService.addProjectByUser(projectUserRef);
        return new ResponseEntity<>(200,SUCCESS,null);
    }

    @GetMapping("userProject")
    public ResponseEntity<List<Project>> showProject(int pageNum, int pageSize,int userId){
=======
    @GetMapping("userProject")
    public ResponseEntity<List<Project>> showProject(int pageNum, int pageSize, int userId){
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
        List<Project> projects = null;
        try {
            projects = projectService.getList(pageNum,pageSize,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(200,SUCCESS,projects);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Project> deleteProject(@PathVariable int projectId){
        projectService.removeProject(projectId);
        return new ResponseEntity<>(200,SUCCESS,null);
    }

    @PutMapping("{projectId}")
<<<<<<< HEAD
    public ResponseEntity<Project> updateProject(@PathVariable int projectId,Project project){
=======
    public ResponseEntity<Project> updateProject(@PathVariable int projectId, Project project){
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
        projectService.updateProject(project);
        return new ResponseEntity<>(200,SUCCESS,null);
    }

    @GetMapping("{projectId}")
<<<<<<< HEAD
    public ResponseEntity<Project> findProjectByProjectId(@PathVariable int projectId,Project project){
=======
    public ResponseEntity<Project> findProjectByProjectId(@PathVariable int projectId, Project project){
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
        projectService.getProjectByProjectId(projectId);
        return new ResponseEntity<>(200,SUCCESS,project);
    }

}
