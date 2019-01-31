package com.jdadfapi.ui.component.dataviews;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.UIComponent;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 11:32
 */

public class Table extends UIComponent {
    public Table(Element element, Component parent) {
        super(element, parent);
    }

    public Table(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Table.class)),parent);
    }

    public Table() {
        this(null);
    }

    public String getRowSelection (){
        return getAttrValue(AttributeNames.ROW_SELECTION );
    }

    public String getColumnSelection (){
        return getAttrValue(AttributeNames.COLUMN_SELECTION );
    }

    public String getAllDetailsEnabled (){
        return getAttrValue(AttributeNames.ALL_DETAILS_ENABLED );
    }

    public String getVar (){
        return getAttrValue(AttributeNames.VAR );
    }

    public String getVarStatus (){
        return getAttrValue(AttributeNames.VAR_STATUS );
    }

    public String getWidth (){
        return getAttrValue(AttributeNames.WIDTH );
    }

    public String getColumnStretching (){
        return getAttrValue(AttributeNames.COLUMN_STRETCHING );
    }

    public String getDisplayRow (){
        return getAttrValue(AttributeNames.DISPLAY_ROW );
    }

    public String getHorizontalGridVisible(){
        return getAttrValue(AttributeNames.HORIZONTAL_GRID_VISIBLE );
    }

    public String getVerticalGridVisible (){
        return getAttrValue(AttributeNames.VERTICAL_GRID_VISIBLE);
    }

    public String getRowBandingInterval (){
        return getAttrValue(AttributeNames.ROW_BANDING_INTERVAL );
    }

    public String getColumnBandingInterval (){
        return getAttrValue(AttributeNames.COLUMN_BANDING_INTERVAL );
    }

    public String getFilterVisible (){
        return getAttrValue(AttributeNames.FILTER_VISIBLE );
    }

    public String getEmptyText (){
        return getAttrValue(AttributeNames.EMPTY_TEXT );
    }

    public String getSummary (){
        return getAttrValue(AttributeNames.SUMMARY );
    }

    public String getColumnResizing (){
        return getAttrValue(AttributeNames.COLUMN_RESIZING );
    }

    public String getDisableColumnReordering (){
        return getAttrValue(AttributeNames.DISABLE_COLUMN_REORDERING );
    }
    public String getAutoHeightRows (){
        return getAttrValue(AttributeNames.AUTO_HEIGHT_ROWS );
    }

    public String getFetchSize (){
        return getAttrValue(AttributeNames.FETCH_SIZE );
    }

    public String getContentDelivery (){
        return getAttrValue(AttributeNames.CONTENT_DELIVERY );
    }

    public String getImmediate (){
        return getAttrValue(AttributeNames.IMMEDIATE );
    }

    public String getEditingMode (){
        return getAttrValue(AttributeNames.EDITING_MODE );
    }

    public String getContextMenuSelect (){
        return getAttrValue(AttributeNames.CONTEXT_MENU_SELECT );
    }

    public String getRefreshCondition (){
        return getAttrValue(AttributeNames.REFRESH_CONDITION );
    }

    public String getRangeSize (){
        return getAttrValue(AttributeNames.RANGE_SIZE );
    }

    public String getRenderHint (){
        return getAttrValue(AttributeNames.RENDER_HINT );
    }

    public String getFilterModel (){
        return getAttrValue(AttributeNames.FILTER_MODEL );
    }

    public String getQueryListener (){
        return getAttrValue(AttributeNames.QUERY_LISTENER );
    }
    public String getSelectionListener (){
        return getAttrValue(AttributeNames.SELECTION_LISTENER );
    }

    public String getSortListener (){
        return getAttrValue(AttributeNames.SORT_LISTENER );
    }

    public String getRowDisclosureListener (){
        return getAttrValue(AttributeNames.ROW_DISCLOSURE_LISTENER );
    }

    public String getColumnSelectionListener  (){
        return getAttrValue(AttributeNames.COLUMN_SELECTION_LISTENER);
    }

    public String getActiveRowKey (){
        return getAttrValue(AttributeNames.ACTIVE_ROW_KEY );
    }

    public String getDisplayRowKey (){
        return getAttrValue(AttributeNames.DISPLAY_ROW_KEY );
    }

    public String getDisclosedRowKeys (){
        return getAttrValue(AttributeNames.DISCLOSED_ROW_KEYS );
    }

    public String getSelectedRowKeys (){
        return getAttrValue(AttributeNames.SELECTED_ROW_KEYS );
    }

    public String getPersist (){
        return getAttrValue(AttributeNames.PERSIST );
    }

    public String getDontPersist (){
        return getAttrValue(AttributeNames.DONT_PERSIST );
    }

    public String getBlockRowNavigationOnError (){
        return getAttrValue(AttributeNames.BLOCK_ROW_NAVIGATION_ON_ERROR );
    }

    public String getFreezeDirection (){
        return getAttrValue(AttributeNames.FREEZE_DIRECTION );
    }

    public String getMaxClientRows (){
        return getAttrValue(AttributeNames.MAX_CLIENT_ROWS );
    }

    public String getSelectionEventDelas (){
        return getAttrValue(AttributeNames.SELECTION_EVENT_DELAY );
    }

    public String getScrollPolicy (){
        return getAttrValue(AttributeNames.SCROLL_POLICY );
    }


    public void setRowSelection (String value){
        setAttrValue(AttributeNames.ROW_SELECTION , value);
    }

    public void setColumnSelection (String value){
        setAttrValue(AttributeNames.COLUMN_SELECTION , value);
    }

    public void setAllDetailsEnabled (String value){
        setAttrValue(AttributeNames.ALL_DETAILS_ENABLED , value);
    }

    public void setVar (String value){
        setAttrValue(AttributeNames.VAR , value);
    }

    public void setVarStatus (String value){
        setAttrValue(AttributeNames.VAR_STATUS , value);
    }

    public void setWidth (String value){
        setAttrValue(AttributeNames.WIDTH , value);
    }

    public void setColumnStretching (String value){
        setAttrValue(AttributeNames.COLUMN_STRETCHING , value);
    }

    public void setDisplayRow (String value){
        setAttrValue(AttributeNames.DISPLAY_ROW, value);
    }

    public void setHorizontalGridVisible (String value){
        setAttrValue(AttributeNames.HORIZONTAL_GRID_VISIBLE , value);
    }

    public void setVerticalGridVisible (String value){
        setAttrValue(AttributeNames.VERTICAL_GRID_VISIBLE , value);
    }

    public void setRowBandingInterval (String value){
        setAttrValue(AttributeNames.ROW_BANDING_INTERVAL , value);
    }

    public void setColumnBandingInterval (String value){
        setAttrValue(AttributeNames.COLUMN_BANDING_INTERVAL , value);
    }

    public void setFilterVisible (String value){
        setAttrValue(AttributeNames.FILTER_VISIBLE , value);
    }

    public void setScrollPolicy (String value){
        setAttrValue(AttributeNames.SCROLL_POLICY , value);
    }

    public void setEmptyText (String value){
        setAttrValue(AttributeNames.EMPTY_TEXT , value);
    }

    public void setSummary (String value){
        setAttrValue(AttributeNames.SUMMARY , value);
    }

    public void setColumnResizing (String value){
        setAttrValue(AttributeNames.COLUMN_RESIZING , value);
    }

    public void setDisableColumnReordering (String value){
        setAttrValue(AttributeNames.DISABLE_COLUMN_REORDERING , value);
    }

    public void setAutoHeightRows (String value){
        setAttrValue(AttributeNames.AUTO_HEIGHT_ROWS , value);
    }

    public void setFetchSize (String value){
        setAttrValue(AttributeNames.FETCH_SIZE , value);
    }

    public void setContentDelivery (String value){
        setAttrValue(AttributeNames.CONTENT_DELIVERY , value);
    }

    public void setImmediate (String value){
        setAttrValue(AttributeNames.IMMEDIATE , value);
    }

    public void setEditingMode (String value){
        setAttrValue(AttributeNames.EDITING_MODE , value);
    }

    public void setContextMenuSelect (String value){
        setAttrValue(AttributeNames.CONTEXT_MENU_SELECT , value);
    }

    public void setRefreshCondition  (String value){
        setAttrValue(AttributeNames.REFRESH_CONDITION , value);
    }

    public void setRangeSize (String value){
        setAttrValue(AttributeNames.RANGE_SIZE , value);
    }

    public void setRenderHint (String value){
        setAttrValue(AttributeNames.RENDER_HINT , value);
    }

    public void setFilterModel (String value){
        setAttrValue(AttributeNames.FILTER_MODEL , value);
    }

    public void setQueryListener (String value){
        setAttrValue(AttributeNames.QUERY_LISTENER , value);
    }


    public void setSelectionListener (String value){
        setAttrValue(AttributeNames.SELECTION_LISTENER , value);
    }

    public void setSortListener (String value){
        setAttrValue(AttributeNames.SORT_LISTENER , value);
    }


    public void setRowDisclosureListener (String value){
        setAttrValue(AttributeNames.ROW_DISCLOSURE_LISTENER , value);
    }

    public void setColumnSelectionListener  (String value){
        setAttrValue(AttributeNames.COLUMN_SELECTION_LISTENER , value);
    }


    public void setActiveRowKey (String value){
        setAttrValue(AttributeNames.ACTIVE_ROW_KEY , value);
    }

    public void setDisplayRowKey (String value){
        setAttrValue(AttributeNames.DISPLAY_ROW_KEY , value);
    }


    public void setDisclosedRowKeys (String value){
        setAttrValue(AttributeNames.DISCLOSED_ROW_KEYS , value);
    }

    public void setSelectedRowKeys (String value){
        setAttrValue(AttributeNames.SELECTED_ROW_KEYS , value);
    }


    public void setPersist (String value){
        setAttrValue(AttributeNames.PERSIST , value);
    }

    public void setDontPersist (String value){
        setAttrValue(AttributeNames.DONT_PERSIST , value);
    }

    public void setBlockRowNavigationOnError (String value){
        setAttrValue(AttributeNames.BLOCK_ROW_NAVIGATION_ON_ERROR , value);
    }

    public void setFreezeDirection (String value){
        setAttrValue(AttributeNames.FREEZE_DIRECTION , value);
    }

    public void setMaxClientRows (String value){
        setAttrValue(AttributeNames.MAX_CLIENT_ROWS , value);
    }

    public void setSelectionEventDelay (String value){
        setAttrValue(AttributeNames.SELECTION_EVENT_DELAY , value);
    }

    public void setRows(String value){
        setAttrValue(AttributeNames.ROWS, value);
    }
    public String getRows(){
        return getAttrValue(AttributeNames.ROWS);
    }


}
