package ru.lbp.collector.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import ru.lbp.collector.annotations.DBProjectedWebResource;
import ru.lbp.collector.webresource.WebResource;

import java.util.ArrayList;
import java.util.List;

/**
 * User: NGorelov
 * Date: 23.05.13
 * Time: 20:24
 */
@Component
public class WebResourceDBSynchronizer {
    private static final Logger logger = LoggerFactory.getLogger(WebResourceDBSynchronizer.class);

    @Autowired
    private ApplicationContext ctx;

    public void findAndSynchronizeWebResources(){
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);

        scanner.addIncludeFilter(new AnnotationTypeFilter(DBProjectedWebResource.class));

        List<WebResource> webResources = new ArrayList();

//        for (BeanDefinition bd : scanner.findCandidateComponents("ru.lbp.collector")){
//            try {
//                //webResources.add((WebResource) ctx.getBean((ClassLoader.getSystemClassLoader().loadClass(bd.getBeanClassName())).getClass());
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

        logger.info(webResources.get(0).getName());
        logger.info(webResources.get(1).getName());
    }
}
