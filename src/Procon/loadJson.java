package Procon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.*;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;

public class loadJson  extends JPanel {
    public static int[][] lmap = new int[10][10];
    public static Teams[] team = new Teams[2];
    public static Agents[] agentTeamOne = new Agents[10];
    public static Agents[] agentTeamTwo = new Agents[10];


    public static void main(String[] args) {


        Gson gson = new Gson();

        try{

            BufferedReader br = new BufferedReader(new FileReader(new File("linkfile JSOn")));
            Map map = gson.fromJson(br,Map.class);
            team = map.getTeams();
            agentTeamOne = new Agents[team[0].getAgents().length];
            agentTeamTwo = new Agents[team[1].getAgents().length];
            for(int i = 0 ; i < team.length ; i++){
                for(int j = 0 ; j < team[i].getAgents().length; j++){
                    if(i == 0){
                        agentTeamOne[j] = team[i].getAgents()[j];
                    }else{
                        agentTeamTwo[j] = team[i].getAgents()[j];
                    }
                }
            }
           /* for(int i = 0 ; i < agentTeamTwo.length ; i++){
                if(agentTeamTwo[i] == null){
                    break;
                }
                System.out.println(agentTeamTwo[i].getX()+" "+agentTeamTwo[i].getY());
            }*/

            lmap = map.getPoints();
            for(int i = 0 ; i < lmap.length ; i++){
                for(int j = 0 ; j < lmap.length ; j++){
                    System.out.print(lmap[i][j]+"|");
                }
                System.out.println("");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new loadJson());
        f.setSize(lmap.length*50,lmap.length*50+50);
        f.setVisible(true);


    }
    public void paint(Graphics g1) {

        Graphics2D g = (Graphics2D) g1;
        // Paint the entire background using a GradientPaint.
        // The background color varies diagonally from deep red to pale blue
        int width = 0;
        int hegiht = 0;
        if(lmap.length >= 15 && lmap.length < 20){
            width = 45;
            hegiht = 40;
        } else if(lmap.length == 20){
            width = 45;
            hegiht = 35;
        }
        else{
            width = 50;
            hegiht = 50;
        }
        int count = 0;
        for(int i = 0 ; i < lmap.length ; i++){
            for(int j = 0 ; j < lmap.length ; j++){
                g.setColor(Color.lightGray);
                for(int z = 0 ; z < agentTeamOne.length ; z++){
                    if( agentTeamOne[z].getX() - 1 == i && agentTeamOne[z].getY()-1 == j){
                        g.setColor(Color.ORANGE);
                    }else if(agentTeamTwo[z].getX() - 1 == i && agentTeamTwo[z].getY()-1 == j){
                        g.setColor(Color.magenta);
                    }
                }

                g.fillRect(width*j,hegiht*i,width-2,hegiht-2);
                g.setColor(Color.blue);
                g.drawString(Integer.toString(lmap[i][j]),width*j+(width/2-4),hegiht*i+(hegiht/2+2));


            }
            System.out.println("");
            //count++;
        }




    }
}
