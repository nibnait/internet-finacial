package com.ifp.api.controller.user;

import com.ifp.api.helper.UserHelper;
import com.ifp.api.resultModel.user.UserInfo;
import com.ifp.common.ErrorsResult;
import com.ifp.common.ResultBuilder;
import com.ifp.common.models.ApiResultModel;
import com.ifp.common.utils.AccountUtils;
import com.ifp.common.utils.TimeUtils;
import com.ifp.db.dao.UserDao;
import com.ifp.db.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 上传头像
     */
    @RequestMapping("/user/uploadHeadImage/{userId}")
    public ApiResultModel uploadHeadImage(String userId) {


        return null;
    }

    /**
     * 获取所有省份
     */

    /**
     * 更新个人信息
     * @param userId
     * @return
     */
    @RequestMapping("/user/updateInfo/{userId}")
    public ApiResultModel updatePersonInfo(@RequestParam String userId,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String birthday,
                                           @RequestParam(required = false) String idnum,
                                           @RequestParam(required = false) String nickname,
                                           @RequestParam(required = false) String realname,
                                           @RequestParam(required = false) String phone,
                                           @RequestParam(required = false) String province,
                                           @RequestParam(required = false) String city,
                                           @RequestParam(required = false) String town,
                                           @RequestParam(required = false) String address,
                                           @RequestParam(required = false) String job,
                                           @RequestParam(required = false) String newLoginPassword,
                                           @RequestParam(required = false) String transpwd,
                                           @RequestParam(required = false) double balance,
                                           @RequestParam(required = false) String sex){
        UserEntity user = userDao.findById(userId);
        if (user != null) {
            user.setAddr(address);
            if(birthday!=null){
                user.setBirthday(TimeUtils.parseDate(birthday));
            }
            if (AccountUtils.isEmail(email)) {
                user.setEmail(email);
            } else {
                return ErrorsResult.EMAIL_ILLEGAL;
            }
            user.setIdnum(idnum);
            user.setNickname(nickname);
            user.setPhone(phone);
            user.setRealname(realname);
            user.setProvince(province);
            user.setCity(city);
            user.setTown(town);
            user.setJob(job);
            user.setLoginpwd(newLoginPassword);
            user.setTranspwd(transpwd);
            user.setSex(sex);
            user.setBalance(balance+user.getBalance());
            userDao.update(user);
            return ResultBuilder.getNoDataSuccess("更新成功");
        } else {
            return ErrorsResult.USER_NOT_EXISTED;
        }
    }

    /**
     * 获取个人信息
     * @param userId
     * @return
     */
    @RequestMapping("/user/{userId}")
    public ApiResultModel getUserInfo(String userId){
        UserEntity user = userDao.findById(userId);
        if (user != null) {
            UserInfo userInfo = UserHelper.convert2UserInfo(user);
            return ResultBuilder.getSuccess(userInfo);
        } else {
            return ErrorsResult.USER_NOT_EXISTED;
        }
    }

}
