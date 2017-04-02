package com.ifp.api.controller.user;

import com.ifp.common.models.ApiResultModel;
import com.ifp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/changePassword/{userId}")
    public ApiResultModel doChangePassword(String userId){

        return null;
    }



}
