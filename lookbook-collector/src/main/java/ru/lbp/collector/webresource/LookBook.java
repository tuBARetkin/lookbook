package ru.lbp.collector.webresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lbp.collector.annotations.DBProjectedWebResource;
import ru.lbp.collector.iterator.WebPageIterator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 18:32
 */
@Component
@DBProjectedWebResource(name = "lookbook")
public class LookBook implements WebResource {
    @Autowired
    private WebPageIterator lookBookIterator;

    @Override
    public String getName() {
        return "LookBook";
    }

    @Override
    public URL getBaseURL() throws MalformedURLException {
        return new URL("lookbook.nu");
    }

    @Override
    public WebPageIterator getIterator() {
        return lookBookIterator;
    }
}
