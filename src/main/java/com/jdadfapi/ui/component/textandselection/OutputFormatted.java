package com.jdadfapi.ui.component.textandselection;

import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.UIComponent;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 12-Jan-18
 * Time: 19:37
 */

public class OutputFormatted extends UIComponent {
    public OutputFormatted(Element element, Component parent) {
        super(element, parent);
    }

    public OutputFormatted(Component parent) {
        super(new Element(ComponentMapper.getComponentName(OutputFormatted.class)),parent);
    }

    public OutputFormatted() {
        this(null);
    }
}
