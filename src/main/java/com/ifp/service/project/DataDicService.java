package com.ifp.service.project;

import com.ifp.api.helper.ProjectHelper;
import com.ifp.db.dao.DataDicDao;
import com.ifp.db.entity.DataDicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataDicService {

    @Autowired
    private DataDicDao datadicDao;

    public List<String> getAllTags() {
        List<DataDicEntity> allTags = datadicDao.getAllTags();
        List<String> tagList = new ArrayList<>();
        for (DataDicEntity dataDicEntity : allTags){
            tagList.add(dataDicEntity.getDdName());
        }
        return tagList;
    }
}
