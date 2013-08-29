/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;

/**
 *
 * @author Opponent
 */
public class If extends JavaProcess{
    
    private int skipIndex;
    
    public If(){
        super();
    }
    
    @Override
    public boolean isFind(){
        
        boolean found = false;
        
        if(code.charAt(index) == 'i'){
                if(code.charAt(index+1) == 'f'){
                    if(code.charAt(index+2) == '('){
                        found = true;
                        
                    }
                    skipIndex = index + 3;
                }
                skipIndex = index + 2;
            }
            skipIndex = index +1;
        
        
        return found;
    }
    
    
    @Override
    public int getSkipToIndex(){
        return skipIndex;
    }
    
    @Override
    public void updateIndex(){
        index = index + 4;
    }
    
   
}
