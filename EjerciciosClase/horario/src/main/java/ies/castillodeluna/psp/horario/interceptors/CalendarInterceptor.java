package ies.castillodeluna.psp.horario.interceptors;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("calendarInterceptor")
public class CalendarInterceptor implements HandlerInterceptor{

    @Value("${config.calendar.open}")
    private Integer open;

    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                System.out.println(hour);

                if(hour >= open && hour < close){
                    return true;
                }

                Map<String, Object> data = new HashMap<>();
                ObjectMapper mapper = new ObjectMapper();

                StringBuilder message = new StringBuilder("Esta cerrado, fuera del horario de atencion al cliente");
                message.append("desde las " + open);
                message.append(" horas hastas las " + close);
                message.append(" horas. Gracias por su visita");

                data.put("message", message);

                response.setContentType("apllication/json");
                response.setStatus(401);
                response.getWriter().write(mapper.writeValueAsString(message));

                return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    
    
    

}
