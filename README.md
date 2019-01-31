# JD ADF API
An ADF java library for editing and creating common ADF xml files.

![Build Status]( https://img.shields.io/gitlab/pipeline/rosaj/jdadfapi.svg?style=flat  )
![Version](https://img.shields.io/github/manifest-json/v/rosaj/jdadfapi.svg?style=flat)
![](https://img.shields.io/badge/jar-yes-green.svg)


<a href="https://github.com/rosaj/jdadfapi/blob/master/out/artifacts/jdadfapi_jar/jdadfapi.jar" > Jar</a>


A java library for editing and creating xml for Oracle ADF applications. This is usually done through JDeveloper but when doing repetitve task you really should make it faster.
For now only the most common xml files can be modifyed such as ViewObjects, Entites, Associations, ViewLinks, ApplicationModules ets.

This api is using decentxml for xml management, which preserve the attribute order of each xml tag, opposite to DOM xml parsers.

I will build this to maven as soon as i can.

Examples:


```java
// you can load your files using multiple methods

//you can load your whole workspace
Workspace workspace = Workspace.load("full\path\to\your\workspace","NameOfYourModelFolder", "NameOfYourViewControllerFolder");

//you can load just the model part
Model model = Model.loadModel("full\path\to\your\modelfolder");

//or you can load just the viewcontroller part 
 ViewController viewController = ViewController.loadViewController("full\path\to\your\viewcontrollerfolder")
```

After you loaded your project you can now work with your files

```java
//here we use the default "Model" and "ViewController" nams as the folders names of our projects
Workspace workspace = Workspace.load("full\path\to\your\workspace");

ViewObject viewObject = workspace.getModel().getViewObject("ViewObject");

for (ViewAttribute viewAttribute : viewObject.getViewAttributes()) {
     //set or read som view attribute properties
}


for (ViewAccessor viewAccessor : viewObject.getViewAccessors()) {
  //do something with your view accesors
}

```


You can than get the entity used by your viewobject
```java

//find first entity usage of view object in the model project
Entity entity = workspace.getModel().getEntity(viewObject.getEntityUsages().get(0).getEntity());
System.out.println(entity.getDBObjectName());

```


Every document can be saved:
```java
//save the changes made to viewobject
viewObject.save();
//save the changes made to entity
entity.save();        
```


Let's take a quick look on view part

```java
// let's see how to do some work with pages
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

```

```java
//and now some taskflow work


 //let say we want to add a page to all task flows
 //and set it to default view
 Page somePage = ...;
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


```

