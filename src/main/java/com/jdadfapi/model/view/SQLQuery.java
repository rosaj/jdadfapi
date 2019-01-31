package com.jdadfapi.model.view;

import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.Text;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 30-Aug-18
 * Time: 11:12
 */

public class SQLQuery extends XMLElement {
    private static final XMLTokenizer.Type CDATA = XMLTokenizer.Type.CDATA;
    private Text sqlText ;
    public SQLQuery(Element element) {
        super(element);
        loadTree();
    }
    void loadTree(){

        for (Node node : element.getNodes()) {
            if(node.getType() == CDATA){
                sqlText = (Text) node;
            }
        }
    }
    public String getSql(){
        return sqlText == null ? null : sqlText.getText();
    }
    public void setSql(String value){
        if(sqlText == null){
            sqlText = new Text(CDATA, value);
            element.addNode(sqlText);
            return;
        }
        sqlText.setText(value);
    }

}
