/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;


/**
 *
 * @author Opponent
 */
public class CodeAnalysis {

    /**
     * @param args the command line arguments
     */
    
    
            
    public static void main(String[] args) {
        // TODO code application logic here
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
                gui.initStructure();
            }
        });
        
    }
}
