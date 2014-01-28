package ru.lbp.collector.iterator;

import org.springframework.stereotype.Component;
import ru.lbp.collector.annotations.LogRequired;
import ru.lbp.collector.webpage.WebPage;

import java.io.IOException;

/**
 * User: NGorelov
 * Date: 23.05.13
 * Time: 20:59
 */
@Component
public class LookAtMeIterator implements WebPageIterator{
    @Override
    @LogRequired
    public WebPage next() throws IOException {
        throw new UnsupportedOperationException();
    }
}
