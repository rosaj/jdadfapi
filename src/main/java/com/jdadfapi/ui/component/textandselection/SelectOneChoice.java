package com.jdadfapi.ui.component.textandselection;

import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Dec-17
 * Time: 08:26
 */

public class SelectOneChoice extends InputUIComponent {
    public SelectOneChoice(Element element, Component parent) {
        super(element, parent);
    }

    public SelectOneChoice(Component parent) {
        this(new Element(ComponentMapper.getComponentName(SelectOneChoice.class)),parent);
    }

    public SelectOneChoice() {
        this(null);
    }

    //TODO: OSTALI PROPERTIES
}
