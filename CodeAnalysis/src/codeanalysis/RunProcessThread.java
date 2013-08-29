/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;



/**
 *
 * @author Opponent
 */
public class RunProcessThread extends Thread{

    private JavaProcess p;
    private String code;
    
    public RunProcessThread(JavaProcess p,String code){
        this.p = p;
        this.code = code;
    }
    
    @Override
    public void run() {
        p.initStack();
        p.setCode(code);
        try {
            p.processCode(0);
        } catch (InterruptedException ex) {
            
        }
        p.resetVariable();
    }
    
}
