package com.jdadfapi.ui.component;

import com.jdadfapi.ui.component.generalcontrols.Link;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 09-Nov-17
 * Time: 00:41
 */

public class PanelFormLayout extends UIComponent {
    public PanelFormLayout(Element element, Component parent) {
        super(element, parent);
    }

    public PanelFormLayout(Component parent) {
        super(new Element(ComponentMapper.getComponentName(PanelFormLayout.class)),parent);
    }

    public PanelFormLayout() {
        this(null);
    }

    //TODO: Attributi
}
