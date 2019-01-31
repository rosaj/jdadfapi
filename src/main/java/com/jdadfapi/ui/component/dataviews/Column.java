package com.jdadfapi.ui.component.dataviews;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.UIComponent;
import com.jdadfapi.ui.component.layout.Facet;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 20:04
 */

public class Column extends UIComponent {
    public Column(Element element, Component parent) {
        super(element, parent);
    }

    public Column(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Column.class)),parent);
    }

    public Column() {
        this(null);
    }
    public String getWidth(){
        return getAttrValue(AttributeNames.WIDTH);
    }
    public String getPersist (){
        return getAttrValue(AttributeNames.PERSIST );
    }

    public String getDontPersist (){
        return getAttrValue(AttributeNames.DONT_PERSIST );
    }
    public String getRefreshCondition (){
        return getAttrValue(AttributeNames.REFRESH_CONDITION );
    }

    public String getColSpan (){
        return getAttrValue(AttributeNames.COL_SPAN );
    }

    public String getSortStrength (){
        return getAttrValue(AttributeNames.SORT_STRENGTH );
    }

    public String getSelected (){
        return getAttrValue(AttributeNames.SELECTED );
    }

    public String getFrozen (){
        return getAttrValue(AttributeNames.FROZEN );
    }
    public String getFilterFeatures (){
        return getAttrValue(AttributeNames.FILTER_FEATURES );
    }

    public String getFilterable (){
        return getAttrValue(AttributeNames.FILTERABLE );
    }

    public String getSortProperty (){
        return getAttrValue(AttributeNames.SORT_PROPERTY );
    }

    public String getSortable (){
        return getAttrValue(AttributeNames.SORTABLE );
    }

    public String getHeaderClass (){
        return getAttrValue(AttributeNames.HEADER_CLASS );
    }

    public String getFooterClass (){
        return getAttrValue(AttributeNames.FOOTER_CLASS );
    }

    public String getHelpTopicId (){
        return getAttrValue(AttributeNames.HELP_TOPIC_ID );
    }

    public String getNoWrap (){
        return getAttrValue(AttributeNames.NO_WRAP );
    }
    public String getHeaderNoWrap (){
        return getAttrValue(AttributeNames.HEADER_NO_WRAP );
    }

    public String getShowRequired (){
        return getAttrValue(AttributeNames.SHOW_REQUIRED );
    }
    public String getAlign (){
        return getAttrValue(AttributeNames.ALIGN );
    }

    public String getMinimumWidth (){
        return getAttrValue(AttributeNames.MINIMUM_WIDTH );
    }
    public String getDisplayIndex (){
        return getAttrValue(AttributeNames.DISPLAY_INDEX );
    }

    public String geHeaderText (){
        return getAttrValue(AttributeNames.HEADER_TEXT );
    }




    public void setWidth(String value){
        setAttrValue(AttributeNames.WIDTH,value);
    }
    public void setPersist (String value){
        setAttrValue(AttributeNames.PERSIST , value);
    }

    public void setDontPersist (String value){
        setAttrValue(AttributeNames.DONT_PERSIST , value);
    }
    public void setRefreshCondition  (String value){
        setAttrValue(AttributeNames.REFRESH_CONDITION , value);
    }

    public void setColSpan (String value){
        setAttrValue(AttributeNames.COL_SPAN , value);
    }
    public void setSortStrength (String value){
        setAttrValue(AttributeNames.SORT_STRENGTH , value);
    }
    public void setSelected (String value){
        setAttrValue(AttributeNames.SELECTED , value);
    }

    public void setFrozen (String value){
        setAttrValue(AttributeNames.FROZEN , value);
    }
    public void setFilterFeatures (String value){
        setAttrValue(AttributeNames.FILTER_FEATURES , value);
    }
    public void setFilterable (String value){
        setAttrValue(AttributeNames.FILTERABLE , value);
    }

    public void setSortProperty (String value){
        setAttrValue(AttributeNames.SORT_PROPERTY , value);
    }
    public void setSortable (String value){
        setAttrValue(AttributeNames.SORTABLE , value);
    }
    public void setHeaderClass (String value){
        setAttrValue(AttributeNames.HEADER_CLASS , value);
    }

    public void setFooterClass (String value){
        setAttrValue(AttributeNames.FOOTER_CLASS , value);
    }
    public void setHelpTopicId (String value){
        setAttrValue(AttributeNames.HELP_TOPIC_ID , value);
    }
    public void setRowHeader (String value){
        setAttrValue(AttributeNames.ROW_HEADER , value);
    }
    public void setNoWrap (String value){
        setAttrValue(AttributeNames.NO_WRAP , value);
    }
    public void setHeaderNoWrap (String value){
        setAttrValue(AttributeNames.HEADER_NO_WRAP , value);
    }
    public void setShowRequired (String value){
        setAttrValue(AttributeNames.SHOW_REQUIRED , value);
    }
    public void setAlign (String value){
        setAttrValue(AttributeNames.ALIGN , value);
    }
    public void setMinimumWidth (String value){
        setAttrValue(AttributeNames.MINIMUM_WIDTH , value);
    }
    public void setDisplayIndex (String value){
        setAttrValue(AttributeNames.DISPLAY_INDEX , value);
    }
    public void setHeaderText (String value){
        setAttrValue(AttributeNames.HEADER_TEXT , value);
    }

    public Facet getFilterFacet(){
        return getFacet(AttributeNames.FILTER);
    }

    public Facet getOrCreateFilterFacet(){
        return getOrCreateFacet(AttributeNames.FILTER);
    }
    public Facet getFooterFacet(){
        return getFacet(AttributeNames.FOOTER);
    }
    public Facet getOrCreateFooterFacet(){
        return getOrCreateFacet(AttributeNames.FOOTER);
    }

    //TODO: ostali faceti
}
