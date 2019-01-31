package com.jdadfapi.ui.component;

import com.jdadfapi.TagNames;
import com.jdadfapi.ui.component.core.SelectItems;
import com.jdadfapi.ui.component.core.Validator;
import com.jdadfapi.ui.component.core.View;
import com.jdadfapi.ui.component.dataviews.Column;
import com.jdadfapi.ui.component.dataviews.Table;
import com.jdadfapi.ui.component.generalcontrols.Button;
import com.jdadfapi.ui.component.generalcontrols.Link;
import com.jdadfapi.ui.component.jstl.Set;
import com.jdadfapi.ui.component.layout.*;
import com.jdadfapi.ui.component.operations.ConvertDateTime;
import com.jdadfapi.ui.component.operations.ConvertNumber;
import com.jdadfapi.ui.component.operations.Converter;
import com.jdadfapi.ui.component.templating.*;
import com.jdadfapi.ui.component.textandselection.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 08:44
 */

public class ComponentMapper {
    private  static Map<Class, String> map = new HashMap<>();

    static {
        //Defaultne komponente
        map.put(UIComponent.class, "ui:component");
        map.put(Converter.class, "af:converter");


        map.put(Link.class,TagNames.LINK);
        map.put(Facet.class,TagNames.FACET);
        map.put(Table.class,TagNames.TABLE);
        map.put(View.class,TagNames.VIEW_COMPONENT);
        map.put(Document.class,TagNames.DOCUMENT_COMPONENT);
        map.put(Button.class,TagNames.BUTTON);
        map.put(Column.class, TagNames.COLUMN);
        map.put(PanelGroupLayout.class,TagNames.PANEL_GROUP_LAYOUT);
        map.put(InputText.class,TagNames.INPUT_TEXT);
        map.put(InputComboboxListOfValues.class, TagNames.INPUT_COMBOBOX_LIST_OF_VALUES);
        map.put(InputListOfValues.class, TagNames.INPUT_LIST_OF_VALUES);
        map.put(InputDate.class,TagNames.INPUT_DATE);
        map.put(OutputText.class, TagNames.OUTPUT_TEXT);
        map.put(Composition.class, TagNames.COMPOSITION);
        map.put(Form.class,TagNames.FORM);
        map.put(PanelTabbed.class,TagNames.PANEL_TABBED);
        map.put(ShowDetailItem.class, TagNames.SHOW_DETAIL_ITEM);
        map.put(Validator.class, TagNames.VALIDATOR);
        map.put(PanelFormLayout.class, TagNames.PANEL_FORM_LAYOUT);
        map.put(SelectBooleanCheckbox.class, TagNames.SELECT_BOOLEAN_CHECKBOX);
        map.put(ConvertDateTime.class, TagNames.CONVERT_DATE_TIME);
        map.put(ConvertNumber.class, TagNames.CONVERT_NUMBER);
        map.put(Set.class,TagNames.SET);
        map.put(PageTemplate.class, TagNames.PAGE_TEMPLATE);
        map.put(XMLContent.class, TagNames.XML_CONTENT);
        map.put(CComponent.class, TagNames.C_COMPONENT);
        map.put(CFacet.class, TagNames.C_FACET);
        map.put(CFacetName.class, TagNames.C_FACET_NAME);
        map.put(Region.class,TagNames.REGION);
        map.put(PanelLabelAndMessage.class, TagNames.PANEL_LABEL_AND_MESSAGE);
        map.put(SelectOneChoice.class, TagNames.SELECT_ONE_CHOICE);
        map.put(SelectItems.class, TagNames.SELECT_ITEMS);
        map.put(OutputFormatted.class, TagNames.OUTPUT_FORMATTED);
        map.put(SelectOneRadio.class, TagNames.SELECT_ONE_RADIO);
    }


    public static String getComponentName(Class className){
       return map.get(className);
    }
    public static Class getComponentClass(String name){
        for(Map.Entry<Class,String> e: map.entrySet()){
            if(e.getValue().equals(name))return e.getKey();
        }
        return Component.class;
    }
    public static void registerComponent(String tagName, Class clazz){
        map.put(clazz, tagName);
    }
}
