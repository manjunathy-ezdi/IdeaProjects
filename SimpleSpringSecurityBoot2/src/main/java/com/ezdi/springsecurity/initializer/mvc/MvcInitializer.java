package com.ezdi.springsecurity.initializer.mvc;

import com.ezdi.springsecurity.config.MyServletConfig;
import com.ezdi.springsecurity.config.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SecurityConfig.class};
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
