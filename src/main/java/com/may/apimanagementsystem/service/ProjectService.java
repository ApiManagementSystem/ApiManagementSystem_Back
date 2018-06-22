package com.may.apimanagementsystem.service;

import com.github.pagehelper.PageHelper;
import com.may.apimanagementsystem.dao.ProjectMapper;
import com.may.apimanagementsystem.dao.UserProjectMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ResourceNotFoundException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Project;
import com.may.apimanagementsystem.po.ProjectUserRef;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.HttpURLConnection;
import java.util.List;

import static com.may.apimanagementsystem.constant.ExceptionMessage.*;

@Service
public class ProjectService  {

    @Resource
    private ProjectMapper projectMapper;

    public List<Project> getList(int pageNum, int pageSize,int userId) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Project> projectList = projectMapper.getProjectList(userId);
        return projectList;
    }

    public void addteamproject(Project project) {
        if (!projectMapper.insertProject(project)) {
            throw new ServerException();
        }
    }

    public boolean addProject(Project project){
        boolean flag;
        checkAddProjectParameter(project);
        Project t = projectMapper.findProjectByProjectName(project.getProjectName());
        if(t!=null){
            throw new ParameterException(PROJECT_EXIST);
        }
        boolean result = projectMapper.insertProject(project);
        if(!result) {
            throw new ServerException();
        }
        flag = true;
        return flag;
    }

    public boolean updateProject(Project project){
        boolean flag;
        checkUpdateProjectParameter(project);
        boolean result = projectMapper.updateProject(project);
        if(!result) {
            throw new ServerException();
        }
        flag = true;
        return flag;
    }

    public boolean removeProject(int projectId){
        boolean flag;
        boolean result = projectMapper.deleteProject(projectId);
        if(!result) {
            throw new ServerException();
        }
        flag = true;
        return flag;
    }

    public Project getProjectByProjectId(int projectId){
        Project project = projectMapper.findProjectByProjectId(projectId);
//        Objects.requireNonNull(project);
        if(project == null)
            throw new ResourceNotFoundException(NOT_FIND_OBJECT);
        return project;
    }

    public Project getProjectByProjectName(String projectName){
        Project project = projectMapper.findProjectByProjectName(projectName);
//        Objects.requireNonNull(project);
        if(project == null)
            throw new ResourceNotFoundException(NOT_FIND_OBJECT);
        return project;
    }

    private void checkAddProjectParameter(Project project){
        if(project.getProjectName() == null )
            throw new ParameterException(PARAMETER_CANNOT_NULL);
        checkProjectName(project.getProjectName());
        checkProjectDescription(project.getDescription());
    }

    private void checkAddUserProjectParameter(Project project) {
        if (project.getProjectName() == null )
            throw new ParameterException(PARAMETER_CANNOT_NULL);
        checkProjectName(project.getProjectName());
        checkProjectDescription(project.getDescription());
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
        if(project.getProjectName() != null ){
            checkProjectName(project.getProjectName());
            checkProjectDescription(project.getDescription());
        }else{
            throw new ParameterException(PARAMETER_CANNOT_NULL);
        }
    }


}
