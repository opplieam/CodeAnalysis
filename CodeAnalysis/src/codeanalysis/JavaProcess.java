/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codeanalysis;

import java.util.EmptyStackException;
import java.util.Observable;


import java.util.Stack;


/**
 *
 * @author Opponent
 */
public abstract class JavaProcess extends Observable{
    
    // code can be use in subclass
    protected String code;
    
    // index can be use in subclass
    protected int index;
    
    // Both variable is counter
    private int totalCount;
    private int totalNestedCount;
    
    private String word;
    
    private int bracketIndex;
    
    // stack can be use only this class
    private Stack<Integer> stack;
    
    
    
    public JavaProcess(){
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    public void initStack(){
        stack = new Stack<>();
    }
    
    public void resetVariable(){
        totalCount = 0;
        totalNestedCount = 0;
        index = 0;
        stack.clear();
    }
    
    public void processCode(int startIndex) throws InterruptedException{
        
        LockStatement lockState = new LockStatement();
        
        
        for(index = startIndex; index < code.length();){
            lockState.lock();
            word = "Pointer at index " + index;
            setChanged();
            notifyObservers(this);
            
            if(code.charAt(index) == '}'){
                try{
                     word = "Found } at index : " + index;
                     setChanged();
                     notifyObservers(this);
                     stack.pop();
                     word = " - {";
                     setChanged();
                     notifyObservers(this);
                     
                }catch(EmptyStackException e){
                     word = "Empty Stack";
                     setChanged();
                     notifyObservers(this);
                }
            }
            lockState.unlock();
            
            if(isFind()){
                lockState.lock();
                
                totalCount++;
                word = "Found for at index " + index;
                setChanged();
                notifyObservers(this);
                
                if(!stack.empty()){
                    totalNestedCount++;
                }
                updateIndex();
                index = findBracketIndex(index);
                
                word = "Found { at index " + index;
                setChanged();
                notifyObservers(this);
                
                
                stack.push(index);
                word = "{ ";
                setChanged();
                notifyObservers(this);
                
                lockState.unlock();
                
                lockState.lock();
                while(!stack.empty()){
                    processCode(index);
                }
                lockState.unlock();
                
            }
            index = getSkipToIndex();
            
            
        }
        word = "done";
        setChanged();
        notifyObservers(this);
    }
    
    public int findBracketIndex(int startIndex){
        
        for(int i = startIndex; i < code.length(); i++){
            if(code.charAt(i) == '{'){
                bracketIndex = i;
                break;
            }
        }
        
        return bracketIndex;
        
    }
    
    
    
    public int getTotalCount(){
        return totalCount;
    }
    
    
    
    public int getTotalNestedCount(){
        return totalNestedCount;
    }
    
    public String getWord(){
        return word;
    }
    
    public abstract boolean isFind();
    
    
    public abstract void updateIndex();
    
    
    public abstract int getSkipToIndex();
    
   
    
}
