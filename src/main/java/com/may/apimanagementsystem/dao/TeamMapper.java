package com.may.apimanagementsystem.dao;

import com.may.apimanagementsystem.po.Team;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMapper {


    boolean insertTeam(Team team);

    boolean deleteTeam(int teamId);

    boolean updateTeam(Team team);

    Team findTeamByTeamId(int teamId);

    Team findTeamByTeamName(String teamName);

    List<Team> searchMyTeamsByuserId(@Param("userId") int userId, @Param("page") int page, @Param("pageSize") int pageSize);

}
