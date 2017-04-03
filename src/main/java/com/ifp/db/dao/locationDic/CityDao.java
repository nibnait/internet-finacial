package com.ifp.db.dao.locationDic;

import com.ifp.db.dao.HibernateBaseDao;
import com.ifp.db.entity.locationDic.CityEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityDao extends HibernateBaseDao<CityEntity> {
    public CityDao(){
        super(CityEntity.class, "id");
    }

}
