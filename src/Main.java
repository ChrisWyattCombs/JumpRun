import GameEngine.Display;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       Display d = new Display();

           d.OpenDisplay();
        while(!d.CloseRequested) {
            d.updateDisplay();
        }
        }
    }


