package com.jdadfapi.ui.component.layout;

import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.UIComponent;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Dec-17
 * Time: 23:40
 */

public abstract class LayoutComponent extends UIComponent {
    public LayoutComponent(Element element, Component parent) {
        super(element, parent);
    }
}
