/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;

/**
 *
 * @author Opponent
 */
public class For extends JavaProcess{
    
    private int skipIndex;
    
    public For(){
        super();
    }
    
    @Override
    public boolean isFind(){
        
        boolean found = false;
        
        if(code.charAt(index) == 'f'){
                if(code.charAt(index+1) == 'o'){
                    if(code.charAt(index+2) == 'r'){
                        if(code.charAt(index+3) == '('){
                            
                            found = true;
                        }
                        skipIndex = index + 4;
                    }
                    skipIndex = index + 3;
                }
                skipIndex = index + 2;
            }
            skipIndex = index+1;
        
        
        return found;
    }
    
    
    @Override
    public int getSkipToIndex(){
        return skipIndex;
    }
    
    @Override
    public void updateIndex(){
        index = index + 5;
    }
    
   
}
