package com.may.apimanagementsystem.service;

import com.may.apimanagementsystem.dao.UserProjectMapper;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.ProjectUserRef;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserProjectService {
    @Resource
    UserProjectMapper userProjectMapper;

    public boolean addProjectByUser(ProjectUserRef projectUserRef){
        boolean flag = false;
        if(!userProjectMapper.insertUserProjectByUser(projectUserRef)){
            throw new ServerException();
        }else {
            flag = true;
        }
        return flag;
    }

    public boolean removeUserProject(int projectId){
        boolean flag;
        boolean result = userProjectMapper.deleteUserProject(projectId);
        if(!result) {
            throw new ServerException();
        }
        flag = true;
        return flag;
    }

}
