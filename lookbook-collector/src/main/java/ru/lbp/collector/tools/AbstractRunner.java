package ru.lbp.collector.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 18:21
 */
public abstract class AbstractRunner {
    private static final Logger logger = LoggerFactory.getLogger(AbstractRunner.class);

    protected ApplicationContext ctx;

    protected void initContext(){
        logger.info("Initializing context starting");

        try{
            ctx = new ClassPathXmlApplicationContext("classpath:collectorContext.xml");
        }
        catch (Exception e){
            logger.error("Initializing context failed", e);
        }

        logger.info("Context initialized successfully");
    }
}
