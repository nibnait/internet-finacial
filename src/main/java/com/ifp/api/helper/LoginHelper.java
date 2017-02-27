package com.ifp.api.helper;

import com.ifp.api.struct.login.UserModel;
import com.ifp.common.ErrorsResult;
import com.ifp.common.models.ApiResultModel;
import com.ifp.common.utils.AccountUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Resource
public class LoginHelper {
    public static boolean checkUserName(String nickname) {
        if (StringUtils.isNotBlank(nickname) && AccountUtils.isNickName(nickname)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkCaptcha(String code, HttpSession session) {
        String sessionCaptcha;
        try {
            sessionCaptcha = (String) session.getAttribute("captcha");
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        if (sessionCaptcha !=null && sessionCaptcha.toUpperCase().equals(code.toUpperCase())){
            return true;
        }
        return false;
    }
}
