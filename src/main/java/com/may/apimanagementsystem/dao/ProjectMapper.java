package com.may.apimanagementsystem.dao;

<<<<<<< HEAD
=======
import com.github.pagehelper.Page;
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
import com.may.apimanagementsystem.po.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {

<<<<<<< HEAD
    List<Project> getProjectList(int userId);
=======
    List<Project> getUserProject(int userId);
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390

    boolean deleteProject(int projectId);

    boolean insertProject(Project project);

    boolean updateProject(Project project);

    Project findProjectByProjectId(int projectId);

<<<<<<< HEAD
=======
    Page<Project> findByPage();
>>>>>>> 196c8350b129ecc154857ba2953b0c2d54a32390
}
