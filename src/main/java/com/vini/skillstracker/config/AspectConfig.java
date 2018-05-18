package com.vini.skillstracker.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

	private Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Before("execution(* com.vini.skillstracker.*.*(..))")
	public void callSetters(JoinPoint joinPoint) {
		logger.info("Method Invoked: " + joinPoint.getSignature().getName());
		logger.info("Value Passed: " + getArgData(joinPoint.getArgs()));
	}

	private String getArgData(Object[] data) {
		StringBuilder builder = new StringBuilder();
		for (Object obj : data) {
			builder.append(obj);
			builder.append(":");
		}
		return builder.toString();
	}

}
