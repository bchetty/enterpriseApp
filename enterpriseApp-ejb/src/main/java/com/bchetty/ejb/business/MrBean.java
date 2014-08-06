package com.bchetty.ejb.business;

import com.bchetty.ejb.business.contracts.MrBeanLocal;
import com.bchetty.ejb.business.contracts.MrBeanRemote;
import com.bchetty.ejb.business.model.Country;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Babji, Chetty
 */
@Stateless(mappedName = "enterpriseApp1/MrBeanSuper")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class MrBean implements MrBeanLocal, MrBeanRemote, Serializable {
    @PersistenceContext(unitName = "enterpriseApp1PU")
    private EntityManager entityMgr;
    
    @Override
    public Collection<Country> getCountries(Integer continentId) {
        Collection<Country> countryCol = null;
        StringBuilder sbQuery = new StringBuilder("SELECT c FROM Country c");
        if(continentId != null) {
            sbQuery.append(" where c.continent.id = ").append(continentId);
        }
        
        try {
            countryCol = entityMgr.createQuery(sbQuery.toString())
                                  .getResultList();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return countryCol;
    }
}