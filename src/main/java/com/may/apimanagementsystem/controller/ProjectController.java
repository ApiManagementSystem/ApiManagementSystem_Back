package com.may.apimanagementsystem.controller;

import com.may.apimanagementsystem.constant.ReturnCode;
import com.may.apimanagementsystem.dto.ResponseEntity;
import com.may.apimanagementsystem.po.Project;
import com.may.apimanagementsystem.po.ProjectUserRef;
import com.may.apimanagementsystem.po.UserProject;
import com.may.apimanagementsystem.service.ProjectService;
import com.may.apimanagementsystem.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import com.may.apimanagementsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.may.apimanagementsystem.constant.ExceptionMessage.SUCCESS;

@RestController
@RequestMapping("project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserProjectService userProjectService;

    @PostMapping(consumes = "application/json;charset=utf-8")
    public ResponseEntity<Project> addProject(@RequestBody UserProject userProject){
        Project project = new Project();
        project.setProjectName(userProject.getProjectName());
        project.setDescription(userProject.getDescription());
        project.setAddress(userProject.getAddress());
        projectService.addProject(project);
        ProjectUserRef projectUserRef = new ProjectUserRef();
        projectUserRef.setProjectId(project.getProjectId());
        projectUserRef.setUserId(userProject.getUserId());
        userProjectService.addProjectByUser(projectUserRef);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,null);
    }

    @PostMapping("teamproject")
    public ResponseEntity<Project> createTeam(Project project) {
        projectService.addteamproject(project);
        return new ResponseEntity<>(200, SUCCESS, project);
    }

    @GetMapping("userProject")
    public ResponseEntity<List<Project>> showProject(int pageNum, int pageSize,int userId) throws Exception {
        List<Project> projects = null;
        projects = projectService.getList(pageNum,pageSize,userId);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,projects);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Project> deleteProject(@PathVariable int projectId){
        projectService.removeProject(projectId);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,null);
    }

    @PutMapping("{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable int projectId, Project project){
        projectService.updateProject(project);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,null);
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Project> findProjectByProjectId(@PathVariable int projectId){
        Project project1 = projectService.getProjectByProjectId(projectId);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,project1);
    }

}
