/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author jaimefrias
 */
public class TestNapakalaki {
    public static void main(String[] args)
    {
        BadConsequence bc =  new BadConsequence("malrollo", 2, 3, 2);
        Prize prize = new Prize(2, 3);
        Monster monster = new Monster("Manolo", 2, bc, prize);

        String stringMonster = monster.toString();
        System.out.print(stringMonster);
    }

    
}
