package com.ifp.api.controller.project;

import com.ifp.api.resultModel.project.TagListResultModel;
import com.ifp.common.ResultBuilder;
import com.ifp.common.models.ApiResultModel;
import com.ifp.db.dao.DataDicDao;
import com.ifp.service.project.DataDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class GetTagsController {

    @Autowired
    private DataDicService dataDicService;

    @RequestMapping("/tags")
    public ApiResultModel getAllTags(){
        List<String> tags = dataDicService.getAllTags();
        return ResultBuilder.getSuccess(new TagListResultModel(tags));
    }


}
