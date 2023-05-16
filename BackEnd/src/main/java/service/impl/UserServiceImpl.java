package service.impl;

import model.request.user.VerifyUserLoginRequest;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    /**
     *验证用户输入的用户名和密码，并生成token
     * @param verifyUserLoginRequest
     * @return
     */
    @Override
    public String authenticateUser(VerifyUserLoginRequest verifyUserLoginRequest) {
        return null;
    }
}
