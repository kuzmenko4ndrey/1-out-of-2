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
        String M0 = "56168643465843235168468261354321654";
        String M1 = "638435343651338435667815638464964987614348";
        Alice a = new Alice( new BigInteger( M0 ), new BigInteger( M1 ) );
        a.generateRandomValues();
        
        Bob b0 = new Bob( 0 );
        Bob b1 = new Bob( 1 );
        
        b0.setPublicKeys( a.getE(), a.getN() );
        b1.setPublicKeys( a.getE(), a.getN() );
        
        String m0 = b0.showNeededM( a.getMChanged( b0.calcV( a.getX() ) ) ).toString();
        String m1 = b1.showNeededM( a.getMChanged( b1.calcV( a.getX() ) ) ).toString();
        System.out.println( m0 + ' ' + m0.equals( M0 ) );
        System.out.println( m1 + ' ' + m1.equals( M1 ) );
    }
    
}
