package com.ifp.db.dao;

import com.ifp.db.entity.ProjectEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
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

    public List<ProjectEntity> findAllProjects(Integer limit, Integer offset) {
        ensureSession();
        return session.createQuery("from ProjectEntity")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list();
    }

    public BigInteger countAllProjects() {
        ensureSession();
        return (BigInteger) session.createSQLQuery("SELECT count(projectId) from project").uniqueResult();
    }
}
