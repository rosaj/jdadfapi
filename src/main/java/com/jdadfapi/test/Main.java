package com.jdadfapi.test;

import com.jdadfapi.Workspace;
import com.jdadfapi.model.Model;
import com.jdadfapi.model.entity.Entity;
import com.jdadfapi.model.entity.Key;
import com.jdadfapi.model.view.EntityUsage;
import com.jdadfapi.model.view.ViewAccessor;
import com.jdadfapi.model.view.ViewAttribute;
import com.jdadfapi.model.view.ViewObject;
import com.jdadfapi.ui.Page;
import com.jdadfapi.ui.TaskFlow;
import com.jdadfapi.ui.ViewController;
import com.jdadfapi.ui.component.dataviews.Table;
import com.jdadfapi.ui.taskflow.ControlFlowRule;
import com.jdadfapi.ui.taskflow.View;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 10:10
 */

public class Main {

    public static void main(String[] args) {

        Workspace workspace = Workspace.load("path to workspace");
        workspace.getViewController().getPages().forEach(page -> System.out.println(page.getName()));
        workspace.getModel().getViewObjects().forEach(viewObject -> System.out.println(viewObject));
        ViewController viewController = ViewController.loadViewController("path");
        System.out.println("Main.main");


        ViewObject viewObject = workspace.getModel().getViewObject("ViewObject");

        for (ViewAttribute viewAttribute : viewObject.getViewAttributes()) {
            //set or read som view attribute fields
        }


        for (ViewAccessor viewAccessor : viewObject.getViewAccessors()) {
            //do something with your view accesors
        }

        //find first entity usage of view object in the model project
        Entity entity = workspace.getModel().getEntity(viewObject.getEntityUsages().get(0).getEntity());
        System.out.println(entity.getDBObjectName());

        viewObject.save();
        entity.save();

        // get all pages in the viewController part
        // this includes page templates if any
        for (Page page : viewController.getPages()) {
           if(!page.isTemplate()){
               //let's say we want to get all tables on pages
               for (Table table : page.getComponents(Table.class)) {
                   // and we want to set some attributes
                   table.setBlockRowNavigationOnError("true");
                   table.setScrollPolicy("page");
                   table.setFilterVisible("false");
               }
           }

           //save the page with the new changes
            page.save();
        }

        //let say we want to add a page to all task flows
        //and set it to default view
        Page somePage = viewController.getPages().get(0);
        for (TaskFlow taskFlow : viewController.getTaskFlows()) {
            View view = taskFlow.addView(somePage);
            //if taskflow doesn't have default view set this as default
            if(!taskFlow.hasDefaultActivity()) taskFlow.setDefaultActivity(view);
            else{
                //get the deault view
                View defaultView = taskFlow.getDefaultView();

                //create control flow rule starting from the default view
                ControlFlowRule cfr = taskFlow.createControlFlowRule(defaultView.getId());
                //create controlflowcase from default view to the new view with action "goSomePage"
                cfr.createControlFlowCase()
                        .setToActivitiyId(view.getId())
                        .setFromOutcome("goSomePage");

                /**
                    When creating a control flow rule and case we got an xml similar to this
                 <control-flow-rule id="__3">
                     <from-activity-id>defaultViewId</from-activity-id>
                     <control-flow-case id="__4">
                         <from-outcome>goSomePage</from-outcome>
                         <to-activity-id>somePage</to-activity-id>
                     </control-flow-case>
                 </control-flow-rule>
                 */
            }
        }
    }

}
