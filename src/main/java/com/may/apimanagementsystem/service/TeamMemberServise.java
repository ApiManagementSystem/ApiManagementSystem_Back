package com.may.apimanagementsystem.service;


import com.may.apimanagementsystem.dao.TeamMemberMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.TeamMember;
import com.may.apimanagementsystem.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.may.apimanagementsystem.constant.ExceptionMessage.PARAMETER_CANNOT_NULL;

@Service
public class TeamMemberServise {

    @Resource
    private TeamMemberMapper teamMemberMapper;

    public void addTeamMerber(TeamMember teamMember)
    {
       checkAddTeanMember(teamMember);
       if (!teamMemberMapper.insertTeamMember(teamMember))
       {
           throw new ServerException();
       }
    }

    private void checkAddTeanMember(TeamMember teamMember)
    {
        if(String.valueOf(teamMember.getUserId())==null||String.valueOf(teamMember.getTeamId())==null||teamMember.getJoinTime()==null)
        {
            throw new ParameterException(PARAMETER_CANNOT_NULL);
        }
    }

    public void deleteTeamMember(TeamMember teamMember)
    {
        if (!teamMemberMapper.deleteTeamMember(teamMember))
        {
            throw new ServerException();
        }
    }

    public List<User> selectTeamMembers(int teamId)
    {
        return  teamMemberMapper.selectTeamMember(teamId);
    }


}
