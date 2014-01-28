package ru.lbp.collector.iterator;

import org.springframework.stereotype.Component;
import ru.lbp.collector.annotations.LogRequired;
import ru.lbp.collector.webpage.WebPage;

import java.io.IOException;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 18:37
 */
@Component
public class LookBookIterator implements WebPageIterator {
    @Override
    @LogRequired
    public WebPage next() throws IOException {
        throw new UnsupportedOperationException();
    }
}
