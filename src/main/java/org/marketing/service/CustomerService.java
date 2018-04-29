package org.marketing.service;

import org.marketing.model.bean.Customer;

import java.util.List;

public interface CustomerService {

    public boolean save(Customer customer);

    public boolean findByMobileNumer(Customer customer);

    public List getAllTheConsignee();

    public Customer getConsignee(String customer);

    public void deleteConsignee(String customer);

    public boolean saveOrUpdate(Customer customer);
}
