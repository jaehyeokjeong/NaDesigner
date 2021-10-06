/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.embedded.hnu.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.io.File.separatorChar;
import java.io.FileReader;
import java.util.ArrayList;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import javafx.application.Application;
@ActionID(
        category = "NaDesigner",
        id = "org.embedded.hnu.toolbar.SetHardwareToolbarAction"
)
@ActionRegistration(
        iconBase = "org/embedded/hnu/toolbar/icons/icon_Hw24.png",
        displayName = "#CTL_SetHardwareToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 200)
@Messages("CTL_SetHardwareToolbarAction=Set Hardware")
public final class SetHardwareToolbarAction implements ActionListener {
 private final Project context;
    
    public static final int IMPORT_SUCCESS = 1; 
    public static final int EXPORT_SUCCESS = 2;
    public static final int PORT_FAIL = 3;
    
    private String hDir = "";
    public SetHardwareToolbarAction(Project context) {
        this.context = context;
        /*
        FileObject f = context.getProjectDirectory();
        hDir = FileUtil.getFileDisplayName(f); 
        String path = hDir+separatorChar+"src"+separatorChar+"hnu"+separatorChar+"debug.json";
        Application.launch(drawGraph.class, "--path="+path);*/
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         System.out.println("--------- click ComponentBtn ---------");
        FileObject f = context.getProjectDirectory();
        int count = 0;
        hDir = FileUtil.getFileDisplayName(f); 
        String path = hDir+separatorChar+"src"+separatorChar+"hnu"+separatorChar+"debug.json";
        //Application.launch(drawGraph.class, "--path="+path);
      drawGraph dg = new drawGraph();
      dg.run_display(path);
    }
}
