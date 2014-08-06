package com.bchetty.ejb.business.contracts;

import com.bchetty.ejb.business.model.Country;
import java.util.Collection;

/**
 *
 * @author Babji, Chetty
 */
public interface MrBeanSuper {
    public Collection<Country> getCountries(Integer continentId);
}
