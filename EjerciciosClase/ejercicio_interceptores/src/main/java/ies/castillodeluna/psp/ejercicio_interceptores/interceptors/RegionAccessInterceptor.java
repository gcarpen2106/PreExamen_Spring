package ies.castillodeluna.psp.ejercicio_interceptores.interceptors;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("regionAccessInterceptor")
public class RegionAccessInterceptor implements HandlerInterceptor {
    
    private static final Logger logger = LoggerFactory.getLogger(RegionAccessInterceptor.class);
    private static final Random random = new Random();

    @Value("${config.allowed.regions}")
    private String allowedRegions;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
                int delay = (int) (Math.random()*3000);
                Thread.sleep(delay);

                String region = request.getHeader("X-Region");

                long start = System.currentTimeMillis(); //tiempo en milisegundos
                request.setAttribute("start", start);


                Map<String, Object> data = new HashMap<>();
                ObjectMapper mapper = new ObjectMapper();

                if (!allowedRegions.contains(region)) {

                    StringBuilder message = new StringBuilder("El acceso no fue permitido para la región actual");
                    message.append(" " + region);

                    data.put("message", message);

                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().write(mapper.writeValueAsString(message));

                    return false;

                }

                logger.info("El acceso fue permitido para la region: " + region);
                return true; 

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
       
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;

        logger.info("LoadingTimeInterceptor: tiempo transcurrido: " + result + "ms");

    }

    

    

}
