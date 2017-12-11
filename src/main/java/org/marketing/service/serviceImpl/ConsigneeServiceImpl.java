package org.marketing.service.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.marketing.dao.ConsigneeDao;
import org.marketing.dao.daoImpl.ConsigneeDaoImpl;
import org.marketing.model.bean.Consignee;
import org.marketing.model.bean.Product;
import org.marketing.service.ConsigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gn033604 on 9/24/17.
 */
@Service
public class ConsigneeServiceImpl implements ConsigneeService {

    static Logger logger = Logger.getLogger(ConsigneeDaoImpl.class);
    @Autowired
    ConsigneeDao consigneeDao;

    @Override
    public boolean save(Consignee consignee) {

        try {
            consigneeDao.save(consignee);
        } catch (Exception e) {
            logger.info(" ======== EXCEPTION =====" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean findByProductId(Consignee consignee) {

        Boolean status = consigneeDao.findByProductId(consignee);
        return status;
    }

    @Override
    public List getAllTheConsignee() {

        List consigneeList = consigneeDao.getAllTheConsignee();
        return consigneeList;
    }

    @Override
    public Consignee getConsignee(String consigneeName) {

        Consignee consignee = consigneeDao.getConsignee(consigneeName);
        return consignee;

    }

    @Override
    public void deleteConsignee(String consignee) {

        consigneeDao.deleteConsignee(consignee);
    }

    @Override
    public boolean saveOrUpdate(Consignee consignee) {


        try {
            consigneeDao.saveOrUpdate(consignee);
        } catch (Exception e) {
            logger.info(" ======== EXCEPTION =====" + e);
            return false;
        }
        return true;
    }
}
