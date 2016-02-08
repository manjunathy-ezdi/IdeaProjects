package config;

/**
 * Created by EZDI\manjunath.y on 6/2/16.
 */
//@EnableWebMvc
public class MySpringWebApplicationInitializer  { //implements WebApplicationInitializer

    /*
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(BeanConfiguration.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    */
}
