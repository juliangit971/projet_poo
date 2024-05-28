package com.theisland.utils;

import com.theisland.gameelements.BoardSlot;
import com.theisland.main.EnvironmentVariables;

import javax.swing.*;

public class MouveObjects {

    private EnvironmentVariables env;
    private JButton button;
    private Point firstClick;
    private Point secondClick;


    public MouveObjects(Point firstClick, Point secondClick){

        //this.button = button;
        //this.env = env;

        this.firstClick = firstClick;
        this.secondClick = secondClick;

        }

    public int ToMouveExplorer (){

        //Si le premier et le second clicks ont les même ordonnées
        if(firstClick.getY() == secondClick.getY()){

            if(firstClick.getX()-53 == secondClick.getX()){

                 JOptionPane.showMessageDialog(null, "Tu as clicker sur mon voisin de Gauche");
                return 1;
            }
            else if(firstClick.getX()+53 == secondClick.getX()){

                JOptionPane.showMessageDialog(null, "Tu as clicker sur mon voisin de Droite");
                return 1;

            }
        }
        else if(firstClick.getX()-26 == secondClick.getX() && firstClick.getY()+45 == secondClick.getY()){

            JOptionPane.showMessageDialog(null, "Tu as clicker sur mon voisin de Bas à Gauche");
            return 1;

        }else if(firstClick.getX()-26 == secondClick.getX() && firstClick.getY()-45 == secondClick.getY()){

            JOptionPane.showMessageDialog(null, "Tu as clicker sur mon voisin de Haut à Gauche");
            return 1;

        }else if(firstClick.getX()+27 == secondClick.getX() && firstClick.getY()-45 == secondClick.getY()){

            JOptionPane.showMessageDialog(null, "Tu as clicker sur mon voisin de Haut à Droite");
            return 1;

        }else if(firstClick.getX()+27 == secondClick.getX() && firstClick.getY()+45 == secondClick.getY()){

            JOptionPane.showMessageDialog(null, "Tu as clicker sur mon voisin de Bas à Droite");
            return 1;

        }
        return 0;
    }

    public void ToMouveBoat (){

    }


}
