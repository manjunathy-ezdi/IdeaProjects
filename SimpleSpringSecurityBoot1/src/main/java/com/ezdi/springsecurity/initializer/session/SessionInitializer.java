package com.ezdi.springsecurity.initializer.session;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import com.ezdi.springsecurity.config.HttpSessionConfig;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */


public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(HttpSessionConfig.class);
    }
}



//public class SessionInitializer{}