import GameEngine.Display;

import java.io.IOException;

public class JumpRunMain {

    public static void main(String[] args) throws IOException {
       Display d = new Display();
       		
           d.OpenDisplay();
        while(!d.CloseRequested) {
        	
        
        	
            d.updateDisplay();
            try {
				Thread.sleep(1000/20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
        
     
    }
}

