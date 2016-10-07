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
    
    public static ArrayList<Monster> monstruos = new ArrayList()
    {
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 1, 1);
        Prize prize = new Prize(1,1);
        monstruos.add(new Monster("Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, 1, 1);
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
        
       
    }

    
}
