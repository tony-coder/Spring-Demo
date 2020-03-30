package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.controller.WebConfig;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * getRootConfigClasses()方法返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * getServletConfigClasses()方法中，我们要求DispatcherServlet加载应用上下文时，使用定义在WebConfig配置类中的bean
     * getServletConfigClasses()方法返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};  // 指定配置类
    }

    /**
     * getServletMappings(),它会将一个或多个路径映射到DispatcherServlet上
     * 在本例中，它映射的是"/"，这表示它会是应用的默认Servlet。它会处理进入应用的所有请求。
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};  // 将DispatcherServlet映射到"/"
    }
}
