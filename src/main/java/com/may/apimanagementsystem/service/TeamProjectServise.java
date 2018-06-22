package com.may.apimanagementsystem.service;


import com.may.apimanagementsystem.dao.TeamProjectMapper;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Project;
import com.may.apimanagementsystem.po.TeamProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TeamProjectServise {

    @Autowired
    private TeamProjectMapper teamProjectMapper;


    public void addTeamProject(TeamProject teamProject)
    {
        if (!teamProjectMapper.insertTeamProject( teamProject)) {
            throw new ServerException();
        }
    }

    public void removeTeamProject(int projectId) {
        if (!teamProjectMapper.deleteTeamProject(projectId)) {
            throw new ServerException();
        }
    }

    public List<Project> selectTeamProjectByTeamId(int teamId, int page) {
        int pageSize = 3;
        page = (page - 1) * pageSize;
        return teamProjectMapper.selectTeamProject(teamId, page, pageSize);
    }
}
