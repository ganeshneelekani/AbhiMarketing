package org.marketing.service.serviceImpl;

import org.marketing.dao.LoginCustomerDao;
import org.marketing.model.bean.Customer;
import org.marketing.service.LoginCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gn033604 on 1/3/18.
 */
@Service
public class LoginCustomerServiceImpl implements LoginCustomerService {

    @Autowired
    LoginCustomerDao loginDao;

    @Override
    public void saveLoginUser(Customer customer) throws Exception {

        loginDao.saveLoginUser(customer);
    }

    @Override
    public boolean validateUser(Customer customer) {
        Boolean status = loginDao.validateCustomer(customer);
        return  status;
    }
}
