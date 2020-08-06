package GameEngine;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.synth.ColorType;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Display {
	private int count = 0;
	private int NFTB = 1;
	private int NFTE = 1;
    private boolean FP = false;
    private int VS = 0;
    private boolean paused = false;
    private JButton Play;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    private JButton level5;
    private JButton RandogeneratedLevel;
    private int fps = 1;
    private int c;
    private boolean InMenu = false;
public JFrame Window;
public Boolean CloseRequested = false;
private boolean isInMidAir = false;
JPanel content;
private int secondsElapsedSinceLastFrame = 0;
private String proformace;
   public int orginX = 0;
    public int orginY = 0;
    private String levelDirectory = "Resources/levels/";
    private String screenName = "menu";
    private  String[] B = new String[10000];
    private int[] X = new int[10000];
    private  int[] Y = new int[10000];
    private  int[] FTB = new int[10000];
    private  int[] FTE = new int[10000];
    
    private File GrassTexture = new File("Resources/textures/blocks/grass.png");
    private  File DirtTexture = new File("Resources/textures/blocks/dirt.png");
    private  File PlayerTexture = new File("Resources/textures/entitys/Player.png");
    private BufferedImage grass = ImageIO.read(GrassTexture);
    private BufferedImage dirt = ImageIO.read(DirtTexture);
    private BufferedImage Player = ImageIO.read(PlayerTexture);
    private static boolean[] TFG = new boolean[10000];
    private static boolean[] TFD = new boolean[10000];
    public boolean gameOver = false;
    private String levelNumber = "";
    public Display() throws IOException {
    
    }

    public void OpenDisplay(){
Window = new JFrame("JumpRun - beta1");
Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

content = new JPanel(){
	

    public void paint(Graphics g) {
    	
    	if(screenName.equals("level")) {
    		
    		if(orginY > 0 & !FP){
    	    	
    		
    			   
    	        VS--;
    	         }
    		 if(FP){
    			
    	        VS--;
    	      
    	    }

    		orginY +=VS; 
    		
    		if(orginY == 0) {
    			
        for(int i = 0; i < FTB.length & orginY == 0; i++) {
        	
            if (750-37> orginX + FTB[i] & 750 < orginX + FTE[i]  ) {
            
                FP = true;
                
               
            
        }}}
      
    		
        g.drawImage(Player, 750, 150, Window);
        
       
        if(orginY == 0 & !FP){
        

            VS = 0;
           
            isInMidAir = false;
          
            	orginY = 0;
             }
       

    for(int i = 0; i < B.length; i++){
	

            if(TFG[i]) {
            	
                g.drawImage(grass,orginX + X[i],orginY + Y[i], Window);
                

            }else if (TFD[i]){
            	
                g.drawImage(dirt,orginX + X[i], orginY + Y[i], Window);
               
            }
    }
    
        

	
	 
	if(!FP) {
		
		orginX-=20;
		
	}
	


if(orginX < -29000) {
	
	g.setFont(new Font(Font.SERIF, Font.PLAIN, 200));
	
	g.drawString("completed level", 150, 500);
	
	gameOver = true;
	  FTB = new int[10000];
	    FTE = new int[10000];
}
if(orginY < -200) {
	
	g.setFont(new Font(Font.SERIF, Font.PLAIN, 200));
	
	g.drawString("failed level", 350, 500);
	  FTB = new int[10000];
	    FTE = new int[10000];
	
	gameOver = true;
	
	
}}
    	
    	g.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
    	
    	g.drawString("Controls: space -> jump | escape -> return to main menu | p -> pause/unpause(if you press escape and the main menu does not return, unpause your game ", 50, 50);
    }
    
    
};
content.setPreferredSize(new Dimension(1500, 750));
Window.getContentPane().add(content);
Window.pack();
Window.setVisible(true);
Window.setResizable(false);
Window.setBackground(new Color(135, 206,235));
Play = new JButton("Play");
Play.setSize(250, 75);
Play.setLocation(625, 100);
Play.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Play) {
			screenName = "PlayMenu";
			
			
		}
		
	}
});
level1 = new JButton("Level 1");
level1.setSize(250, 75);
level1.setLocation(625, 100);
level1.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == level1) {
			levelNumber = "1";
			loadLevel();
			screenName = "level";
			
			
			
		}
		
	}
});
level2 = new JButton("Level 2");
level2.setSize(250, 75);
level2.setLocation(625, 200);
level2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == level2) {
			screenName = "level";
			levelNumber = "2";
			loadLevel();
			
		}
		
	}
});
level3 = new JButton("Level 3");
level3.setSize(250, 75);
level3.setLocation(625, 300);
level3.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == level3) {
			screenName = "level";
			levelNumber = "3";
			loadLevel();
			
		}
		
	}
});
level4 = new JButton("Level 4");
level4.setSize(250, 75);
level4.setLocation(625, 400);
level4.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == level4) {
			screenName = "level";
			levelNumber = "4";
			loadLevel();
			
		}
		
	}
});
level5 = new JButton("Level 5");
level5.setSize(250, 75);
level5.setLocation(625, 500);
level5.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == level5) {
			screenName = "level";
			levelNumber = "5";
			loadLevel();
			
		}
		
	}
});
RandogeneratedLevel = new JButton("Random Generated level");
RandogeneratedLevel.setSize(250, 75);
RandogeneratedLevel.setLocation(625, 600);
RandogeneratedLevel.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GenerateRandomLevel();
		if(e.getSource() == RandogeneratedLevel) {
			screenName = "level";
			levelNumber = "";
			
			
		}
		
	}
});
        Window.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                CloseRequested = true;
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

        });
        Window.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            
                if(!isInMidAir & !FP ) {
                	
                	isInMidAir = true;
                    VS += 5;
                    
                }
            }
           
            if(e.getKeyCode() == KeyEvent.VK_P) {
            	if(paused == false) {
            		paused = true;
            	}else if(paused == true){   
            		paused = false;
            	}
            	}
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            	screenName = "menu";
            	gameOver = false;
            	orginX = 0;
            	orginY = 0;
            	FP = false;
            	isInMidAir = false;
            	VS = 0;
            }
            	
            
            
            
        }}
        
        		);
       Play.setFocusable(false);
       level1.setFocusable(false);
       level2.setFocusable(false);
       level3.setFocusable(false);
       level4.setFocusable(false);
       level5.setFocusable(false);
       RandogeneratedLevel.setFocusable(false);
}

    public void updateDisplay(){
    	
    	long t = System.currentTimeMillis();
    	
      
        
        
    	

    	if(!paused & !gameOver) {
        this.Window.repaint();
    	}
    
    	if(screenName.equals("menu")){
    		Play.setVisible(true);
    		Window.add(Play);
    	}else {
    		Play.setVisible(false);
    		Window.remove(Play);
    	}
    	if(screenName.equals("PlayMenu")){
    		level1.setVisible(true);
    		level2.setVisible(true);
    		level3.setVisible(true);
    		level4.setVisible(true);
    		level5.setVisible(true);
    		
    		Window.add(level1);
    		Window.add(level2);
    		Window.add(level3);
    		Window.add(level4);
    		Window.add(level5);
    		Window.add(RandogeneratedLevel);
    	}else {
    		level1.setVisible(false);
    		level2.setVisible(false);
    		level3.setVisible(false);
    		level4.setVisible(false);
    		level5.setVisible(false);
    		
    		Window.remove(level1);
    		Window.remove(level2);
    		Window.remove(level3);
    		Window.remove(level4);
    		Window.remove(level5);
    		Window.remove(RandogeneratedLevel);
    	}

    	 secondsElapsedSinceLastFrame = (int) (t - System.currentTimeMillis());
   
    	 
    	
    }

public void loadLevel(){
    File LB = new File(levelDirectory + "level" + levelNumber + "/Level.block");
    File LX = new File(levelDirectory + "level"  + levelNumber + "/Level.x");
    File LY = new File(levelDirectory + "level"  + levelNumber + "/Level.y");
    File FB = new File(levelDirectory + "level"  + levelNumber + "/Level.ftb");
    File FE = new File(levelDirectory + "level"  + levelNumber + "/Level.fte");
    Scanner FR1 = null;
    try {
        FR1 = new Scanner(LB);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Scanner FR2 = null;
    try {
        FR2 = new Scanner(LX);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Scanner FR3 = null;
    try {
        FR3 = new Scanner(LY);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Scanner FR4 = null;
    try {
        FR4 = new Scanner(FB);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    Scanner FR5 = null;
    try {
        FR5 = new Scanner(FE);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    for(int x = 0; FR1.hasNextLine();){

        B[x] = FR1.nextLine();
        x++;
    }
    for(int x = 0; FR2.hasNextLine(); ){
        X[x] = Integer.parseInt(FR2.nextLine());
        x++;
    }
    for(int x = 0; FR3.hasNextLine(); ){
        Y[x] = Integer.parseInt(FR3.nextLine());
        x++;



    }
    for(int x = 0; FR4.hasNextLine(); ){
        FTB[x] = Integer.parseInt(FR4.nextLine());
        x++;



    }   for(int x = 0; FR5.hasNextLine(); ){
        FTE[x] = Integer.parseInt(FR5.nextLine());
        x++;



    }
    
    String g = "grass";
    String d = "dirt";
for(int i = 0; i < B.length; ){
    String block = B[i];
   if(g.equals(block)) {
       TFG[i] = true;
   }else  if(d.equals(block)) {
       TFD[i] = true;
   }
i++;
}
}
private void GenerateRandomLevel() {
	int x = 0;
	int y = 225;
	int i = 0;
	int max = (int) (Math.random() * (20 - 1 + 1) + 1);
	while (x < 30000) {
        int c = (int) (Math.random() * (max - 1 + 1) + 1);
        if (y == 225) {
            B[i] = "grass";
        } else if (y > 225) {
        	B[i] = "dirt";
        }
        X[i] = x;
        Y[i] = y;
        if (y < 750) {
            y += 75;
        } else if (y == 750 && c == 1 && x>= 1000) {
        	FTB[i] = x + 37;
         FTE[i]  = x +225 - 37;
            y = 225;
            x += 225;
        } else if (y == 750) {
            y = 225;
            x += 75;
          
    	
    	   
    	
        }
        String g = "grass";
	    String d = "dirt";
        String block = B[i];
 	   if(g.equals(block)) {
 	       TFG[i] = true;
 	   }else  if(d.equals(block)) {
 	       TFD[i] = true;
 	   }

i++;

    }
	   
}
}
  


