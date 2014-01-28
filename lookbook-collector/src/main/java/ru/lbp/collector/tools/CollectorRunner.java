package ru.lbp.collector.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 15:16
 */
public class CollectorRunner extends AbstractRunner{
    private static final Logger logger = LoggerFactory.getLogger(CollectorRunner.class);

    private WebResourceDBSynchronizer webResourceDBSynchronizer;

    public static void main(String[] args) throws IOException {
        new CollectorRunner().start();
    }

    private void start() throws IOException {
        initContext();
        //WebPage page = ctx.getBean(LookBookNu.class).getIterator().next();
        ctx.getBean(WebResourceDBSynchronizer.class).findAndSynchronizeWebResources();
        //logger.info(page.getSource());
    }

}
