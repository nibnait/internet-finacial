package com.ifp.api.controller.project;

import com.ifp.api.helper.ProjectHelper;
import com.ifp.api.resultModel.project.ProjectResultModel;
import com.ifp.common.ErrorsResult;
import com.ifp.common.ResultBuilder;
import com.ifp.common.models.ApiResultModel;
import com.ifp.common.utils.TimeUtils;
import com.ifp.db.dao.ProjectDao;
import com.ifp.db.entity.ProjectEntity;
import com.ifp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private UserService userService;

    /**
     * 列出所有项目
     */
    @RequestMapping("/list")
    public ApiResultModel list(){
        List<ProjectEntity> projectEntityList = projectDao.findAll();
        List<ProjectResultModel> resultList = new ArrayList<ProjectResultModel>();
        if (projectEntityList != null){
            for (ProjectEntity projectEntity : projectEntityList) {
                ProjectResultModel resultModel = ProjectHelper.convert2ProjectResultModel(projectEntity);
                resultList.add(resultModel);
            }
        }
        return ResultBuilder.getSuccess(resultList);
    }


    /**
     * 查询我的项目
     */
    @RequestMapping("/myList")
    public ApiResultModel myList(String userId){
        if (!checkoutUser(userId)){
            return ErrorsResult.NO_PERMISSION;
        }
        List<ProjectEntity> projectEntityList = projectDao.getProjectsByUserId(userId);
        List<ProjectResultModel> resultList = new ArrayList<ProjectResultModel>();
        if (projectEntityList != null){
            for (ProjectEntity projectEntity : projectEntityList) {
                ProjectResultModel resultModel = ProjectHelper.convert2ProjectResultModel(projectEntity);
                resultList.add(resultModel);
            }
        }
        return ResultBuilder.getSuccess(resultList);
    }


    /**
     * 申请项目
     */
    @RequestMapping("/apply")
    public ApiResultModel applyProject(String userId,
                                       String title,
                                       String description,
                                       Integer applyAmount,
                                       String tags,
                                       double interest,
                                       Integer minBought,
                                       String beginDate,
                                       String endDate){
        if (checkoutUser(userId)){
            return ErrorsResult.NO_PERMISSION;
        }

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setUserId(userId);
        projectEntity.setTitle(title);
        projectEntity.setDescription(description);
        projectEntity.setApplyAmount(applyAmount);
        projectEntity.setTags(tags);
        projectEntity.setInterest(interest);
        projectEntity.setMinBought(minBought);
        projectEntity.setBeginDate(TimeUtils.parseDate(beginDate));
        projectEntity.setEndDate(TimeUtils.parseDate(endDate));
        if (projectDao.insert(projectEntity)){
            return ResultBuilder.getNoDataSuccess("申请成功");
        } else {
            return ErrorsResult.DB_ERROR;
        }
    }

    private boolean checkoutUser(String userId) {
        if (userService.getUserRoleById(userId) == 2) {
            return true;
        } else {
            return false;
        }
    }
}
