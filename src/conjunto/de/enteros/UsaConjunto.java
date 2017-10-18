/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto.de.enteros;

/**
 *
 * @author Cris
 */
public class UsaConjunto {
    public static void main(String[] args) {
        ConjuntoDeEnteros prueba = new ConjuntoDeEnteros(new int[]{1,2,1,3,4,5,6,7,8,9,10,11}); 
        
        for (int i = 0; i < prueba.elementos().length; i++) {
            System.out.println(prueba.elementos()[i]);
        }
    }
    
}
