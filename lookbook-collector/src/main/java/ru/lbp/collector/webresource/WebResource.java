package ru.lbp.collector.webresource;

import ru.lbp.collector.iterator.WebPageIterator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 18:03
 */
public interface WebResource {
    public String getName();

    public URL getBaseURL() throws MalformedURLException;

    public WebPageIterator getIterator();
}
