package ies.castillodeluna.psp.interceptor.interceptors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                
                HandlerMethod controller = (HandlerMethod) handler;

                logger.info("LoadingTimeInterceptor: preHandle() entrando...." + controller.getMethod().getName());
                // acceso al controller para despues TODO

                //inicio del tiempo
                long start = System.currentTimeMillis(); //tiempo en milisegundos
                request.setAttribute("start", start);

                Random random = new Random();
                int delay = random.nextInt(1000);
                Thread.sleep(delay);

                Map<String , String> json = new HashMap<>();
                json.put("error", "No tienes acceso");
                json.put("date", new Date().toString());

                ObjectMapper om = new ObjectMapper();

                String jsonString = om.writeValueAsString(json);

                response.setStatus(401);
                response.setContentType("application/json");
                response.getWriter().write(jsonString);

                return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

                HandlerMethod controller = (HandlerMethod) handler;

                long end = System.currentTimeMillis();
                long start = (long) request.getAttribute("start");
                long result = end - start;

                logger.info("LoadingTimeInterceptor: tiempo transcurrido: " + result + "ms");
                logger.info("LoadingTimeInterceptor: postHandle() terminado...." + controller.getMethod().getName());
                
    }

    
    
    

}
