package com.ifp.service;

import com.ifp.api.struct.login.UserModel;
import com.ifp.common.Constants;
import com.ifp.db.dao.UserDao;
import com.ifp.db.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Integer doLogin(UserModel userModel) {
        UserEntity user = new UserEntity();
        user.setPhone(userModel.getPhone());
        user.setLoginpwd(userModel.getLoginpwd());
        user.setRole(userModel.getRole());
        user.setUserid(UUID.randomUUID().toString());
        user.setRegistertime(new Date());
        UserEntity userInfo;
        try {
            userInfo = userDao.findByUserName(user);
        } catch (Exception e) {
            return Constants.DB_ERROR;
        }
        if (userInfo == null) {
            return Constants.USER_NOT_EXISTED;
        }
        if (!userInfo.getLoginpwd().equals(user.getLoginpwd())) {
            return Constants.PASSWORD_ERROR;
        }
        return Constants.SUCCESS;
    }

    public Integer doRegister(UserModel userModel){
        int result;
        UserEntity user = new UserEntity();
        user.setPhone(userModel.getPhone());
        user.setLoginpwd(userModel.getLoginpwd());
        user.setRole(userModel.getRole());
        user.setUserid(UUID.randomUUID().toString().replace("-", ""));
        user.setRegistertime(new Date());
        if (userDao.userExisted(user)){
            result = Constants.USER_EXISTED;
        } else {
            result = userDao.insert(user) ? Constants.SUCCESS : Constants.DB_ERROR;
        }
        return result;
    }
}
