package ies.castillodeluna.psp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor timInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        //registry.addInterceptor(timInterceptor)
        //registry.addInterceptor(timInterceptor).excludePathPatterns("/app/show1");
        //registry.addInterceptor(timInterceptor).addPathPatterns("/app/show1", "/app/show3");
        registry.addInterceptor(timInterceptor).addPathPatterns("/app/**");

    }
    
    
    
}
