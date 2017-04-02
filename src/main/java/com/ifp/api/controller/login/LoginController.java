package com.ifp.api.controller.login;

import com.ifp.api.helper.LoginHelper;
import com.ifp.api.struct.login.LoginResult;
import com.ifp.api.struct.login.UserModel;
import com.ifp.common.Constants;
import com.ifp.common.ErrorsResult;
import com.ifp.common.ResultBuilder;
import com.ifp.common.models.ApiResultModel;
import com.ifp.db.dao.UserDao;
import com.ifp.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public ApiResultModel doLogin(@RequestParam String userPhone, @RequestParam String password,
                                  @RequestParam String code, @RequestParam Integer role, HttpSession session) {
        if (StringUtils.isEmpty(code)) {
            return ErrorsResult.CAPTCHA_NOT_BLANK;
        }
        if (!LoginHelper.checkCaptcha(code, session)) {
            return ErrorsResult.CAPTCHA_ILLEGAL;
        }
        if (!LoginHelper.checkUserPhone(userPhone)) {
            return ErrorsResult.ACCOUNT_ILLEGAL;
        }
        if (role.intValue() != 1 && role.intValue() != 2) {
            return ErrorsResult.ROLE_ILLEGAL;
        }
        UserModel user = new UserModel();
        user.setPhone(userPhone);
        user.setLoginpwd(password);
        user.setRole(role);
        Integer result = userService.doLogin(user);
        ApiResultModel resultModel = convertReaultModel(result, userPhone);
        return resultModel;
    }

    private ApiResultModel convertReaultModel(Integer result, String phone) {
        ApiResultModel resultModel = new ApiResultModel();
        if (result == Constants.SUCCESS) {
            LoginResult loginResult = new LoginResult();
            loginResult.setUserId(userDao.getUserIdByUserPhone(phone));
            resultModel = ResultBuilder.getSuccess(loginResult);
        } else if (result == Constants.USER_NOT_EXISTED) {
            resultModel = ErrorsResult.USER_NOT_EXISTED;
        } else if (result == Constants.DB_ERROR) {
            resultModel = ErrorsResult.DB_ERROR;
        } else if (result == Constants.PASSWORD_ERROR){
            resultModel = ErrorsResult.PASSWORD_ERROR;
        } else {
            resultModel = ErrorsResult.UNKNOWN_ERROR;
        }
        return resultModel;
    }
}