/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author jesusjimsa
 */
public class Main {
	public static void main(String[] args){
		Napakalaki game = Napakalaki.getInstance();
		NapakalakiView napakalakiView = new NapakalakiView();
		PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
		
		Dice.createInstance(napakalakiView);
		ArrayList<String> names = new ArrayList();
		
		names = namesCapture.getNames();
		game.initGame(names);
		napakalakiView.setNapakalaki(game);
		
		napakalakiView.showView();
		napakalakiView.setVisible(true);
	}
}
