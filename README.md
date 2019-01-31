# JD ADF API
An ADF java api for editing and creating common xml files

![Build Status]( https://img.shields.io/gitlab/pipeline/rosaj/jdadfapi.svg?style=flat  )
![Version](https://img.shields.io/github/manifest-json/v/rosaj/jdadfapi.svg?style=flat)


A java api create for editing and creating xml for Oracle ADF applications.
For now only the most common xml files can be modifyed such as ViewObjects, Entites, Associations, ViewLinks, ApplicationModules ets.

This api is using decentxml for xml management, which preserve the attribute order of each xml tag, opposite to DOM xml parsers.

I will build this to maven as soon as i can.

Examples of how to use api:


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
     //set or read som view attribute fields
}


for (ViewAccessor viewAccessor : viewObject.getViewAccessors()) {
  //do something with your view accesors
}

```


You can than get the entity used by your viewobject
'''java

//find first entity usage of view object in the model project
Entity entity = workspace.getModel().getEntity(viewObject.getEntityUsages().get(0).getEntity());
System.out.println(entity.getDBObjectName());

'''


Every document can be saved:
'''java
//save the changes made to viewobject
viewObject.save();
//save the changes made to entity
entity.save();        
'''
