package co.com.itshirt.variability.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	//@Conditional(SchedulerCondition.class)
//    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedRate = 5000, cron = "${config.scheduler.enabled}")
    public void reportCurrentTime() {
    	System.err.println("The time is now {} :"+ dateFormat.format(new Date()));
    }
    
//    @Scheduled(cron = "${cron.foo.bar}")
    @Scheduled(fixedRate = 5000)
//    @ConditionalOnProperty(name="config.scheduler.enabled", relaxedNames = false)
    @ConditionalOnProperty(prefix = "config.scheduler", value = "enabled")
    public void reportCurrentTime2() {
    	System.err.println("The time is now {} :"+ dateFormat.format(new Date()));
    }
}
