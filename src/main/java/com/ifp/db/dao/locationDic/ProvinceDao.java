package com.ifp.db.dao.locationDic;

import com.ifp.db.dao.HibernateBaseDao;
import com.ifp.db.entity.locationDic.ProvinceEntity;
import org.springframework.stereotype.Component;

@Component
public class ProvinceDao extends HibernateBaseDao<ProvinceEntity> {
    public ProvinceDao(){
        super(ProvinceEntity.class, "id");
    }

}
