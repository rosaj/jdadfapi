package com.jdadfapi;

import com.jdadfapi.model.Model;
import com.jdadfapi.ui.ViewController;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 21:06
 */

public class Workspace {
    private Model model;
    private ViewController viewController;
    private String path;

    private Workspace(String path, Model model, ViewController viewController) {
        this.model = model;
        this.viewController = viewController;
        this.path = path;
      //  startWatching();
    }

    public Model getModel() {
        return model;
    }

    public ViewController getViewController() {
        return viewController;
    }

    public static Workspace load(String path, String modelName, String viewControllerName) {

        if (path == null || modelName == null || viewControllerName == null)
            throw new RuntimeException("Putanja za workspace, ime modela i viewControllera nesmije biti null");


        File f = new File(path);
        if (!f.exists()) throw new RuntimeException("Putanja za workspace nije dobra!");

        Model model = null;
        ViewController viewController = null;

        for (File file : f.listFiles()) {
            String name = file.getName();
            if (name.equals(modelName) || name.contains(modelName)) model = Model.loadModel(file.getAbsolutePath());
            else if (name.equals(viewControllerName) || name.contains(viewControllerName))
                viewController = ViewController.loadViewController(file.getAbsolutePath());

        }

        if (model == null) throw new RuntimeException(path+": Model nije uèitan!");
        if (viewController == null) throw new RuntimeException("ViewController nije uèitan!");
        Workspace w = new Workspace(path, model, viewController);
        //   w.path = path;
        viewController.internalSetWorkspace(w);
        return w;
    }

    public static Workspace load(String path) {
        return load(path, "Model", "ViewController");
    }

    @Override
    public String toString() {
        return path.substring(path.lastIndexOf("\\"));
    }
/*

    void startWatching() {

        DirectoryWatcher.Builder builder = new DirectoryWatcher.Builder();
        //.addDirectories(path);
        registerDirectorys(new File(path), builder);


        final DirectoryWatcher watcher = builder.setPreExistingAsCreated(true)
                .build((event, path) -> {
                    switch (event) {
                        case ENTRY_CREATE:
                            //           System.out.println(path + " created.");

                            break;

                        case ENTRY_MODIFY:
                            System.out.println(path + " modifyed.");
                            break;


                        case ENTRY_DELETE:
                            System.out.println(path + " deleted.");
                            break;

                    }
                });

        try {
            watcher.start(); // Actual watching starts here
            System.out.println("STARTED WATCHING " + path);
            //       TimeUnit.SECONDS.sleep(30);
            //        watcher.stop(); // Stop watching
        } catch (Exception e) {
            // Do something
            e.printStackTrace();
        }

    }

    public static void registerDirectorys(File dir, DirectoryWatcher.Builder builder) {

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("directory:" + file.getAbsolutePath());
                String name = file.getName();
                if(!name.startsWith(".") && !name.startsWith("classes")){
                    builder.addDirectories(file.getAbsolutePath());
                    registerDirectorys(file, builder);
                }

            }
        }

    }
    */

}
