package org.marketing.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.marketing.dao.LoginUserDao;
import org.marketing.dao.ProductDao;
import org.marketing.model.LoginUser;
import org.marketing.model.bean.Consignee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gn033604 on 9/23/17.
 */
@Repository
@Transactional
public class LoginUserDaoImpl implements LoginUserDao {

    static Logger logger = Logger.getLogger(LoginUserDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLoginUser(LoginUser loginUser) throws Exception {

        logger.info("=======================#######==========" + loginUser.getUserName());
        sessionFactory.getCurrentSession().save(loginUser);

    }

    @Override
    public boolean validateUser(LoginUser loginUser) {

        boolean userFound = false;
        //Query using Hibernate Query Language
        String SQL_QUERY = " from LoginUser as o where o.userName=? and o.password=?";
        Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
        query.setParameter(0, loginUser.getUserName());
        query.setParameter(1, loginUser.getPassword());
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound = true;
        }

        return userFound;
    }
}
