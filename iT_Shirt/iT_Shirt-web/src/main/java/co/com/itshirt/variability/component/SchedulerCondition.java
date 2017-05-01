package co.com.itshirt.variability.component;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SchedulerCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    	System.err.println("Buuuuaaaa");
    	System.out.println(context.getEnvironment().getProperty("config.scheduler.enabled"));
        return Boolean.valueOf(context.getEnvironment().getProperty("config.scheduler.enabled"));
    }

}