package com.jdadfapi.test;

import com.jdadfapi.Workspace;

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

        Workspace workspace = Workspace.load("C:\\JDeveloper\\mywork\\MishSVN\\MishGasMaticniPodaci");
        workspace.getViewController().getPages().forEach(page -> System.out.println(page.getName()));
        workspace.getModel().getViewObjects().forEach(viewObject -> System.out.println(viewObject));
        System.out.println("Main.main");
    }

}
