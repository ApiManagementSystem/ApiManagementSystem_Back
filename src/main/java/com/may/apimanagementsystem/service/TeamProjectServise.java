package com.may.apimanagementsystem.service;


import com.may.apimanagementsystem.dao.TeamProjectMapper;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamProjectServise {

    @Resource
    private TeamProjectMapper teamProjectMapper;

    public void removeTeamProject(int projectId)
    {
        if(!teamProjectMapper.deleteTeamProject(projectId))
        throw new ServerException();
    }

    public List<Project> searchMyTeamByuserId(int teamId)
    {
        return teamProjectMapper.selectTeamProject(teamId);
    }
}
