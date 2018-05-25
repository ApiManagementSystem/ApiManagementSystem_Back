package com.may.apimanagementsystem.service;

import com.may.apimanagementsystem.dao.TeamMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.Team;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Objects;

import static com.may.apimanagementsystem.constant.ExceptionMessage.PARAMETER_CANNOT_NULL;
import static com.may.apimanagementsystem.constant.ExceptionMessage.TEAM_NAME_IS_EMPTY;


@Service
public class TeamService {

    @Resource
    private TeamMapper teamMapper;

    public void addTeam(Team team)
    {
       checkAddTeamParameter(team);
       if(!teamMapper.insertTeam(team))
           throw new ServerException();
    }

   private void checkAddTeamParameter(Team team)
   {
       if(team.getTeamName()==null)
       {
           throw new ParameterException(PARAMETER_CANNOT_NULL);
       }
   }

   public void removeTeam(int teamId)
   {
       if (!teamMapper.deleteTeam(teamId))
           throw new ServerException();
   }

    public void updateTeam( Team team){
        checkUpdateTeam(team);
        if(!teamMapper.updateTeam(team))
            throw new ServerException();
    }

    public void checkUpdateTeam(Team team)
    {
        if(team.getTeamName()==null)
            throw new ParameterException(TEAM_NAME_IS_EMPTY);
    }

    public Team getTeamByTeamId(int teamId){
        Team team = teamMapper.findTeamByTeamId(teamId);
        Objects.requireNonNull(team);
        return team;
    }

    public Team getTeamByTeamName(String teamName){
        Team team = teamMapper.findTeamByTeamName(teamName);
        Objects.requireNonNull(team);
        return team;
    }

    public List<Team> searchMyTeamByuserId(int userId)
    {

        return teamMapper.searchMyTeamsByuserId(userId);
    }





}
