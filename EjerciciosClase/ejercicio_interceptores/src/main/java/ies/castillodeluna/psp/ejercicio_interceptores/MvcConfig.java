package ies.castillodeluna.psp.ejercicio_interceptores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ies.castillodeluna.psp.ejercicio_interceptores.interceptors.RegionAccessInterceptor;

@Component
public class MvcConfig implements WebMvcConfigurer {
    
    @Autowired
    @Qualifier("regionAccessInterceptor")
    private RegionAccessInterceptor regionAccessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(regionAccessInterceptor).addPathPatterns("/api/**"); 
    }

    

}
