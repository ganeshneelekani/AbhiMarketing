package org.marketing.service;

import org.marketing.model.LoginUser;

/**
 * Created by gn033604 on 1/3/18.
 */
public interface LoginUserService {

    public void saveLoginUser(LoginUser loginUser) throws Exception;

    public boolean validateUser(LoginUser loginUser);

}
