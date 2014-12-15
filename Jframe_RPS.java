/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jframe_rps;

/**
 *
 * @author control
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Jframe_RPS implements ActionListener {

    JLabel jlab, jlabWLT, WinnerIs;
    int wins = 0, lossess = 0, ties = 0;

    Jframe_RPS()
    {
        ImageIcon rock = new ImageIcon("rock.gif");
        ImageIcon paper = new ImageIcon("paper.gif");
        ImageIcon scissors = new ImageIcon("sissors.gif");
        
        JFrame jfrm = new JFrame("Rock Paper Sissors Game!");
        
        jfrm.setLayout(new GridLayout(9,3));
        
        jfrm.setSize(400,400);
        
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        WinnerIs = new JLabel(" The Winner is: ");
        jlab = new JLabel(" Computer chosess ");
        jlabWLT = new JLabel("Wins      Lossess     Ties");
        
        JButton Rocks = new JButton("Rock", rock);
        JButton Papers = new JButton("Paper", paper);
        JButton Sissors = new JButton("Scissors", scissors);
        
        Rocks.addActionListener(this);
        Papers.addActionListener(this);
        Sissors.addActionListener(this);
        
        jfrm.add(Rocks);
        jfrm.add(Papers);
        jfrm.add(Sissors);
        
        jfrm.add(jlab);
        jfrm.add(WinnerIs);
        jfrm.add(jlabWLT);
        
        
        jfrm.setVisible(true);
    }
        
 int randomRange(int min, int max)
{
 int range = (max-min)+1;
 return (int)(Math.random() * range)+min;
}

String comp_move(int random)
{
    switch(random){
        case 1:
            return "Rock";
        case 2:
            return "Paper";
        case 3:
            return "Scissors";   
    }
    return null;
}

String get_winner(String Player, String cpu)
{
         if(Player.equals("Paper") && cpu.equals("Rock")) {return "Player";}
    else if(Player.equals("Scissors") && cpu.equals("Paper")) {return "Player";}
    else if(Player.equals("Rock") && cpu.equals("Scissors")) {return "Player";}
    else if(Player.equals("Paper") && cpu.equals("Scissors")) {return "CPU";}
    else if(Player.equals("Scissors") && cpu.equals("Rock")) {return "CPU";}
    else if(Player.equals("Rock") && cpu.equals("Paper")) {return "CPU";}
    else{return "Tie";}

}

void score(String winners)
{
     if(winners.equals("Player"))
                 {
                 wins++;
                 jlabWLT.setText("Wins   " +wins +"   Lossess  " +lossess+ " Ties " +ties);
                 }
                 else if(winners.equals("CPU"))
                 {
                 lossess++;
                 jlabWLT.setText("Wins " +wins +" Lossess " +lossess+ " Ties " +ties);    
                 }
                 else
                 {
                 ties++;    
                 jlabWLT.setText("Wins " +wins +" Lossess " +lossess+ " Ties " +ties);   
                 }
    
}
      
    
     public void actionPerformed(ActionEvent ae)
     {
         //caputer the code here
         switch(ae.getActionCommand())
         {
             case "Rock":                 
                 String cpu = comp_move(randomRange(1,3));
                 jlab.setText("The computer picks         " + cpu);
                 String winners = get_winner("Rock", cpu);
                 score(winners);
                  if(!winners.equals("Tie"))
                 {
                  WinnerIs.setText(" The Winner is: "+ winners);   
                 }
                 else{
                   WinnerIs.setText(" The game was a "+ winners);  
                 }
                 
                 break;
                 
             case "Paper":
                 
                 String cpu1 = comp_move(randomRange(1,3));
                 jlab.setText("The computer picks         " + cpu1);
                 String winners1 = get_winner("Paper", cpu1);
                 score(winners1);
                 if(!winners1.equals("Tie"))
                 {
                  WinnerIs.setText(" The Winner is: "+ winners1);   
                 }
                 else{
                   WinnerIs.setText(" The game was a "+ winners1);  
                 }
                 
                 break;
             case "Scissors":
                 String cpu2 = comp_move(randomRange(1,3));
                 jlab.setText("The computer picks          " + cpu2);
                 String winners2 = get_winner("Scissors", cpu2);
                 score(winners2);
                 if(!winners2.equals("Tie"))
                 {
                  WinnerIs.setText(" The Winner is: "+ winners2);   
                 }
                 else{
                   WinnerIs.setText(" The game was a "+ winners2);  
                 }
                 
                 
                 break;
         }
             
                     
         
         
         
     }
        
   
           
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Jframe_RPS();
            }
        });
    }
    
}
