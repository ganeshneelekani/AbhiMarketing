package org.marketing.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.arpit.java2blog.model.Country;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
    public void save(Consignee consignee) throws Exception {

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

    @Override
    public Consignee getConsignee(String consigneeName) {
        Consignee consignee = (Consignee) sessionFactory.getCurrentSession().get(Consignee.class, consigneeName);
        return consignee;
    }

    @Override
    public void deleteConsignee(String consignee) {

        Session session = this.sessionFactory.getCurrentSession();
        Consignee p = (Consignee) session.load(Consignee.class, new String(consignee));
        if (null != p) {
            session.delete(p);

        }
    }

    @Override
    public void saveOrUpdate(Consignee consignee) throws Exception {

        sessionFactory.getCurrentSession().saveOrUpdate(consignee);
    }
}
