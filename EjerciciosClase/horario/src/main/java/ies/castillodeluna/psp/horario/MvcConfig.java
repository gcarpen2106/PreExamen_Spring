package ies.castillodeluna.psp.horario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ies.castillodeluna.psp.horario.interceptors.CalendarInterceptor;

@Component
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("calendarInterceptor")
    private CalendarInterceptor calendarInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(calendarInterceptor).addPathPatterns("/foo");
    }
    


}
