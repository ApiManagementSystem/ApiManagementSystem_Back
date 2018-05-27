package com.may.apimanagementsystem.dao;


import com.may.apimanagementsystem.po.Project;
import com.may.apimanagementsystem.po.TeamProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamProjectMapper {

    boolean deleteTeamProject(int projectId);

    List<Project> selectTeamProject(@Param("teamId") int teamId, @Param("page") int page, @Param("pageSize") int pageSize);
}
