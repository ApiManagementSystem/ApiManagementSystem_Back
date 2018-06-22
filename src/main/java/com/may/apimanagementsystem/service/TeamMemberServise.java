package com.may.apimanagementsystem.service;


import com.may.apimanagementsystem.constant.ExceptionMessage;
import com.may.apimanagementsystem.dao.TeamMapper;
import com.may.apimanagementsystem.dao.TeamMemberMapper;
import com.may.apimanagementsystem.exception.ParameterException;
import com.may.apimanagementsystem.exception.ServerException;
import com.may.apimanagementsystem.po.TeamMember;
import com.may.apimanagementsystem.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TeamMemberServise {

    @Autowired
    private TeamMemberMapper teamMemberMapper;
    @Autowired
    private TeamMapper teamMapper;

    public void addTeamMerber(TeamMember teamMember) {
        checkAddTeanMember(teamMember);
        if (!teamMemberMapper.insertTeamMember(teamMember)) {
            throw new ServerException();
        }
    }


    private void checkAddTeanMember(TeamMember teamMember) {
        if (teamMember.getUserId() == 0|| teamMember.getTeamId()== 0) {
            throw new ParameterException(ExceptionMessage.PARAMETER_CANNOT_NULL);
        }
        if (teamMapper.findTeamByTeamId(teamMember.getTeamId()) == null) {
            throw new ParameterException(ExceptionMessage.TEAM_NOT_EXIST);
        }
    }

    public void deleteTeamMember(TeamMember teamMember) {
        if (!teamMemberMapper.deleteTeamMember(teamMember)) {
            throw new ServerException();
        }
    }

    public List<User> selectTeamMembers(int teamId) {
        return teamMemberMapper.selectTeamMember(teamId);
    }


}
