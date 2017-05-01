package co.com.itshirt.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

	/**
	 * Ejemplo de joinpoint. Intercepta todos los llamados a métodos de los repositorios.
	 * @param joinPoint
	 */
	@AfterReturning("execution(* co.com.itshirt.repository.*Repository.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}

}