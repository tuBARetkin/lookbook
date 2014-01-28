package ru.lbp.collector.iterator;

import ru.lbp.collector.webpage.WebPage;

import java.io.IOException;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 18:27
 */
public interface WebPageIterator {
    public WebPage next() throws IOException;
}
