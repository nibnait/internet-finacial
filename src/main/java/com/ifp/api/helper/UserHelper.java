package com.ifp.api.helper;

import com.ifp.api.resultModel.user.AddressResultModel;
import com.ifp.api.resultModel.user.UserInfo;
import com.ifp.common.utils.TimeUtils;
import com.ifp.db.entity.UserEntity;
import com.ifp.db.entity.locationDic.CityEntity;
import com.ifp.db.entity.locationDic.ProvinceEntity;
import com.ifp.db.entity.locationDic.TownEntity;

import javax.annotation.Resource;

@Resource
public class UserHelper {
    public static UserInfo convert2UserInfo(UserEntity user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setAddress(user.getAddr()==null?"":user.getAddr());
        userInfo.setBirthday(user.getBirthday()==null?"":TimeUtils.getDate(user.getBirthday()));
        userInfo.setEmail(user.getEmail()==null?"":user.getEmail());
        userInfo.setIdnum(user.getIdnum()==null?"":user.getIdnum());
        userInfo.setImage(user.getImage()==null?"":user.getImage());
        userInfo.setNickname(user.getNickname()==null?"":user.getNickname());
        userInfo.setPhone(user.getPhone()==null?"":user.getPhone());
        userInfo.setRegistertime(TimeUtils.getDetailTime(user.getRegistertime()));
        userInfo.setRole(user.getRole());
        userInfo.setRealname(user.getRealname()==null?"":user.getRealname());
        userInfo.setProvince(user.getProvince()==null?"":user.getProvince());
        userInfo.setCity(user.getCity()==null?"":user.getCity());
        userInfo.setTown(user.getTown()==null?"":user.getTown());
        userInfo.setJob(user.getJob()==null?"":user.getJob());
        userInfo.setSex(user.getSex()==null?"":user.getSex());
        userInfo.setBalance(user.getBalance());
        return userInfo;
    }


    public static AddressResultModel convert2ProvinceResultModel(ProvinceEntity provinceEntity) {
        AddressResultModel addressResultModel = new AddressResultModel();
        addressResultModel.setCode(provinceEntity.getCode());
        addressResultModel.setName(provinceEntity.getName());
        return addressResultModel;
    }

    public static AddressResultModel convert2CityResultModel(CityEntity cityEntity) {
        AddressResultModel addressResultModel = new AddressResultModel();
        addressResultModel.setCode(cityEntity.getCode());
        addressResultModel.setName(cityEntity.getName());
        return addressResultModel;
    }

    public static AddressResultModel convert2TownResultModel(TownEntity townEntity) {
        AddressResultModel addressResultModel = new AddressResultModel();
        addressResultModel.setCode(townEntity.getCode());
        addressResultModel.setName(townEntity.getName());
        return addressResultModel;
    }
}
