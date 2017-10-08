package org.marketing.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.marketing.dao.ConsigneeDao;
import org.marketing.dao.ProductDao;
import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gn033604 on 9/24/17.
 */
@Repository
@Transactional
public class ConsigneeDaoImpl implements ConsigneeDao {

    static Logger logger = Logger.getLogger(ConsigneeDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Consignee consignee) throws  Exception{

        sessionFactory.getCurrentSession().save(consignee);

    }

    @Override
    public boolean findByProductId(Consignee consignee) {

        List list = sessionFactory.getCurrentSession().createCriteria(Consignee.class)
                .add(Restrictions.like("consigneeName", consignee.getConsigneeName())).list();

        if (list.size() > 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List getAllTheConsignee() {
        List consignee = sessionFactory.getCurrentSession().createCriteria(Consignee.class).list();
        return consignee;

    }
}
