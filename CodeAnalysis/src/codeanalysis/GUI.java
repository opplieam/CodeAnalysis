/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.Observable;
import java.util.Observer;




/**
 *
 * @author Opponent
 */
public class GUI extends JFrame implements Observer{
    
    private JButton AnalyzeButton;
    private JTextField AnalyzeTextField;
    private JLabel BigOLabel;
    private JTextArea CodeTextArea;
    private JLabel NestedForLabel;
    private JTextField NestedForTextField;
    private JLabel NestedIfLabel;
    private JTextField NestedIfTextField;
    private JLabel NestedWhileLabel;
    private JTextField NestedWhileTextField;
    private JLabel TitleLabel;
    private JLabel TotalForLabel;
    private JTextField TotalForTextField;
    private JLabel TotalIfLabel;
    private JTextField TotalIfTextField;
    private JLabel TotalWhileLabel;
    private JTextField TotalWhileTextField;
    private JPanel stackPanel;
    private JScrollPane codeScrollPane;
    private JScrollPane processScrollPane;
    private JScrollPane stackScrollPane;
    private JLabel milliLabel;
    private JLabel processLabel;
    private JTextArea processTextArea;
    private JLabel stackLabel;
    //private JTextPane stackTextPane;
    private JTextArea stackTextPane;
    
    private List<JavaProcess> processList;
    

    
    
    public GUI(){
        initComponents();
        new Controller();
            
    }
    
   public void initStructure(){
            processList = new ArrayList<>();
            JavaProcess forProcess = new For();
            JavaProcess whileProcess = new While();
            JavaProcess ifProcess = new If();
            forProcess.addObserver(this);
            whileProcess.addObserver(this);
            ifProcess.addObserver(this);
            processList.add(forProcess);
            processList.add(ifProcess);
            processList.add(whileProcess);
   }
    
   private String getClassName(JavaProcess javaClassArg){
       String className;
        
       className = javaClassArg.getClass().getName().replace("codeanalysis.", "");
       
       return className;
   }
   
    @Override
    public void update(Observable o, Object arg) {
            if(arg instanceof JavaProcess){
                JavaProcess jp = (JavaProcess) arg;
                String word = jp.getWord();
                String className = getClassName(jp);
                if(word.length() > 5){
                    processTextArea.append("("+className+" Process) "+word+"\n");
                }else if(word.equals("done")){
                    
                    if(className.equals("For")){
                        TotalForTextField.setText(jp.getTotalCount()+"");
                        NestedForTextField.setText(jp.getTotalNestedCount()+"");
                        processTextArea.append("End For process"+"\n");
                    }
                    if(className.equals("If")){
                        TotalIfTextField.setText(jp.getTotalCount()+"");
                        NestedIfTextField.setText(jp.getTotalNestedCount()+"");
                        processTextArea.append("End If process"+"\n");
                    }
                    if(className.equals("While")) {
                        TotalWhileTextField.setText(jp.getTotalCount()+"");
                        NestedWhileTextField.setText(jp.getTotalNestedCount()+"");
                        processTextArea.append("End While process"+"\n");
                    }
                    
                }else{
                    stackTextPane.append(word);
                }
            }
            
            
        }
    
    @SuppressWarnings("unchecked")
    private void initComponents(){
        
        TitleLabel = new JLabel();
        codeScrollPane = new JScrollPane();
        CodeTextArea = new JTextArea();
        AnalyzeButton = new JButton();
        TotalWhileLabel = new JLabel();
        BigOLabel = new JLabel();
        NestedForLabel = new JLabel();
        NestedIfLabel = new JLabel();
        NestedWhileLabel = new JLabel();
        TotalIfLabel = new JLabel();
        TotalForLabel = new JLabel();
        NestedIfTextField = new JTextField();
        NestedForTextField = new JTextField();
        NestedWhileTextField = new JTextField();
        TotalIfTextField = new JTextField();
        TotalForTextField = new JTextField();
        TotalWhileTextField = new JTextField();
        AnalyzeTextField = new JTextField();
        milliLabel = new JLabel();
        processScrollPane = new JScrollPane();
        processTextArea = new JTextArea();
        processLabel = new JLabel();
        stackPanel = new JPanel();
        stackLabel = new JLabel();
        stackScrollPane = new JScrollPane();
        //stackTextPane = new JTextPane();
        stackTextPane = new JTextArea();
        
        setTitle("Code Analysis");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        TitleLabel.setText("Enter your code");

        CodeTextArea.setColumns(20);
        CodeTextArea.setRows(5);
        codeScrollPane.setViewportView(CodeTextArea);
        
        // Button
        AnalyzeButton.setText("Analyze");
        // Add action listening
        //AnalyzeButton.addActionListener(new Controller());
        

        TotalWhileLabel.setText("Total while loop");

        BigOLabel.setText("Analyzed time used");

        NestedForLabel.setText("Nested for loop");

        NestedIfLabel.setText("Nested if");

        NestedWhileLabel.setText("Nested while loop");

        TotalIfLabel.setText("Total if");

        TotalForLabel.setText("Total for loop");

        NestedIfTextField.setEditable(false);
        NestedIfTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NestedIfTextField.setText("0");

        NestedForTextField.setEditable(false);
        NestedForTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NestedForTextField.setText("0");

        NestedWhileTextField.setEditable(false);
        NestedWhileTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NestedWhileTextField.setText("0");

        TotalIfTextField.setEditable(false);
        TotalIfTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalIfTextField.setText("0");

        TotalForTextField.setEditable(false);
        TotalForTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalForTextField.setText("0");

        TotalWhileTextField.setEditable(false);
        TotalWhileTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalWhileTextField.setText("0");

        AnalyzeTextField.setEditable(false);
        AnalyzeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AnalyzeTextField.setText("0");

        milliLabel.setText("Milliseconds");

        processTextArea.setColumns(20);
        processTextArea.setRows(5);
        processScrollPane.setViewportView(processTextArea);

        processLabel.setText("Process");

        stackPanel.setBackground(new java.awt.Color(153, 153, 153));

        stackLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        stackLabel.setText("Stack");

        stackTextPane.setEditable(false);
        stackTextPane.setFont(new java.awt.Font("Lucida Grande", 1, 25));
        stackTextPane.setForeground(Color.RED);
        stackScrollPane.setViewportView(stackTextPane);
        
        
        org.jdesktop.layout.GroupLayout stackPanelLayout = new org.jdesktop.layout.GroupLayout(stackPanel);
        stackPanel.setLayout(stackPanelLayout);
        stackPanelLayout.setHorizontalGroup(
            stackPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(stackLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(stackScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        stackPanelLayout.setVerticalGroup(
            stackPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stackPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .add(stackPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, stackPanelLayout.createSequentialGroup()
                        .add(stackLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(35, 35, 35))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, stackPanelLayout.createSequentialGroup()
                        .add(stackScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(27, 27, 27))))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(222, 222, 222)
                        .add(TitleLabel))
                    .add(layout.createSequentialGroup()
                        .add(235, 235, 235)
                        .add(AnalyzeButton)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(codeScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 491, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(NestedIfLabel)
                    .add(NestedForLabel)
                    .add(NestedWhileLabel)
                    .add(TotalIfLabel)
                    .add(TotalForLabel)
                    .add(TotalWhileLabel)
                    .add(BigOLabel))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(TotalIfTextField)
                    .add(TotalForTextField)
                    .add(TotalWhileTextField)
                    .add(AnalyzeTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .add(NestedForTextField)
                    .add(NestedIfTextField)
                    .add(NestedWhileTextField))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(milliLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 51, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(processLabel)
                    .add(processScrollPane)
                    .add(stackPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(TitleLabel)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(codeScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 333, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(29, 29, 29)
                                .add(processLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(processScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(45, 45, 45)
                                .add(stackPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(AnalyzeButton))
                    .add(layout.createSequentialGroup()
                        .add(21, 21, 21)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(NestedIfLabel)
                            .add(NestedIfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(NestedForLabel)
                            .add(NestedForTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(NestedWhileLabel)
                            .add(NestedWhileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(23, 23, 23)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(TotalIfLabel)
                            .add(TotalIfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(TotalForTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(TotalForLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(TotalWhileLabel)
                            .add(TotalWhileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(15, 15, 15)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(BigOLabel)
                            .add(AnalyzeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(milliLabel))))
                .add(28, 28, 28))
        );
        
        pack();
        
        
        
    }

    
    
    private class Controller implements ActionListener {
        
        private List<Thread> threadList;
        
        public Controller() {
            GUI.this.AnalyzeButton.addActionListener(this);
        }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        threadList = new ArrayList<>();
        
        stackTextPane.setText(null);
        processTextArea.setText(null);
        String code = CodeTextArea.getText();
        
        
        for(JavaProcess p : processList){
            RunProcessThread thread = new RunProcessThread(p, code);
            threadList.add(thread);
        }
        long start = System.currentTimeMillis();
        for(Thread t : threadList){
            t.start();
            
        }
        
        long end = System.currentTimeMillis();
        AnalyzeTextField.setText(end-start+"");
    }

    
    
}
    
}
