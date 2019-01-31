package com.jdadfapi.ui.taskflow;

import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 19:45
 */

public class DefaultActivity extends XMLElement {

    public DefaultActivity(Element element) {
        super(element);
    }

    public String getDefaultActivity(){
        return element.getText();
    }
    public void setDefaultActivity(String name){
        element.setText(name);
    }
}
