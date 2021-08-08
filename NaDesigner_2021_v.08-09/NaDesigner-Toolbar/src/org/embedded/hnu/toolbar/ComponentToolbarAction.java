package org.embedded.hnu.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.embedded.hnu.main.dialog.ComponentConfigDialog;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.embedded.hnu.toolbar.ComponentToolbarAction"
)
@ActionRegistration(
        iconBase = "org/embedded/hnu/toolbar/icons/icon_Comp24.png",
        displayName = "#CTL_ComponentToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 200)
@Messages("CTL_ComponentToolbarAction=ComponentToolbarAction")
public final class ComponentToolbarAction implements ActionListener {
    
    private final Project context;
    
    public static final int H_SNN = 1;    
    public static final int H_ANN = 2;   
    public static final int H_IoT = 3;  

    
    public static final int HNUM_PRJ = 1; 
    public static final int HNUM_DIAL = 2; 
    
    private String hDir = "";
    private int hState = 0;

    public ComponentToolbarAction(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        System.out.println("--------- click ComponentBtn ---------");
        FileObject f = context.getProjectDirectory();
        
        hDir = FileUtil.getFileDisplayName(f);  
        File hAnnDirectory = new File(hDir + File.separatorChar + "ann");
        File hSnnDirectory = new File(hDir + File.separatorChar + "snn");
                
        if (hAnnDirectory.isDirectory())
            hState = H_ANN;
        else if (hSnnDirectory.isDirectory())
            hState = H_SNN;
        else
            hState = H_IoT;
        
        showComponentConfigDialog();
    }
    
    private void showComponentConfigDialog(){
        System.out.println("------- ComponentAction -------");
        ComponentConfigDialog dialog = new ComponentConfigDialog(null, true, hState, HNUM_DIAL, hDir);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
}
