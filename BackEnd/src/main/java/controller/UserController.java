package controller;

import jakarta.servlet.http.HttpServletRequest;
import model.RestBean;
import model.entity.UserDetail;
import model.request.user.VerifyUserLoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/api/login")
    public RestBean<UserDetail> verifyUserLogin(@RequestBody VerifyUserLoginRequest verifyUserLoginRequest, HttpServletRequest request){
        UserDetail userDetail = new UserDetail();
        return RestBean.generate(userDetail);
    }
}
