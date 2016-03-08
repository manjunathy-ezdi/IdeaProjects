package com.ezdi.springsecurity.initializer.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ezdi.springsecurity.config.MyServletConfig;

/**
 * Created by EZDI\manjunath.y on 11/2/16.
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{


    @Override
    protected Class<?>[] getRootConfigClasses() {
        //return new Class<?>[]{SecurityConfig.class};
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MyServletConfig.class};
    }
}
