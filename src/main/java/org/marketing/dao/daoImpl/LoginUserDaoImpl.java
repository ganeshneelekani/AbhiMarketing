package org.marketing.dao.daoImpl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.marketing.dao.LoginUserDao;
import org.marketing.dao.ProductDao;
import org.marketing.model.LoginUser;
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

        logger.info("=======================#######=========="+loginUser.getUserName());

        sessionFactory.getCurrentSession().save(loginUser);


    }
}
