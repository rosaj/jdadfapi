package com.jdadfapi.ui.component.templating;

import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.layout.Facet;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 29-Nov-17
 * Time: 19:57
 */

public abstract class TemplateComponent extends Component {
    public TemplateComponent(Element element, Component parent) {
        super(element, parent);
    }

    @Override
    public void addChild(Component child) {
        reportTemplateException();
    }

    @Override
    public void addChild(int index, Component child) {
        reportTemplateException();

    }

    @Override
    public boolean removeChild(Component child) {
        reportTemplateException();
       return false;
    }

    @Override
    public boolean removeChild(int index) {
        reportTemplateException();
        return false;
    }

    @Override
    public List<Facet> getFacets() {
        reportTemplateException();
        return null;
    }

    @Override
    public Facet getFacet(String name) {
        reportTemplateException();
        return null ;
    }

    @Override
    protected Facet getOrCreateFacet(String name) {
        reportTemplateException();
        return null;
    }

    @Override
    public void generateId() {
        reportTemplateException();
    }

    private void reportTemplateException(){
        throw new RuntimeException("TEMPLATE-u ne podrzava operaciju");
    }
}
