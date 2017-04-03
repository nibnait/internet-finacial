package com.ifp.api.controller.user;

import com.ifp.api.helper.UserHelper;
import com.ifp.api.resultModel.user.AddressResultModel;
import com.ifp.common.ResultBuilder;
import com.ifp.common.models.ApiResultModel;
import com.ifp.db.dao.locationDic.CityDao;
import com.ifp.db.dao.locationDic.ProvinceDao;
import com.ifp.db.dao.locationDic.TownDao;
import com.ifp.db.entity.locationDic.CityEntity;
import com.ifp.db.entity.locationDic.ProvinceEntity;
import com.ifp.db.entity.locationDic.TownEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class AddressController {

    @Autowired
    private ProvinceDao provinceDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private TownDao townDao;

    /**
     * 获取所有省份信息
     */
    @RequestMapping("/province")
    public ApiResultModel getAllProvince(){
        List<ProvinceEntity> provinceEntityList = provinceDao.findAll();
        List<AddressResultModel> resultList = new ArrayList<>();
        for (ProvinceEntity provinceEntity : provinceEntityList){
            AddressResultModel addressResultModel = UserHelper.convert2ProvinceResultModel(provinceEntity);
            resultList.add(addressResultModel);
        }
        return ResultBuilder.getSuccess(resultList);
    }

    /**
     * 根据provinceCode 获取此省份下的所有城市列表
     */
    @RequestMapping("/city")
    public ApiResultModel getCity(String code){
        List<CityEntity> cityEntityList = cityDao.findAllBy("province", code);
        List<AddressResultModel> resultList = new ArrayList<>();
        for (CityEntity cityEntity : cityEntityList) {
            AddressResultModel addressResultModel = UserHelper.convert2CityResultModel(cityEntity);
            resultList.add(addressResultModel);
        }
        return ResultBuilder.getSuccess(resultList);
    }

    /**
     * 根据cityCode 获取此城市下的所有区县列表
     */
    @RequestMapping("/town")
    public ApiResultModel getTown(String code){
        List<TownEntity> townEntityList = townDao.findAllBy("city", code);
        List<AddressResultModel> resultList = new ArrayList<>();
        for (TownEntity townEntity : townEntityList) {
            AddressResultModel addressResultModel = UserHelper.convert2TownResultModel(townEntity);
            resultList.add(addressResultModel);
        }
        return ResultBuilder.getSuccess(resultList);
    }


}
