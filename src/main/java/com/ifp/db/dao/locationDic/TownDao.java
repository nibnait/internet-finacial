package com.ifp.db.dao.locationDic;

import com.ifp.db.dao.HibernateBaseDao;
import com.ifp.db.entity.locationDic.TownEntity;
import org.springframework.stereotype.Component;

@Component
public class TownDao extends HibernateBaseDao<TownEntity> {
    public TownDao(){
        super(TownEntity.class, "id");
    }
}
