package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 03-Dec-17
 * Time: 19:05
 */

public class NamedXMLElement extends DesignTimeXMLElement {

    protected Properties properties;
    public NamedXMLElement(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.DESIGN_TIME : break;//resolveDesignTime(e);break;
                    case TagNames.PROPERTIES  : resolveProperties(e);break;
                    default: log(e);
                }
            }
        }
    }

    private void resolveProperties(Element e ){
        properties = new Properties(e);
    }



    protected void setSchemaBPAttr(String name, String value){
        if(value == null){
            if(getSchemaBPAttr(name)==null || properties==null || properties.getSchemaBasedProperties()==null)return;
        }
        ensureProperties();
        properties.getSchemaBasedProperties().setSBPAttrValue(name,value);

    }
    protected String getSchemaBPAttr(String name){
        if(properties == null)return  null;
        if(properties.getSchemaBasedProperties()==null)return null;
        return properties.getSchemaBasedProperties().getSBPAttrValue(name);
    }


    private void ensureProperties(){
        if (properties == null) {

            int index = hasDesignTime() ? 1 : 0;
            properties = new Properties(addChildElement(index, TagNames.PROPERTIES));
        }
        properties.ensureSchemaBP();
    }

    public boolean hasDesignTime(){
        return designTime != null;
    }

    public String getLabelPlural (){
        return getSchemaBPAttr(TagNames.LABEL_PLURAL );
    }
    public void setLabelPlural (String value){
        setSchemaBPAttr(TagNames.LABEL_PLURAL , value);
    }

    public String getSerializerClass (){
        return getAttrValue(AttributeNames.SERIALIZER_CLASS );
    }
    public void setSerializerClass (String value){
        setAttrValue(AttributeNames.SERIALIZER_CLASS , value);
    }

    public String getFromCustomization (){
        return getAttrValue(AttributeNames.FROM_CUSTOMIZATION );
    }
    public void setFromCustomization (String value){
        setAttrValue(AttributeNames.FROM_CUSTOMIZATION , value);
    }

    public String getStorage (){
        return getAttrValue(AttributeNames.STORAGE );
    }
    public void setStorage (String value){
        setAttrValue(AttributeNames.STORAGE , value);
    }

    public String getIsEffectiveEndDate (){
        return getAttrValue(AttributeNames.IS_EFFECTIVE_END_DATE );
    }
    public void setIsEffectiveEndDate (String value){
        setAttrValue(AttributeNames.IS_EFFECTIVE_END_DATE , value);
    }

    public String getIsEffectiveStartDate (){
        return getAttrValue(AttributeNames.IS_EFFECTIVE_START_DATE );
    }
    public void setIsEffectiveStartDate (String value){
        setAttrValue(AttributeNames.IS_EFFECTIVE_START_DATE , value);
    }

    public void setDescription(String value){
        setDesignTimeAttr(AttributeNames._DESCRIPTION,value);
    }
    public String getDescription(){
        return  getDesignTimeAttr(AttributeNames._DESCRIPTION);
    }
    public String getDisplayhint (){
        return getSchemaBPAttr(TagNames.DISPLAYHINT );
    }
    public void setDisplayhint (String value){
        setSchemaBPAttr(TagNames.DISPLAYHINT , value);
    }

    public String getControlType (){
        return getSchemaBPAttr(TagNames.CONTROLTYPE );
    }
    public void setControlType (String value){
        setSchemaBPAttr(TagNames.CONTROLTYPE , value);
    }

    public String getDisplayWidth (){
        return getSchemaBPAttr(TagNames.DISPLAYWIDTH );
    }
    public void setFmtFormatter(String value){
        setSchemaBPAttr(TagNames.FMT_FORMATTER , value);
    }
    public String getFmtFormatter(){
        return getSchemaBPAttr(TagNames.FMT_FORMATTER);
    }



    public void setFmtFormat(String value){
        setSchemaBPAttr(TagNames.FMT_FORMAT , value);
    }
    public String getFmtFormat(){
        return getSchemaBPAttr(TagNames.FMT_FORMAT);
    }



    public void setDisplayWidth (String value){
        setSchemaBPAttr(TagNames.DISPLAYWIDTH , value);
    }

    public String getDisplayHeight (){
        return getSchemaBPAttr(TagNames.DISPLAYHEIGHT );
    }
    public void setDisplayHeight (String value){
        setSchemaBPAttr(TagNames.DISPLAYHEIGHT , value);
    }

    public String getFormType (){
        return getSchemaBPAttr(TagNames.FORMTYPE );
    }
    public void setFormType (String value){
        setSchemaBPAttr(TagNames.FORMTYPE , value);
    }

    public String getAutoSubmit (){
        return getSchemaBPAttr(TagNames.AUTOSUBMIT );
    }
    public void setAutoSubmit (String value){
        setSchemaBPAttr(TagNames.AUTOSUBMIT , value);
    }

    public String getXmlElement (){
        return getSchemaBPAttr(TagNames.XML_ELEMENT );
    }
    public void setXmlElement (String value){
        setSchemaBPAttr(TagNames.XML_ELEMENT , value);
    }

    public String getXmlExplicitNull (){
        return getSchemaBPAttr(TagNames.XML_EXPLICIT_NULL );
    }
    public void setXmlExplicitNull (String value){
        setSchemaBPAttr(TagNames.XML_EXPLICIT_NULL , value);
    }

    public String getLabel (){
        return getSchemaBPAttr(TagNames.LABEL );
    }
    public void setLabel (String value){
        setSchemaBPAttr(TagNames.LABEL , value);
    }
    public String getTooltip(){
        return getSchemaBPAttr(TagNames.TOOLTIP );
    }
    public void setTooltip (String value){
        setSchemaBPAttr(TagNames.TOOLTIP , value);
    }
    public String getDiscrColumn (){
        return getAttrValue(AttributeNames.DISCR_COLUMN );
    }
    public void setDiscrColumn (String value){
        setAttrValue(AttributeNames.DISCR_COLUMN , value);
    }

    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER,value);
    }

    public String getIsUpdateable (){
        return getAttrValue(AttributeNames.IS_UPDATEABLE );
    }
    public void setIsUpdateable (String value){
        setAttrValue(AttributeNames.IS_UPDATEABLE , value);
    }


    public String getPrecisionRule (){
        return getAttrValue(AttributeNames.PRECISION_RULE );
    }
    public void setPrecisionRule (String value){
        setAttrValue(AttributeNames.PRECISION_RULE , value);
    }

    public String getPrecision (){
        return getAttrValue(AttributeNames.PRECISION );
    }
    public void setPrecision (String value){
        setAttrValue(AttributeNames.PRECISION , value);
    }

    public String getScale (){
        return getAttrValue(AttributeNames.SCALE );
    }
    public void setScale (String value){
        setAttrValue(AttributeNames.SCALE , value);
    }

    public String getIsNotNull (){
        return getAttrValue(AttributeNames.IS_NOT_NULL );
    }
    public void setIsNotNull (String value){
        setAttrValue(AttributeNames.IS_NOT_NULL , value);
    }

    public String getColumnType (){
        return getAttrValue(AttributeNames.COLUMN_TYPE );
    }
    public void setColumnType (String value){
        setAttrValue(AttributeNames.COLUMN_TYPE , value);
    }

    public String getSQLType (){
        return getAttrValue(AttributeNames.SQL_TYPE );
    }
    public void setSQLType (String value){
        setAttrValue(AttributeNames.SQL_TYPE , value);
    }

    public String getDefaultValue (){
        return getAttrValue(AttributeNames.DEFAULT_VALUE );
    }
    public void setDefaultValue (String value){
        setAttrValue(AttributeNames.DEFAULT_VALUE , value);
    }

    public String getTypeValueMapPropertySet (){
        return getAttrValue(AttributeNames.TYPE_VALUE_MAP_PROPERTY_SET );
    }
    public void setTypeValueMapPropertySet (String value){
        setAttrValue(AttributeNames.TYPE_VALUE_MAP_PROPERTY_SET , value);
    }
    public String getIsQueriable (){
        return getAttrValue(AttributeNames.IS_QUERIABLE );
    }
    public void setIsQueriable (String value){
        setAttrValue(AttributeNames.IS_QUERIABLE , value);
    }

    public String getIsSelected (){
        return getAttrValue(AttributeNames.IS_SELECTED );
    }
    public void setIsSelected (String value){
        setAttrValue(AttributeNames.IS_SELECTED , value);
    }

    public String getType (){
        return getAttrValue(AttributeNames.TYPE_UPPER );
    }
    public void setType (String value){
        setAttrValue(AttributeNames.TYPE_UPPER , value);
    }

    public String getIsPersistent (){
        return getAttrValue(AttributeNames.IS_PERSISTENT );
    }
    public void setIsPersistent (String value){
        setAttrValue(AttributeNames.IS_PERSISTENT , value);
    }


    @Override
    public String toString() {
        return getName() != null ? getName(): super.toString();
    }
}
