package ies.castillodeluna.psp.spring_aop.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingAspect {
    
    private Logger logger = LoggerFactory.getLogger(GreetingAspect.class.getName());

    @Before("execution(String ies.castillodeluna.psp.spring_aop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint jp){

        String method = jp.getSignature().getName();
        String args = Arrays.toString(jp.getArgs());

        logger.info("Antes de ejecutar: " + method + " con los argumentos: " + args);

    }

    @After("execution(String ies.castillodeluna.psp.spring_aop.services.GreetingService.sayHello(..))")
    public void loggerAfter(JoinPoint jp){

        String method = jp.getSignature().getName();
        String args = Arrays.toString(jp.getArgs());

        logger.info("Antes de ejecutar: " + method + " con los argumentos: " + args);

    }

    @Around("execution(String ies.castillodeluna.psp.spring_aop.services.GreetingService.*(..))")
    public Object loggingSource(ProceedingJoinPoint jp) throws Throwable{

        String method = jp.getSignature().getName();
        String args = Arrays.toString(jp.getArgs());
        Object result = null;
        
        try {

            logger.info("El metodo " + method + "() con los parametros " + args);
            result = jp.proceed();

            logger.info("El metodo " + method + "() devuelve el resultado" + result);

            return result;
        } catch (Throwable e) {

            logger.info("Error en el metodo " + method + "() ");

            throw e;
        }

    }


}


