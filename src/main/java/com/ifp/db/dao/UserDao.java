package com.ifp.db.dao;

import com.ifp.db.entity.UserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao extends HibernateBaseDao<UserEntity> {
    public UserDao(){
        super(UserEntity.class, "userId");
    }

    public boolean userExisted(UserEntity user) {
        ensureSession();
        Query query = session.createQuery("from UserEntity u where u.nickname=?");
        List result = findAllWithQuery(null,query,user.getNickname());
        return !result.isEmpty();
    }

    public UserEntity findByUserName(UserEntity user) {
        if (user.getNickname()!=null){
            return findBy("nickname", user.getNickname());
        } else {
            return null;
        }
    }
}
