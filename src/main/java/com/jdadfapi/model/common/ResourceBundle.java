package com.jdadfapi.model.common;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 12-Jul-18
 * Time: 16:01
 */

public class ResourceBundle extends SchemaBasedProperties {
    public ResourceBundle(Element element) {
        super(element);
    }
    public void setPropertiesBundle(String value){
        setSBPAttrValue(TagNames.PROPERTIES_BUNDLE, value);
    }
    public String getPropertiesBundle(){
        return getSBPAttrValue(TagNames.PROPERTIES_BUNDLE);
    }


}
