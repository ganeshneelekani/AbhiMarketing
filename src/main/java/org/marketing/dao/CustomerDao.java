package org.marketing.dao;

import org.marketing.model.bean.Customer;

import java.util.List;

public interface CustomerDao {


    public void save(Customer customer) throws  Exception;

    public boolean findByMobileNumer(Customer customer);

    public List getAllTheConsignee();

    public Customer getConsignee(String customer);

    public void deleteConsignee(String customer);

    public void saveOrUpdate(Customer customer) throws Exception;
}
