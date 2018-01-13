package org.marketing.service.serviceImpl;

import org.marketing.dao.LoginUserDao;
import org.marketing.model.LoginUser;
import org.marketing.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gn033604 on 1/3/18.
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    LoginUserDao loginDao;

    @Override
    public void saveLoginUser(LoginUser loginUser) throws Exception {

        loginDao.saveLoginUser(loginUser);
    }

    @Override
    public boolean validateUser(LoginUser loginUser) {
        Boolean status = loginDao.validateUser(loginUser);
        return  status;
    }
}
