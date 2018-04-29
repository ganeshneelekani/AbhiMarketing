package org.marketing.dao.daoImpl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.marketing.dao.CustomerDao;
import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    static Logger LOGGER = Logger.getLogger(ConsigneeDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Customer customer) throws Exception {

        sessionFactory.getCurrentSession().save(customer);

    }

    @Override
    public boolean  findByMobileNumer(Customer customer) {

        List list = sessionFactory.getCurrentSession().createCriteria(Customer.class)
                .add(Restrictions.like("mobileNumber", customer.getMobileNumber())).list();

        LOGGER.info("===SIZE======="+list.size());

        if (list.size() > 0) {
            return false;
        } else {
            return true;
        }
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
    public void saveOrUpdate(Customer customer) throws Exception {

    }
}
