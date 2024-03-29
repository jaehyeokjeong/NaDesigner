package org.embedded.hnu.main.dialog;

import java.awt.Image;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer.Form;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.embedded.hnu.generator.file.HFunctionGenerator;
import org.embedded.hnu.generator.file.HManifestGenerator;
import org.embedded.hnu.generator.file.HUIGenerator;
import org.embedded.hnu.ioconfig.HComponentConfig;
import org.openide.util.Exceptions;

public class ComponentConfigDialog extends javax.swing.JDialog {
    
    public static final int H_SNN = 1;
    public static final int H_ANN = 2;
    public static final int H_IoT = 3;
    
    public static final int HNUM_PRJ = 1; 
    public static final int HNUM_DIAL = 2;
    
    private int hState = 0;
    private int hNum = 0; 

    private HComponentConfig hCompConf = new HComponentConfig();
    private HManifestGenerator hManifGen;
    private HFunctionGenerator hFuncGen;
    private HUIGenerator hUIGen;
   
    private String compDir; 
    private String compName; 
    
    private int input;
    private int output;
    private String keywords;
    private String[] keywordsArr;
    private String description;
    public BufferedImage iconImage;

    
    public ComponentConfigDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public ComponentConfigDialog(java.awt.Frame parent, boolean modal, int input, int output, String keywords, String description, int state, int num) {
        super(parent, modal);
        initComponents();
        this.input = input;
        this.output = output;
        this.keywords = keywords;
        this.description = description;
        hState = state;
        hNum = num;
    }
    
        public ComponentConfigDialog(java.awt.Frame parent, boolean modal, int state, int num, String dir) {
        super(parent, modal);

        input = hCompConf.getComponentInput();
        output = hCompConf.getComponentOutput();
        keywords = hCompConf.getKeyword();
        description = hCompConf.getDescription();
        hState = state;
        hNum = num;
        compDir = dir;
        String[] sub = compDir.split("\\\\");
        compName = sub[(sub.length)-1];
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        outputLabel = new javax.swing.JLabel();
        inputLabel = new javax.swing.JLabel();
        inputTextField = new javax.swing.JTextField();
        outputTextField = new javax.swing.JTextField();
        String keywordTemp = "";
        keywordTextField = new javax.swing.JTextField();
        keywordLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        DescriptionLabel = new javax.swing.JLabel();
        okNumberLayerButton = new javax.swing.JButton();
        cancelNumberLayerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.title")); // NOI18N
        setIconImage(iconImage);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(320, 323));
        setName("dialog4"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(outputLabel, org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.outputLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(inputLabel, org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.inputLabel.text")); // NOI18N

        if(input != 0){
            inputTextField.setText(Integer.toString(input));
        }else{
            inputTextField.setText(Integer.toString(1));
        }

        if(output != 0){
            outputTextField.setText(Integer.toString(output));
        }else{
            outputTextField.setText(Integer.toString(1));
        }

        if(keywords != null){
            keywordTextField.setText(keywords);
        }
        else{
            if(hState==H_SNN)
            keywordTemp = "snn;";
            else if(hState == H_ANN)
            keywordTemp = "ann;";
            else
            keywordTemp = "iot;";
            keywordTextField.setText(keywordTemp);
        }

        org.openide.awt.Mnemonics.setLocalizedText(keywordLabel, org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.keywordLabel.text")); // NOI18N

        jScrollPane1.setEnabled(false);
        jScrollPane1.setWheelScrollingEnabled(false);

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(3);
        if(description != null){
            descriptionTextArea.setText(description);
        }else{
            descriptionTextArea.setText(compName+" description.");
        }
        descriptionTextArea.setToolTipText(org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.descriptionTextArea.toolTipText")); // NOI18N
        descriptionTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        descriptionTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        descriptionTextArea.setMaximumSize(new java.awt.Dimension(2147483647, 58));
        descriptionTextArea.setMinimumSize(new java.awt.Dimension(164, 58));
        jScrollPane1.setViewportView(descriptionTextArea);

        org.openide.awt.Mnemonics.setLocalizedText(DescriptionLabel, org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.DescriptionLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keywordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescriptionLabel)
                            .addComponent(outputLabel)
                            .addComponent(inputLabel))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(outputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(keywordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DescriptionLabel, inputLabel, keywordLabel, outputLabel});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(outputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keywordLabel))
                .addGap(18, 18, 18)
                .addComponent(DescriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DescriptionLabel, inputLabel, keywordLabel, outputLabel});

        DescriptionLabel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.DescriptionLabel.AccessibleContext.accessibleName")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(okNumberLayerButton, org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.okNumberLayerButton.text")); // NOI18N
        okNumberLayerButton.setMaximumSize(new java.awt.Dimension(100, 23));
        okNumberLayerButton.setMinimumSize(new java.awt.Dimension(100, 23));
        okNumberLayerButton.setPreferredSize(new java.awt.Dimension(100, 23));
        okNumberLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okNumberLayerButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelNumberLayerButton, org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.cancelNumberLayerButton.text")); // NOI18N
        cancelNumberLayerButton.setMaximumSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.setMinimumSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.setPreferredSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNumberLayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(cancelNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelNumberLayerButton, okNumberLayerButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cancelNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelNumberLayerButton, okNumberLayerButton});

        jPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ComponentConfigDialog.class, "ComponentConfigDialog.jPanel1.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelNumberLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNumberLayerButtonActionPerformed
        System.out.println("----- cancel -----");
        cancel();
    }//GEN-LAST:event_cancelNumberLayerButtonActionPerformed

    private void okNumberLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okNumberLayerButtonActionPerformed
        initComponentConfig();
        cancel();
    }//GEN-LAST:event_okNumberLayerButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComponentConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComponentConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComponentConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComponentConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ComponentConfigDialog dialog = new ComponentConfigDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void initComponentConfig(){

        hCompConf.setComponentInput(Integer.parseInt(inputTextField.getText()));
        hCompConf.setComponentOutput(Integer.parseInt(outputTextField.getText()));
        hCompConf.setKeyword(keywordTextField.getText());
        hCompConf.setDescription(descriptionTextArea.getText());
        
        hManifGen = new HManifestGenerator(hCompConf, hState, hNum, compDir);
        hUIGen = new HUIGenerator(hCompConf, hState, hNum, compDir);
        
        if(input != hCompConf.getComponentInput()){
            hUIGen.componentInputReplace(input);
        }
        if(output != hCompConf.getComponentOutput()){
            hUIGen.componentOutputReplace(output);
        }
        if(keywords != hCompConf.getKeyword()){
            hManifGen.keywordReplace(keywords);
        }
        if(description != hCompConf.getDescription()){
            hManifGen.descriptionReplace(description);
            hUIGen.descriptionReplace(description);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JButton cancelNumberLayerButton;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JTextField inputTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel keywordLabel;
    private javax.swing.JTextField keywordTextField;
    private javax.swing.JButton okNumberLayerButton;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JTextField outputTextField;
    // End of variables declaration//GEN-END:variables

    private void cancel() {
        this.dispose();
    }
}
