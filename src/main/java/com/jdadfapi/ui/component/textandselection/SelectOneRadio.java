package com.jdadfapi.ui.component.textandselection;

import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 04-Sep-18
 * Time: 16:01
 */

public class SelectOneRadio extends InputUIComponent {

    public SelectOneRadio(Element element, Component parent) {
        super(element, parent);
    }

    public SelectOneRadio(Component parent) {
        this(new Element(ComponentMapper.getComponentName(SelectOneRadio.class)),parent);
    }

    public SelectOneRadio() {
        this(null);
    }

    //TODO: OSTALI PROPERTIES

}
