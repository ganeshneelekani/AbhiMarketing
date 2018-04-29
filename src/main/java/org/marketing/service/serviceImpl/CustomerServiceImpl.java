package org.marketing.service.serviceImpl;

import org.apache.log4j.Logger;
import org.marketing.dao.CustomerDao;
import org.marketing.dao.daoImpl.ConsigneeDaoImpl;
import org.marketing.model.bean.Customer;
import org.marketing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    static Logger LOGGER = Logger.getLogger(ConsigneeDaoImpl.class);


    @Autowired
    CustomerDao customerDao;

    @Override
    public boolean save(Customer customer) {

        try {
            customerDao.save(customer);
        } catch (Exception e) {
            LOGGER.info(" ======== EXCEPTION =====" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean findByMobileNumer(Customer customer) {

        Boolean status = customerDao.findByMobileNumer(customer);
        return status;
    }

    @Override
    public List getAllTheConsignee() {
        return null;
    }

    @Override
    public Customer getConsignee(String customer) {
        return null;
    }

    @Override
    public void deleteConsignee(String customer) {

    }

    @Override
    public boolean saveOrUpdate(Customer customer) {
        return false;
    }
}
