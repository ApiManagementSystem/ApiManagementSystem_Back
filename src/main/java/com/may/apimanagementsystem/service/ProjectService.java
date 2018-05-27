package com.may.apimanagementsystem.service;

import com.github.pagehelper.PageHelper;
import com.may.apimanagementsystem.dao.ProjectMapper;
import com.may.apimanagementsystem.dao.UserProjectMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

import static com.may.apimanagementsystem.constant.ExceptionMessage.*;

@Service
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

//    public boolean addProjectByUser(ProjectUserRef projectUserRef){
//        boolean flag = false;
//        if(!userProjectMapper.insertUserProjectByUser(projectUserRef)){
//            throw new ServerException();
//        }else {
//            flag = true;
//        }
//        return flag;
//    }

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
        Project project = projectMapper.findProjectByProjectId(projectId);
        Objects.requireNonNull(project);
        return project;
    }

    private void checkAddProjectParameter(Project project){
        if(project.getProjectName()== null )
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
