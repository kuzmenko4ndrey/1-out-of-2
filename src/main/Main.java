/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigInteger;

/**
 *
 * @author Jackal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alice a = new Alice( new BigInteger( "56168643" ), new BigInteger( "6384353436513" ) );
        a.generateRandomValues();
        
        Bob b0 = new Bob( 0 );
        Bob b1 = new Bob( 1 );
        
        b0.setPublicKeys( a.getE(), a.getN() );
        b1.setPublicKeys( a.getE(), a.getN() );
        
        System.out.println( b0.showNeededM( a.getMChanged( b0.calcV( a.getX() ) ) ).toString() );
        System.out.println( b1.showNeededM( a.getMChanged( b1.calcV( a.getX() ) ) ).toString() );
    }
    
}
