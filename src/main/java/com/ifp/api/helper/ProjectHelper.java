package com.ifp.api.helper;

import com.ifp.api.resultModel.project.ProjectResultModel;
import com.ifp.common.utils.TimeUtils;
import com.ifp.db.entity.ProjectEntity;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Resource
public class ProjectHelper {

    public static ProjectResultModel convert2ProjectResultModel(ProjectEntity projectEntity) {
        ProjectResultModel resultModel = new ProjectResultModel();
        resultModel.setProjectId(projectEntity.getProjectId());
        resultModel.setTitle(projectEntity.getTitle());
        resultModel.setDescription(projectEntity.getDescription());
        resultModel.setApplyAmount(projectEntity.getApplyAmount());
        resultModel.setBought(projectEntity.getBought());
        resultModel.setTags(convert2List(projectEntity.getTags()));
        resultModel.setBeginDate(TimeUtils.getDetailTime(projectEntity.getBeginDate()));
        resultModel.setEndDate(TimeUtils.getDetailTime(projectEntity.getEndDate()));
        resultModel.setInterest(projectEntity.getInterest());
        resultModel.setMinBought(projectEntity.getMinBought());
        resultModel.setUserId(projectEntity.getUserId());
        resultModel.setDays((int)((projectEntity.getEndDate().getTime()-projectEntity.getBeginDate().getTime())/(1000*60*60*24)));
        return resultModel;
    }

    private static List<String> convert2List(String tags) {
        String[] tagArray = tags.split(",");
        List<String> tagList = new ArrayList<>();
        for (int i = 0; i < tagArray.length; i++) {
            tagList.add(tagArray[i]);
        }
        return tagList;
    }

}
