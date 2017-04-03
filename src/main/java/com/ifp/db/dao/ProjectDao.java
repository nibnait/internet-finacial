package com.ifp.db.dao;

import com.ifp.db.entity.ProjectEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDao extends HibernateBaseDao<ProjectEntity> {
    public ProjectDao() {
        super(ProjectEntity.class, "projectId");
    }


    public List<ProjectEntity> getProjectsByUserId(String userId) {
        ensureSession();
        return session.createQuery("from ProjectEntity where userId = :userId")
                .setString("userId", userId)
                .list();
    }
}
