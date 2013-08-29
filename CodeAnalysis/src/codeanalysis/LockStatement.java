/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;

/**
 *
 * @author Opponent
 */
public class LockStatement {
    
    private boolean isLocked = false;
    
    public synchronized void lock() throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
    
}
