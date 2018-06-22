package com.may.apimanagementsystem.service;

import com.may.apimanagementsystem.constant.ExceptionMessage;
import com.may.apimanagementsystem.dao.TeamMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Team;
import com.may.apimanagementsystem.po.TeamProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;


@Service
public class TeamService {

    @Autowired
    private TeamMapper teamMapper;

    public void addTeam(Team team) {
        checkAddTeamParameter(team);
        if (!teamMapper.insertTeam(team)) {
            throw new ServerException();
        }
    }

    private void checkAddTeamParameter(Team team) {
        if (team.getTeamName() == null||team.getCreateuserId() == 0) {
            throw new ParameterException(ExceptionMessage.PARAMETER_CANNOT_NULL);
        }
        Team t=teamMapper.findTeamByTeamName(team.getTeamName());
        if(t!=null)
        {
            throw new ParameterException(ExceptionMessage.DOUBLE_TEAM_NAME);
        }
    }

    public void removeTeam(int teamId) {
        if (!teamMapper.deleteTeam(teamId)) {
            throw new ServerException();
        }
    }

    public void updateTeam(Team team) {
        checkUpdateTeam(team);
        if (!teamMapper.updateTeam(team)) {
            throw new ServerException();
        }

    }

    public void checkUpdateTeam(Team team) {
        if (team.getTeamName() == null) {
            throw new ParameterException(ExceptionMessage.TEAM_NAME_IS_EMPTY);
        }
        Team t=teamMapper.findTeamByTeamName(team.getTeamName());
        if(t!=null)
        {
            throw new ParameterException(ExceptionMessage.DOUBLE_TEAM_NAME);
        }
    }

    public Team getTeamByTeamId(int teamId) {
        Team team = teamMapper.findTeamByTeamId(teamId);
        Objects.requireNonNull(team);
        return team;
    }

    public Team getTeamByTeamName(String teamName) {
        Team team = teamMapper.findTeamByTeamName(teamName);
        Objects.requireNonNull(team);
        return team;
    }

    public List<Team> searchMyTeamByuserId(int userId, int page) {
        int pageSize = 5;
        page = (page - 1) * pageSize;
        return teamMapper.searchMyTeamsByuserId(userId, page, pageSize);
    }



}
