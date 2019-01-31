package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.common.AttrArray;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 10:43
 */

public class ListBinding extends XMLElement {

    private AttrArray attrNames;
    private AttrArray attrExpressions;
    private AttrArray derivedAttrNames;
    private AttrArray listAttrNames;
    private AttrArray listDisplayAttrNames;


    private static final String ATTR_NAMES = "AttrNames";
    private static final String ATTR_EXPRESSIONS = "AttrExpressions";
    private static final String DERIVED_ATTR_NAMES = "DerivedAttrNames";
    private static final String LIST_ATTR_NAMES = "ListAttrNames";
    private static final String LIST_DISPLAY_ATTR_NAMES = "ListDisplayAttrNames";


    public ListBinding(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.ATTR_ARRAY   : resolveAttrArray(e);break;
                    default: log(e);
                }
            }
        }
    }


    private void resolveAttrArray(Element e){
        AttrArray attrArray = new AttrArray(e);

        switch (attrArray.getName()){
            case ATTR_NAMES: attrNames = attrArray;break;
            case ATTR_EXPRESSIONS: attrExpressions = attrArray; break;
            case DERIVED_ATTR_NAMES: derivedAttrNames = attrArray;break;
            case LIST_ATTR_NAMES : listAttrNames = attrArray;break;
            case LIST_DISPLAY_ATTR_NAMES : listDisplayAttrNames = attrArray; break;
            default:
                log("ListBinding: no method for AttrAttay: " + e.getName());
        }

    }


    public AttrArray getAttrExpressions() {
        return attrExpressions;
    }

    public AttrArray getAttrNames() {
        return attrNames;
    }

    public AttrArray getDerivedAttrNames() {
        return derivedAttrNames;
    }

    public AttrArray getListAttrNames() {
        return listAttrNames;
    }

    public AttrArray getListDisplayAttrNames() {
        return listDisplayAttrNames;
    }


    public boolean hasAttrNames(){
        return attrNames != null;
    }

    public boolean hasAttrExpressions(){
        return attrExpressions != null;
    }
    public boolean hasDerivedAttrNames(){
        return derivedAttrNames != null;
    }
    public boolean hasListAttrNames(){
        return listAttrNames != null;
    }
    public boolean hasListDisplayAttrNames(){
        return listDisplayAttrNames != null;
    }

    public AttrArray createAttrNames(){

        attrNames = createAttrArray(attrNames, ATTR_NAMES);
        return attrNames;
    }

    public AttrArray createAttrExpressions(){

        attrExpressions = createAttrArray(attrExpressions, ATTR_EXPRESSIONS);
        return attrExpressions;
    }

    public AttrArray createDerivedAttrNames(){

        derivedAttrNames = createAttrArray(derivedAttrNames, DERIVED_ATTR_NAMES);
        return derivedAttrNames;
    }

    public AttrArray createListAttrNames(){

        listAttrNames = createAttrArray(listAttrNames, LIST_ATTR_NAMES);
        return listAttrNames;
    }

    public AttrArray createListDisplayAttrNames(){

        listDisplayAttrNames = createAttrArray(listDisplayAttrNames, LIST_DISPLAY_ATTR_NAMES );
        return listDisplayAttrNames; }

    private AttrArray createAttrArray(AttrArray current , String name){

        if(current!=null) return current;

       // Element e = new Element(TagNames.ATTR_ARRAY);
      //  element.addNode(e);
        current = new AttrArray(addChildElement(TagNames.ATTR_ARRAY));
        current.setName(name);
        return current;
    }

    public String getName() {
        return getAttrValue(AttributeNames.NAME_UPPER);
    }

    public void setName(String value) {
        setAttrValue(AttributeNames.NAME_UPPER, value);
    }

    public String getListVOName() {
        return getAttrValue(AttributeNames.LIST_VO_NAME);
    }

    public void setListVOName(String value) {
        setAttrValue(AttributeNames.LIST_VO_NAME, value);
    }

    public String getListRangeSize() {
        return getAttrValue(AttributeNames.LIST_RANGE_SIZE);
    }

    public void setListRangeSize(String value) {
        setAttrValue(AttributeNames.LIST_RANGE_SIZE, value);
    }

    public String getComboRowCountHint() {
        return getAttrValue(AttributeNames.COMBO_ROW_COUNT_HINT);
    }

    public void setComboRowCountHint(String value) {
        setAttrValue(AttributeNames.COMBO_ROW_COUNT_HINT, value);
    }

    public String getStaticList() {
        return getAttrValue(AttributeNames.STATIC_LIST);
    }

    public void setStaticList(String value) {
        setAttrValue(AttributeNames.STATIC_LIST, value);
    }

    public String getNullValueId() {
        return getAttrValue(AttributeNames.NULL_VALUE_ID);
    }

    public void setNullValueId(String value) {
        setAttrValue(AttributeNames.NULL_VALUE_ID, value);
    }

    public String getComboAttributeCount() {
        return getAttrValue(AttributeNames.COMBO_ATTRIBUTE_COUNT);
    }

    public void setComboAttributeCount(String value) {
        setAttrValue(AttributeNames.COMBO_ATTRIBUTE_COUNT, value);
    }

    public String getDelimiter() {
        return getAttrValue(AttributeNames.DELIMITER);
    }

    public void setDelimiter(String value) {
        setAttrValue(AttributeNames.DELIMITER, value);
    }

    public String getListRSIName() {
        return getAttrValue(AttributeNames.LIST_RSI_NAME);
    }

    public void setListRSIName(String value) {
        setAttrValue(AttributeNames.LIST_RSI_NAME, value);
    }

    public String getMRUCount() {
        return getAttrValue(AttributeNames.MRU_COUNT);
    }

    public void setMRUCount(String value) {
        setAttrValue(AttributeNames.MRU_COUNT, value);
    }

    public String getNullValueFlag() {
        return getAttrValue(AttributeNames.NULL_VALUE_FLAG);
    }

    public void setNullValueFlag(String value) {
        setAttrValue(AttributeNames.NULL_VALUE_FLAG, value);
    }


    public void createDisplayCriteria(){
        //TODO: POPRAVIT OVO!!!!
        element.addNode(new Element(TagNames.DISPLAY_CRITERIA));
    }
}
