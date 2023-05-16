package service;

import model.request.user.VerifyUserLoginRequest;

public interface UserService {
    public String authenticateUser(VerifyUserLoginRequest verifyUserLoginRequest);
}
