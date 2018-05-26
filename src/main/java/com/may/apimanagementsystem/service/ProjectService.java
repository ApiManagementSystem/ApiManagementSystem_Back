package com.may.apimanagementsystem.service;

<<<<<<< HEAD
import com.github.pagehelper.PageHelper;
import com.may.apimanagementsystem.dao.ProjectMapper;
import com.may.apimanagementsystem.dao.UserProjectMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Project;
import com.may.apimanagementsystem.po.ProjectUserRef;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
=======
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.may.apimanagementsystem.dao.ProjectMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
import java.util.List;
import java.util.Objects;

import static com.may.apimanagementsystem.constant.ExceptionMessage.*;

@Service
<<<<<<< HEAD
public class ProjectService  {

    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private UserProjectMapper userProjectMapper;

    public List<Project> getList(int pageNum, int pageSize,int userId) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Project> projectList = projectMapper.getProjectList(userId);
        return projectList;
    }

    public boolean addProject(Project project){
        boolean flag = false;
        checkAddProjectParameter(project);
        if(!projectMapper.insertProject(project)){
            throw new ServerException();
        }else {
            flag = true;
        }
        return flag;
    }

    public boolean addProjectByUser(ProjectUserRef projectUserRef){
        boolean flag = false;
        if(!userProjectMapper.insertUserProjectByUser(projectUserRef)){
            throw new ServerException();
        }else {
            flag = true;
        }
        return flag;
    }

    public boolean updateProject(Project project){
        boolean flag = false;
        checkUpdateProjectParameter(project);
        if(!projectMapper.updateProject(project)){
            throw new ServerException();
        }else {
            flag = true;
        }
        return flag;
    }

    public boolean removeProject(int projectId){
        boolean flag = false;
        if(!projectMapper.deleteProject(projectId)||!userProjectMapper.deleteUserProject(projectId)){
            throw new ServerException();
        }else {
            flag = true;
        }
        return flag;
    }

    public Project getProjectByProjectId(int projectId){
=======
public class ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    public List<Project> getList(int pageNum, int pageSize, int userId) throws Exception {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        // 获取
        List<Project> projectList = projectMapper.getUserProject(userId);
        return projectList;
    }

    public void addProject(Project project) {
        checkAddProjectParameter(project);
        if (!projectMapper.insertProject(project)) {
            throw new ServerException();
        }
    }

    public void updateProject(Project project) {
        checkUpdateProjectParameter(project);
        if (!projectMapper.updateProject(project)) {
            throw new ServerException();
        }
    }

    public void removeProject(int projectId) {
        if (!projectMapper.deleteProject(projectId)) {
            throw new ServerException();
        }
    }

    public Project getProjectByProjectId(int projectId) {
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
        Project project = projectMapper.findProjectByProjectId(projectId);
        Objects.requireNonNull(project);
        return project;
    }

<<<<<<< HEAD
    private void checkAddProjectParameter(Project project){
        if(project.getProjectName()== null || project.getDescription()==null)
            throw new ParameterException(PARAMETER_CANNOT_NULL);
        checkProjectName(project.getProjectName());
        checkProjectDescription(project.getDescription());
    }

    private void checkAddUserProjectParameter(Project project){
        if(project.getProjectName()== null || project.getDescription()==null)
            throw new ParameterException(PARAMETER_CANNOT_NULL);
        checkProjectName(project.getProjectName());
        checkProjectDescription(project.getDescription());
=======

    public Page<Project> findByPage(int pageNo, int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        return projectMapper.findByPage();
    }

    private void checkAddProjectParameter(Project project){
        if(project.getProjectName() != null && project.getDescription() != null) {
            checkProjectName(project.getProjectName());
            checkProjectDescription(project.getDescription());
        }else{
            throw new ParameterException(PARAMETER_CANNOT_NULL);
        }
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
    }

    private void checkProjectName(String projectName){
        if (projectName.length() > 20)
            throw new ParameterException(PROJECT_NAME_IS_TOO_LONG);
    }

    private void checkProjectDescription(String projectDescription){
        if(projectDescription.length()>255)
            throw new ParameterException(PROJECT_DESCRIPTION_IS_TOO_LONG);
    }

    private void checkUpdateProjectParameter(Project project){
<<<<<<< HEAD
        if(project.getProjectName() != null){
            checkProjectName(project.getProjectName());
        }
        if(project.getDescription() != null){
            checkProjectDescription(project.getDescription());
=======
        if(project.getProjectName() != null && project.getDescription() != null){
            checkProjectName(project.getProjectName());
            checkProjectDescription(project.getDescription());
        }else{
            throw new ParameterException(PARAMETER_CANNOT_NULL);
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
        }
    }


}
