import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

/* 
<applet code="Surprised.class" width="300" height="300">  
</applet>  
*/   

public class Surprised extends Applet implements ActionListener,KeyListener
{
   public int x[]={85,180,200,332,247,315,178,325,262};
   public int temp_x[]={85,180,200,332,247,315,178,325,262};
   public int y[]={150,250,275,275,395,250,220,220,340};
   public int temp_y[]={150,250,275,275,395,250,220,220,340};
   public int w[]={375,55,20,20,60,55,52,50,30};
   public int h[]={375,75,30,30,85,75,62,75,30};
   public int inc = 20,i;
   
   public Button up,down,left,right;
  
   public void init()
   { 
      addKeyListener(this);
      setFocusable(true); 
      
      up = new Button("Up");
      down = new Button("Down");
      left = new Button("Left");
      right = new Button("Right");   
      
      up.addActionListener(this);
      down.addActionListener(this);
      left.addActionListener(this);
      right.addActionListener(this);
      
      add(up);
      add(down);
      add(left);
      add(right);

      up.setFocusable(false);
      down.setFocusable(false);
      left.setFocusable(false);
      right.setFocusable(false);
   }
   
   public void keyPressed(KeyEvent ke)
   {
      if (ke.getKeyCode() == ke.VK_UP)
      {  
         if(y[2] > y[1] + 10)
         {
            y[2] = y[2] - 18;
            y[3] = y[3] - 18;
         }  
      }
      else if (ke.getKeyCode() == ke.VK_DOWN)
      {
         if(y[1] > y[2] - 30)
         {
            y[2] = y[2] + 15;
            y[3] = y[3] + 15;
         }  
      }
      else if (ke.getKeyCode() == ke.VK_LEFT)
      {  
         if(x[2] > x[1] + 10)
         {
            x[2] = x[2] - 15;
            x[3] = x[3] - 15;
         }  
      }
      else if (ke.getKeyCode() == ke.VK_RIGHT)
      {  
         if(x[1] > x[2] - 22)
         {
            x[2] = x[2] + 12;
            x[3] = x[3] + 12;
         }
      }
      repaint();  
   }

   public void keyReleased(KeyEvent ke)
   {
      if (ke.getKeyCode() == ke.VK_UP)
      {  
         y[2] = y[2] + 18;
         y[3] = y[3] + 18;
      }
      else if (ke.getKeyCode() == ke.VK_DOWN)
      {
         y[2] = y[2] - 15; 
         y[3] = y[3] - 15;
      }
      else if (ke.getKeyCode() == ke.VK_LEFT)
      {  
         x[2] = x[2] + 15;
         x[3] = x[3] + 15;
      }
      else if (ke.getKeyCode() == ke.VK_RIGHT)
      {  
         x[2] = x[2] - 12;
         x[3] = x[3] - 12;
      }
      repaint();
   }

   public void keyTyped(KeyEvent ke)
   {

   }  

   public void actionPerformed(ActionEvent ae)
   {
      if (ae.getSource() == up)
      {  
         up.setBackground(Color.cyan);
         down.setBackground(Color.lightGray);
         left.setBackground(Color.lightGray);
         right.setBackground(Color.lightGray);
         moveUp();
      }
      else if (ae.getSource() == down)
      {
         down.setBackground(Color.cyan);
         up.setBackground(Color.lightGray);
         left.setBackground(Color.lightGray);
         right.setBackground(Color.lightGray);
         moveDown();
      }
      else if (ae.getSource() == left)
      {  
         left.setBackground(Color.cyan);
         up.setBackground(Color.lightGray);
         down.setBackground(Color.lightGray);
         right.setBackground(Color.lightGray);
         moveLeft();
      }
      else if (ae.getSource() == right)
      {  
         right.setBackground(Color.cyan);
         up.setBackground(Color.lightGray);
         down.setBackground(Color.lightGray);
         left.setBackground(Color.lightGray);
         moveRight();
      }
   }

   public void paint(Graphics g)
   {
      g.setColor(Color.yellow);
      g.fillOval(x[0],y[0],w[0],h[0]);
      g.setColor(Color.white);
      g.fillOval(x[1],y[1],w[1],h[1]);
      g.fillOval(x[5],y[5],w[5],h[5]);
      g.setColor(Color.black);
      g.fillOval(x[2],y[2],w[2],h[2]);
      g.fillOval(x[3],y[3],w[3],h[3]);
      g.drawArc(x[6],y[6],w[6],h[6],10,120);
      g.drawArc(x[7],y[7],w[7],h[7],50,110);
      g.setColor(Color.red);
      g.fillOval(x[4],y[4],w[4],h[4]);
      g.setColor(Color.pink);
      g.fillOval(x[8],y[8],w[8],h[8]); 
   }

   public void moveUp()
   {
      if(y[0]>-345)
      {  
         for(i=0;i<9;i++)
         {  
            y[i] = y[i] - inc;
            repaint();
         }
      }
      else
      {   
         for(i=0;i<9;i++)
         {
            y[i] = temp_y[i] + 800;  
            y[i] = y[i] - inc;
            repaint();
         }  
      }   
   }
   
   public void moveDown()
   {
      if(y[0]<925)
      {
         for(i=0;i<9;i++)
         {  
            y[i] = y[i] + inc;
            repaint();
         }
      }
      else
      {  
         for(i=0;i<9;i++)
         {
            y[i] = temp_y[i] - 530;  
            y[i] = y[i] + inc;
            repaint();
         }
      } 
   }

   public void moveLeft()
   {
      if(x[0]>-355)
      {
         for(i=0;i<9;i++)
         {  
            x[i] = x[i] - inc;
            repaint();
         }
      }
      else
      {
         for(i=0;i<9;i++)
         {
            x[i] = temp_x[i] + 1830; 
            x[i] = x[i] - inc;
            repaint();
         }
      }
   }
   
   public void moveRight()
   {
      if(x[0]<1880)
      {
         for(i=0;i<9;i++)
         {  
            x[i] = x[i] + inc;
            repaint();
         }
      }
      else
      {
         for(i=0;i<9;i++)
         { 
            x[i] = temp_x[i] - 460; 
            x[i] = x[i] + inc;
            repaint();
         }  
      }
   }  
}