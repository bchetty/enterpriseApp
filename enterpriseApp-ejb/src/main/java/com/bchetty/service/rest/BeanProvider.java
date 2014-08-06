package com.bchetty.service.rest;

import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;
import java.lang.reflect.Type;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.ext.Provider;

/**
 * EJB Injector for Jersey RESTful service.
 * 
 * @author Babji, Chetty
 * REF: http://stackoverflow.com/questions/3027834/inject-a-ejb-into-jax-rs-restfull-service
 */
@Provider
public class BeanProvider implements InjectableProvider<EJB, Type> {
    @Override
    public ComponentScope getScope() {
        return ComponentScope.Singleton;
    }

    @Override
    public Injectable getInjectable(ComponentContext compCtx, EJB ejb, Type type) {
        if (!(type instanceof Class)) {
            return null;
        }

        try {
            Class klazz = (Class) type;
            Context ctx = new InitialContext();
            final Object obj = ctx.lookup("enterpriseApp1/" + klazz.getSimpleName());

            return new Injectable<Object>() {
                @Override
                public Object getValue() {
                    return obj;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}