package ru.lbp.collector.webpage;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 20:28
 */
public class LookBookWebPage implements WebPage {
    private String source;

    public LookBookWebPage() {
    }

    public LookBookWebPage(String source) {
        this.source = source;
    }

    @Override
    public String getSource() {
        return source;
    }
}
