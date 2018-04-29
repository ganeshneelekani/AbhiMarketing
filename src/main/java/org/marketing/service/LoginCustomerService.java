package org.marketing.service;

import org.marketing.model.LoginUser;
import org.marketing.model.bean.Customer;

/**
 * Created by gn033604 on 1/3/18.
 */
public interface LoginCustomerService {

    public void saveLoginUser(Customer loginUser) throws Exception;

    public boolean validateUser(Customer loginUser);

}
