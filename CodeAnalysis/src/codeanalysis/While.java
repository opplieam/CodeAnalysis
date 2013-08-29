/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;

/**
 *
 * @author Opponent
 */
public class While extends JavaProcess{
    
    private int skipIndex;
    
    public While(){
        super();
    }
    
    @Override
    public boolean isFind(){
        
        boolean found = false;
        
        if(code.charAt(index) == 'w'){
                if(code.charAt(index+1) == 'h'){
                    if(code.charAt(index+2) == 'i'){
                        if(code.charAt(index+3) == 'l'){
                            if(code.charAt(index+4) == 'e'){
                                if(code.charAt(index+5) == '('){
                                    found = true;
                                }
                                skipIndex = index + 6;
                            }
                            skipIndex = index +5;
                        }
                        skipIndex = index + 4;
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
        index = index + 7;
    }
    
   
}
