/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigInteger;
import java.io.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Jackal
 */
public class Bob {
    public Bob( int _b ) {
        b = _b;
        if ( b != 0 && b != 1 ) {
            b = 1;
        }
        k = new BigInteger( 20, new Random() );
    }
    
    public void setPublicKeys( BigInteger _e, BigInteger _N ) {
        e = _e;
        N = _N;
    }
    
    public BigInteger calcV( List<BigInteger> x ) {


        BigInteger powedK = k.modPow( e, N );
        return x.get( b ).add( powedK ).mod( N );
    }
    
    public BigInteger showNeededM( List<BigInteger> changedM ) {
        return changedM.get( b ).add( k.multiply( BigInteger.valueOf( -1 ) ) );
    }
    
    private int b;
    private BigInteger k, N, e;
}
