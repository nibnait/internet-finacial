package com.ifp.db.dao;

import com.ifp.db.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao extends HibernateBaseDao<UserEntity> {
    public UserDao(){
        super(UserEntity.class, "userId");
    }

    public boolean userExisted(UserEntity user) {
        ensureSession();
        Query query = session.createQuery("from UserEntity u where u.phone=?");
        List result = findAllWithQuery(null,query,user.getPhone());
        return !result.isEmpty();
    }

    public String getUserIdByUserPhone(String userPhone) {
        ensureSession();
        SQLQuery sqlQuery = session.createSQLQuery("select userId from user where phone = :userPhone");
        sqlQuery.setString("userPhone", userPhone);
        String userId = (String) sqlQuery.uniqueResult();
        return userId;
    }

    public UserEntity findByUserName(UserEntity user) {
        if (user.getPhone()!=null){
            return findBy("phone", user.getPhone());
        } else {
            return null;
        }
    }

    public Integer getUserRoleById(String userId) {
        ensureSession();
        return (Integer) session.createSQLQuery("select role from user where userId = :userId")
                .setString("userId", userId)
                .uniqueResult();
    }
}
