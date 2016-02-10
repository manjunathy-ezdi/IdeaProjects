package com.ezdi.springsecurity.initializer.session;

import com.ezdi.springsecurity.config.HttpSessionConfig;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(HttpSessionConfig.class);
    }
}
