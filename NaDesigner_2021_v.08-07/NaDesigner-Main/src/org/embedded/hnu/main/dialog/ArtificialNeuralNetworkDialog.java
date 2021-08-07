package org.embedded.hnu.main.dialog;

import java.io.File;
import javax.swing.JFileChooser;
import static org.embedded.hnu.main.dialog.SpikingNeuralNetworkDialog.ndPrjDir;
import org.openide.filesystems.FileUtil;

public class ArtificialNeuralNetworkDialog extends javax.swing.JDialog {

    public static final int H_DATA_SET_TRAINING = 0;
    public static final int H_DATA_SET_TEST = 1;      
    
    private JFileChooser fileChooser = new JFileChooser();
    
    private int hDataSetOpt = H_DATA_SET_TRAINING;
    
    private String hDirectory="";
    
    public static boolean LOADDATA = false;   
    
    private File srcFile = new File("");
    private File destDir = new File("");
    
    public ArtificialNeuralNetworkDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public ArtificialNeuralNetworkDialog(java.awt.Frame parent, boolean modal, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        initComponents();
        modelDirTextField.setText(hDirectory);
        System.out.println("ArtificialNeuralNetworkDialog destFileDir : "+destDir);
        System.out.println("------- SetNetworkToolbarAction -------");
        LOADDATA = false;        
        srcFile = new File("");
        destDir = new File("hDir");
        System.out.println("ArtificialNeuralNetworkDialog destFileDir : "+destDir);
        System.out.println("ArtificialNeuralNetworkDialog destFileDir.getAbsolutePath() : "+destDir.getAbsolutePath());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datasetOptionButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        datasetOptionLabel = new javax.swing.JLabel();
        datasetTrainingRadioButton = new javax.swing.JRadioButton();
        datasetTestRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        modelNameLabel = new javax.swing.JLabel();
        modelNameTextField = new javax.swing.JTextField();
        modelDirLabel = new javax.swing.JLabel();
        modelDirTextField = new javax.swing.JTextField();
        modelDirBrowseButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        inputsLabel = new javax.swing.JLabel();
        inputsTextField = new javax.swing.JTextField();
        outputsLabel = new javax.swing.JLabel();
        outputsTextField = new javax.swing.JTextField();
        epochsLabel = new javax.swing.JLabel();
        epochsTextField = new javax.swing.JTextField();
        learningRateLabel = new javax.swing.JLabel();
        learningRateTextField = new javax.swing.JTextField();
        activationFunctionLabel = new javax.swing.JLabel();
        activationFunctionComboBox = new javax.swing.JComboBox();
        costFunctionLabel = new javax.swing.JLabel();
        costFunctionComboBox = new javax.swing.JComboBox();
        optimizerLabel = new javax.swing.JLabel();
        optimizerComboBox = new javax.swing.JComboBox();
        initializerLabel = new javax.swing.JLabel();
        initializerComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        loadDataFromFileCheckBox = new javax.swing.JCheckBox();
        modelFileLabel = new javax.swing.JLabel();
        modelFileTextField = new javax.swing.JTextField();
        DelimiterLabel = new javax.swing.JLabel();
        delimiterComboBox = new javax.swing.JComboBox();
        IncludeFirstLineCheckBox = new javax.swing.JCheckBox();
        FileDirBrowseButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        varificationLogTextArea1 = new javax.swing.JTextArea();
        generateButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.title_1")); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel1.border.title_1"))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 750));

        org.openide.awt.Mnemonics.setLocalizedText(datasetOptionLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.datasetOptionLabel.text_1")); // NOI18N

        datasetOptionButtonGroup.add(datasetTrainingRadioButton);
        datasetTrainingRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(datasetTrainingRadioButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.datasetTrainingRadioButton.text_1")); // NOI18N
        datasetTrainingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datasetTrainingRadioButtonActionPerformed(evt);
            }
        });

        datasetOptionButtonGroup.add(datasetTestRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(datasetTestRadioButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.datasetTestRadioButton.text_1")); // NOI18N
        datasetTestRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datasetTestRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(datasetOptionLabel)
                .addGap(46, 46, 46)
                .addComponent(datasetTrainingRadioButton)
                .addGap(48, 48, 48)
                .addComponent(datasetTestRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datasetOptionLabel)
                    .addComponent(datasetTrainingRadioButton)
                    .addComponent(datasetTestRadioButton))
                .addGap(10, 10, 10))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel2.border.title_1"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(modelNameLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelNameLabel.text_1")); // NOI18N

        modelNameTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelNameTextField.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(modelDirLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelDirLabel.text_1")); // NOI18N

        modelDirTextField.setEditable(false);
        modelDirTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        modelDirTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelDirTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(modelDirBrowseButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelDirBrowseButton.text_1")); // NOI18N
        modelDirBrowseButton.setEnabled(false);
        modelDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelDirBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modelNameLabel)
                    .addComponent(modelDirLabel))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modelDirTextField)
                    .addComponent(modelNameTextField))
                .addGap(10, 10, 10)
                .addComponent(modelDirBrowseButton)
                .addGap(18, 18, 18))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {modelDirLabel, modelNameLabel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelNameLabel)
                    .addComponent(modelNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelDirLabel)
                    .addComponent(modelDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelDirBrowseButton))
                .addGap(10, 10, 10))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel4.border.title_1"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(inputsLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.inputsLabel.text")); // NOI18N

        inputsTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.inputsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(outputsLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.outputsLabel.text")); // NOI18N

        outputsTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.outputsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(epochsLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.epochsLabel.text")); // NOI18N

        epochsTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.epochsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(learningRateLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.learningRateLabel.text")); // NOI18N

        learningRateTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.learningRateTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(activationFunctionLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.activationFunctionLabel.text")); // NOI18N

        activationFunctionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "sigmoid", "ReLU", "tanh", "Softmax" }));

        org.openide.awt.Mnemonics.setLocalizedText(costFunctionLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.costFunctionLabel.text")); // NOI18N

        costFunctionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MSE", "Cross Entropy" }));

        org.openide.awt.Mnemonics.setLocalizedText(optimizerLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.optimizerLabel.text")); // NOI18N

        optimizerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GD", "Adam" }));

        org.openide.awt.Mnemonics.setLocalizedText(initializerLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.initializerLabel.text")); // NOI18N

        initializerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Random", "Xavier" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(inputsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(optimizerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(epochsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epochsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(activationFunctionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activationFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(outputsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(learningRateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(learningRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(costFunctionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(initializerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initializerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {activationFunctionLabel, costFunctionLabel, epochsLabel, initializerLabel, inputsLabel, learningRateLabel, optimizerLabel, outputsLabel});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {activationFunctionComboBox, costFunctionComboBox, epochsTextField, initializerComboBox, inputsTextField, learningRateTextField, optimizerComboBox, outputsTextField});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputsLabel)
                    .addComponent(inputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputsLabel)
                    .addComponent(outputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(epochsLabel)
                    .addComponent(epochsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(learningRateLabel)
                    .addComponent(learningRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activationFunctionLabel)
                    .addComponent(activationFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costFunctionLabel)
                    .addComponent(costFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optimizerLabel)
                    .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initializerLabel)
                    .addComponent(initializerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {activationFunctionLabel, costFunctionLabel, epochsLabel, initializerLabel, inputsLabel, learningRateLabel, optimizerLabel, outputsLabel});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {activationFunctionComboBox, costFunctionComboBox, epochsTextField, initializerComboBox, inputsTextField, learningRateTextField, optimizerComboBox, outputsTextField});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel3.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(loadDataFromFileCheckBox, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.loadDataFromFileCheckBox.text")); // NOI18N
        loadDataFromFileCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                loadDataFromFileCheckBoxItemStateChanged(evt);
            }
        });
        loadDataFromFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataFromFileCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(modelFileLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelFileLabel.text")); // NOI18N
        modelFileLabel.setEnabled(false);

        modelFileTextField.setEditable(false);
        modelFileTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelFileTextField.text")); // NOI18N
        modelFileTextField.setPreferredSize(new java.awt.Dimension(152, 21));
        modelFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelFileTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(DelimiterLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.DelimiterLabel.text")); // NOI18N
        DelimiterLabel.setEnabled(false);

        delimiterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ",", ";", "space", "tab" }));
        delimiterComboBox.setEnabled(false);
        delimiterComboBox.setMinimumSize(new java.awt.Dimension(83, 23));
        delimiterComboBox.setPreferredSize(new java.awt.Dimension(83, 23));
        delimiterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delimiterComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(IncludeFirstLineCheckBox, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.IncludeFirstLineCheckBox.text")); // NOI18N
        IncludeFirstLineCheckBox.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(FileDirBrowseButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.FileDirBrowseButton.text")); // NOI18N
        FileDirBrowseButton.setActionCommand(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.FileDirBrowseButton.actionCommand")); // NOI18N
        FileDirBrowseButton.setEnabled(false);
        FileDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileDirBrowseButtonmodelFileBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(IncludeFirstLineCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(loadDataFromFileCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DelimiterLabel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(modelFileLabel)
                                .addGap(10, 10, 10)
                                .addComponent(modelFileTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delimiterComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FileDirBrowseButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FileDirBrowseButton, delimiterComboBox});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadDataFromFileCheckBox)
                    .addComponent(DelimiterLabel)
                    .addComponent(delimiterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FileDirBrowseButton)
                    .addComponent(modelFileLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(IncludeFirstLineCheckBox)
                .addGap(10, 10, 10))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel5.border.title"))); // NOI18N

        jScrollPane2.setEnabled(false);
        jScrollPane2.setWheelScrollingEnabled(false);

        varificationLogTextArea1.setEditable(false);
        varificationLogTextArea1.setColumns(20);
        varificationLogTextArea1.setRows(3);
        varificationLogTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        varificationLogTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(varificationLogTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        org.openide.awt.Mnemonics.setLocalizedText(generateButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.generateButton.text")); // NOI18N
        generateButton.setLabel(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.generateButton.label")); // NOI18N
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(closeButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.closeButton.text")); // NOI18N
        closeButton.setLabel(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.closeButton.label")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(generateButton)
                        .addGap(108, 108, 108)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {closeButton, generateButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(closeButton)
                    .addComponent(generateButton))
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {closeButton, generateButton});

        jPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel1.AccessibleContext.accessibleName_1")); // NOI18N

        getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datasetTrainingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datasetTrainingRadioButtonActionPerformed
        datasetTrainingRadioButton.setActionCommand("Training");
        hDataSetOpt = H_DATA_SET_TRAINING;
    }//GEN-LAST:event_datasetTrainingRadioButtonActionPerformed

    private void datasetTestRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datasetTestRadioButtonActionPerformed
        datasetTestRadioButton.setActionCommand("Test");
        hDataSetOpt = H_DATA_SET_TEST;
    }//GEN-LAST:event_datasetTestRadioButtonActionPerformed

    private void modelDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelDirBrowseButtonActionPerformed
        selectDirectory();
    }//GEN-LAST:event_modelDirBrowseButtonActionPerformed

    private void modelDirTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelDirTextFieldActionPerformed
        
    }//GEN-LAST:event_modelDirTextFieldActionPerformed

    private void FileDirBrowseButtonmodelFileBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileDirBrowseButtonmodelFileBrowseButtonActionPerformed
        selectFile();
    }//GEN-LAST:event_FileDirBrowseButtonmodelFileBrowseButtonActionPerformed

    private void delimiterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delimiterComboBoxActionPerformed
       
    }//GEN-LAST:event_delimiterComboBoxActionPerformed

    private void modelFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelFileTextFieldActionPerformed
     
    }//GEN-LAST:event_modelFileTextFieldActionPerformed

    private void loadDataFromFileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataFromFileCheckBoxActionPerformed
       
    }//GEN-LAST:event_loadDataFromFileCheckBoxActionPerformed

    private void loadDataFromFileCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_loadDataFromFileCheckBoxItemStateChanged
        if (loadDataFromFileCheckBox.isSelected()) {
            modelFileTextField.setEnabled(true);
            delimiterComboBox.setEnabled(true);
            FileDirBrowseButton.setEnabled(true);
        } else {
            modelFileTextField.setEnabled(false);
            delimiterComboBox.setEnabled(false);
            FileDirBrowseButton.setEnabled(false);
        }
    }//GEN-LAST:event_loadDataFromFileCheckBoxItemStateChanged

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
       
    }//GEN-LAST:event_generateButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArtificialNeuralNetworkDialog dialog = new ArtificialNeuralNetworkDialog(new javax.swing.JFrame(), true);
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
    
    public void selectDirectory() {
        FileUtil.preventFileChooserSymlinkTraversal(fileChooser, null);
        fileChooser.setDialogTitle("Select Project Location");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String path = this.modelDirTextField.getText();
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists()) {
                fileChooser.setSelectedFile(f);
            }
        }
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
            File projectDir = fileChooser.getSelectedFile();
            modelDirTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
        }
    }
    
    private void selectFile() {
        FileUtil.preventFileChooserSymlinkTraversal(fileChooser, null);
        fileChooser.setDialogTitle("Load File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String path = ndPrjDir;
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists()) {
                fileChooser.setSelectedFile(f);
            }
        }
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
            File projectDir = fileChooser.getSelectedFile();
            modelFileTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DelimiterLabel;
    private javax.swing.JButton FileDirBrowseButton;
    private javax.swing.JCheckBox IncludeFirstLineCheckBox;
    private javax.swing.JComboBox activationFunctionComboBox;
    private javax.swing.JLabel activationFunctionLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox costFunctionComboBox;
    private javax.swing.JLabel costFunctionLabel;
    private javax.swing.ButtonGroup datasetOptionButtonGroup;
    private javax.swing.JLabel datasetOptionLabel;
    private javax.swing.JRadioButton datasetTestRadioButton;
    private javax.swing.JRadioButton datasetTrainingRadioButton;
    private javax.swing.JComboBox delimiterComboBox;
    private javax.swing.JLabel epochsLabel;
    private javax.swing.JTextField epochsTextField;
    private javax.swing.JButton generateButton;
    private javax.swing.JComboBox initializerComboBox;
    private javax.swing.JLabel initializerLabel;
    private javax.swing.JLabel inputsLabel;
    private javax.swing.JTextField inputsTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel learningRateLabel;
    private javax.swing.JTextField learningRateTextField;
    private javax.swing.JCheckBox loadDataFromFileCheckBox;
    private javax.swing.JButton modelDirBrowseButton;
    private javax.swing.JLabel modelDirLabel;
    private javax.swing.JTextField modelDirTextField;
    private javax.swing.JLabel modelFileLabel;
    private javax.swing.JTextField modelFileTextField;
    private javax.swing.JLabel modelNameLabel;
    private javax.swing.JTextField modelNameTextField;
    private javax.swing.JComboBox optimizerComboBox;
    private javax.swing.JLabel optimizerLabel;
    private javax.swing.JLabel outputsLabel;
    private javax.swing.JTextField outputsTextField;
    private javax.swing.JTextArea varificationLogTextArea1;
    // End of variables declaration//GEN-END:variables
}
