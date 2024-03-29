package org.embedded.hnu.main.dialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.ws.Action;
import org.embedded.hnu.generator.ai.HSNNGenerator;
import org.embedded.hnu.ioconfig.ai.HSNNIOConfig;
import static org.embedded.hnu.main.dialog.SpikingNeuralNetworkDialog.LOADDATA;
import static org.embedded.hnu.main.dialog.SpikingNeuralNetworkDialog.delim;
import static org.embedded.hnu.main.dialog.SpikingNeuralNetworkDialog.destDir;
import static org.embedded.hnu.main.dialog.SpikingNeuralNetworkDialog.srcFile;

public class InputNumberLayerDialog extends javax.swing.JDialog {
    
    public static final int H_SNN = 1;

    private HSNNGenerator hSGen = new HSNNGenerator();
    private HSNNIOConfig hSIOConf = new HSNNIOConfig();
        
    private int inputNum;
    private boolean selectedCNN;
    
    public InputNumberLayerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public InputNumberLayerDialog(java.awt.Frame parent, boolean modal, HSNNGenerator hSGen, HSNNIOConfig hSIOConf, boolean selectedCNN) {
        super(parent, modal);
        initComponents();        
        this.hSGen = hSGen;
        this.hSIOConf = hSIOConf;
        this.selectedCNN = selectedCNN;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputNumberLayerLabel = new javax.swing.JLabel();
        inputNumberLayerTextField = new javax.swing.JTextField();
        cancelNumberLayerButton = new javax.swing.JButton();
        nextNumberLayerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(260, 168));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(inputNumberLayerLabel, org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.inputNumberLayerLabel.text")); // NOI18N

        inputNumberLayerTextField.setText(org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.inputNumberLayerTextField.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(inputNumberLayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(inputNumberLayerTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputNumberLayerLabel)
                    .addComponent(inputNumberLayerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inputNumberLayerLabel, inputNumberLayerTextField});

        org.openide.awt.Mnemonics.setLocalizedText(cancelNumberLayerButton, org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.cancelNumberLayerButton.text")); // NOI18N
        cancelNumberLayerButton.setMaximumSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.setMinimumSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.setPreferredSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNumberLayerButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(nextNumberLayerButton, org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.nextNumberLayerButton.text")); // NOI18N
        nextNumberLayerButton.setMaximumSize(new java.awt.Dimension(100, 23));
        nextNumberLayerButton.setMinimumSize(new java.awt.Dimension(100, 23));
        nextNumberLayerButton.setPreferredSize(new java.awt.Dimension(100, 23));
        nextNumberLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextNumberLayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(nextNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(cancelNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cancelNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelNumberLayerButton, nextNumberLayerButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextNumberLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextNumberLayerButtonActionPerformed
        inputNum = Integer.parseInt(inputNumberLayerTextField.getText());
        this.hSGen.setNumLayer(inputNum);
        if(inputNum!=0 && selectedCNN){
            showAddLayerConfigDialog(inputNum);
        }else if(inputNum == 0){
            if(LOADDATA == true){ 
                copyFile();
                //hSGen.setData(srcFile.getName(), delim);
            }
            initGenerator();
            hSGen.writeSNNSingleGen();
        }else if(!selectedCNN){
            if(LOADDATA == true){ copyFile(); }
            cancel();
        }
    }//GEN-LAST:event_nextNumberLayerButtonActionPerformed

    private void cancelNumberLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNumberLayerButtonActionPerformed
        System.out.println("----- cancel -----");
        cancel();
    }//GEN-LAST:event_cancelNumberLayerButtonActionPerformed

    public void initGenerator(){
        hSGen.hSTATE = H_SNN;
        hSGen.createFile(hSGen.modelDir);
    }
    
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
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InputNumberLayerDialog dialog = new InputNumberLayerDialog(new javax.swing.JFrame(), true);
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

    @Action
    public void cancel() {
        this.dispose();
    }
    
    private void showAddLayerConfigDialog(int inputNum){
        AddLayerConfigDialog dialog = new AddLayerConfigDialog(null, true, inputNum, hSGen, hSIOConf);
        dialog.setLocationRelativeTo(null);
        cancel();
        dialog.setVisible(true);
    }
    
    public void copyFile(){
        System.out.println("--------------- Load ---------------");
        System.out.println("------------ copyFile() ------------");
        System.out.println("AddLayerConfigDialog srcFile.getAbsolutePath() : "+srcFile.getAbsolutePath());
        System.out.println("AddLayerConfigDialog destDir.getAbsolutePath() : "+destDir.getAbsolutePath());

        destDir.mkdirs();
        
        try{
            FileInputStream fin = new FileInputStream(srcFile.getAbsolutePath());
            FileOutputStream fout = new FileOutputStream(destDir.getAbsolutePath() + File.separatorChar + srcFile.getName());

            int tmp = 0;
            while ((tmp = fin.read()) != -1) {
                fout.write(tmp);
            }
            fin.close();
            fout.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("------------ copyFile() Finish------------");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelNumberLayerButton;
    private javax.swing.JLabel inputNumberLayerLabel;
    private javax.swing.JTextField inputNumberLayerTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextNumberLayerButton;
    // End of variables declaration//GEN-END:variables
}
