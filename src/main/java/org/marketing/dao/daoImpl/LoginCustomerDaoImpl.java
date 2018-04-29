package org.marketing.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.marketing.dao.LoginCustomerDao;
import org.marketing.model.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gn033604 on 9/23/17.
 */
@Repository
@Transactional
public class LoginCustomerDaoImpl implements LoginCustomerDao {

    static Logger logger = Logger.getLogger(LoginCustomerDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLoginUser(Customer customer) throws Exception {

        logger.info("=======================#######==========" + customer.getMobileNumber());
        sessionFactory.getCurrentSession().save(customer);

    }

    @Override
    public boolean validateCustomer(Customer customer) {

        boolean userFound = false;
        //Query using Hibernate Query Language
        String SQL_QUERY = " from Customer as o where o.mobileNumber=? and o.password=?";
        Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
        query.setParameter(0, customer.getMobileNumber());
        query.setParameter(1, customer.getPassword());
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound = true;
        }

        return userFound;
    }
}
