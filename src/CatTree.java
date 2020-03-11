import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException; 


public class CatTree implements Iterable<CatInfo>{
    public CatNode root;
    
    public CatTree(CatInfo c) {
        this.root = new CatNode(c);
    }
    
    private CatTree(CatNode c) {
        this.root = c;
    }
    
    
    public void addCat(CatInfo c)
    {
        this.root = root.addCat(new CatNode(c));
    }
    
    public void removeCat(CatInfo c)
    {
        this.root = root.removeCat(c);
    }
    
    public int mostSenior()
    {
        return root.mostSenior();
    }
    
    public int fluffiest() {
        return root.fluffiest();
    }
    
    public CatInfo fluffiestFromMonth(int month) {
        return root.fluffiestFromMonth(month);
    }
    
    public int hiredFromMonths(int monthMin, int monthMax) {
        return root.hiredFromMonths(monthMin, monthMax);
    }
    
    public int[] costPlanning(int nbMonths) {
        return root.costPlanning(nbMonths);
    }
    
    
    
    public Iterator<CatInfo> iterator()
    {
        return new CatTreeIterator();
    }
    
    
    class CatNode {
        
        CatInfo data;
        CatNode senior;
        CatNode same;
        CatNode junior;
        
        public CatNode(CatInfo data) {
            this.data = data;
            this.senior = null;
            this.same = null;
            this.junior = null;
        }
        
        public String toString() {
            String result = this.data.toString() + "\n";
            if (this.senior != null) {
                result += "more senior " + this.data.toString() + " :\n";
                result += this.senior.toString();
            }
            if (this.same != null) {
                result += "same seniority " + this.data.toString() + " :\n";
                result += this.same.toString();
            }
            if (this.junior != null) {
                result += "more junior " + this.data.toString() + " :\n";
                result += this.junior.toString();
            }
            return result;
        }
        
        
        public CatNode addCat(CatNode c) {
            // ADD YOUR CODE HERE
        	
        	/*
        	 * Strategy: iterate, add by comparing months (if months ==, compare fur)
        	 * Edge Cases: The root is null; fur and months are equal
        	 */
        	
        	//if the root is null then the first cat added is the cat passed
        	if(root==null) return c;
        	
        	if(c.data.monthHired < root.data.monthHired) {
        		//we recurse through root.senior
        		
        	}else if(c.data.monthHired > root.data.monthHired) {
        		//we recurse through root.junior
        		
        	}else if(c.data.monthHired == root.data.monthHired){
        		//recurse through root.same
        		
        	}
        	
            return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
        
        
        public CatNode removeCat(CatInfo c) {
            // ADD YOUR CODE HERE
            return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
        
        
        public int mostSenior() {
            // ADD YOUR CODE HERE
            return -1; //CHANGE THIS
        }
        
        public int fluffiest() {
            // ADD YOUR CODE HERE
            return -1; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
        
        
        public int hiredFromMonths(int monthMin, int monthMax) {
            // ADD YOUR CODE HERE
            return -1; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
            
        }
        
        public CatInfo fluffiestFromMonth(int month) {
            // ADD YOUR CODE HERE
            return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
        
        public int[] costPlanning(int nbMonths) {
            // ADD YOUR CODE HERE
            return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
        
    }
    
    private class CatTreeIterator implements Iterator<CatInfo> {
        // HERE YOU CAN ADD THE FIELDS YOU NEED
        
        public CatTreeIterator() {
            //YOUR CODE GOES HERE
        }
        
        public CatInfo next(){
            //YOUR CODE GOES HERE
            return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
        
        public boolean hasNext() {
            //YOUR CODE GOES HERE
            return false; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
        }
    }
    
}

