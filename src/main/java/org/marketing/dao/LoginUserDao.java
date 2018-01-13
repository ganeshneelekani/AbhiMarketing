package org.marketing.dao;

import java.util.List;

import org.marketing.model.LoginUser;
import org.marketing.model.bean.Product;

/**
 * Created by gn033604 on 9/23/17.
 */
public interface LoginUserDao {

    public void saveLoginUser(LoginUser loginUser) throws Exception;

    public boolean validateUser(LoginUser loginUser);
}
