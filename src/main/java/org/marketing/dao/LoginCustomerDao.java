package org.marketing.dao;

import java.util.List;

import org.marketing.model.LoginUser;
import org.marketing.model.bean.Customer;
import org.marketing.model.bean.Product;

/**
 * Created by gn033604 on 9/23/17.
 */
public interface LoginCustomerDao {

    public void saveLoginUser(Customer customer) throws Exception;

    public boolean validateCustomer(Customer customer);

    public Customer getCustomerDetails(Customer customer);
}
