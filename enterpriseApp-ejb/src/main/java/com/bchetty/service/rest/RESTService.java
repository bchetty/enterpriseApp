package com.bchetty.service.rest;

import com.bchetty.ejb.business.contracts.MrBeanSuper;
import com.bchetty.ejb.business.model.Country;
import com.google.gson.Gson;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Babji, Chetty
 */
@Path("/api")
public class RESTService {
    @EJB
    private MrBeanSuper mrBean;

    @GET
    @Path("/echo/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(@PathParam("param") String echo) {
        return echo;
    }

    @GET
    @Path("/getCountries")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountries() {
        String jsonData = null;

        try {
            Collection<Country> countryCol = mrBean.getCountries(null);
            jsonData = (countryCol != null) ? new Gson().toJson(countryCol) : null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return jsonData;
    }
}