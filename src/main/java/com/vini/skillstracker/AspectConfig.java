package com.vini.skillstracker;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

	private Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Before("execution(* com.vini.skillstracker.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("Method Invoked: " + joinPoint.getSignature().getName());
		logger.info("Value Passed: " + getArgData(joinPoint.getArgs()));
	}

	private String getArgData(Object[] data) {
		StringBuilder builder = new StringBuilder();
		for (Object obj : data) {
			builder.append(obj.toString());
			builder.append(":");
		}
		return builder.toString();
	}

}
