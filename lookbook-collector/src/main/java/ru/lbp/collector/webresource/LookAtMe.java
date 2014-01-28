package ru.lbp.collector.webresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lbp.collector.annotations.DBProjectedWebResource;
import ru.lbp.collector.iterator.WebPageIterator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: NGorelov
 * Date: 23.05.13
 * Time: 20:57
 */
@Component
@DBProjectedWebResource(name = "lookatme")
public class LookAtMe implements WebResource {
    @Autowired
    private WebPageIterator lookAtMeIterator;

    @Override
    public String getName() {
        return "LookAtMe";
    }

    @Override
    public URL getBaseURL() throws MalformedURLException {
        return new URL("lookatme.ru");
    }

    @Override
    public WebPageIterator getIterator() {
        return lookAtMeIterator;
    }
}
