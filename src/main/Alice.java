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
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Jackal
 */
public class Alice {
    public Alice( BigInteger _m0, BigInteger _m1 ) {
        m = new ArrayList<>();
        x = new ArrayList<>();
        
        m.add( _m0 );
        m.add( _m1 );
        
        BigInteger p = BigInteger.probablePrime( 50, new Random() );
        BigInteger q = BigInteger.probablePrime( 50, new Random() );
        while ( q.equals( p ) ) {
            q = BigInteger.probablePrime( 50, new Random() );
        }
        
        N = p.multiply( q );
        
        BigInteger phi = p.add( BigInteger.valueOf( -1 ) ).multiply( q.add( BigInteger.valueOf( -1 ) ) );
        
        e = N;
        while ( e.compareTo( phi ) >= 0 || phi.mod( e ).equals( BigInteger.valueOf( 0 ) ) ) {
            e = BigInteger.probablePrime( 25, new Random() );
        }
        d = e.modInverse( phi );
    }
    
    public void generateRandomValues() {
        x.clear();
        x.add( new BigInteger( 20, new Random() ) );
        x.add( new BigInteger( 20, new Random() ) );
        while ( x.get( 1 ).equals( x.get( 0 ) ) ) {
            x.set( 1, new BigInteger( 20, new Random() ) );
        }
    }
    
    public List<BigInteger> getMChanged( BigInteger v ) {
        List<BigInteger> result = new ArrayList<>();
        result.add( m.get( 0 ).add( v.add( x.get( 0 ).multiply( BigInteger.valueOf( -1 ) ) ).modPow( d, N ) ) );
        result.add( m.get( 1 ).add( v.add( x.get( 1 ).multiply( BigInteger.valueOf( -1 ) ) ).modPow( d, N ) ) );
        return result;
    }
    
    public List<BigInteger> getX() {
        return x;
    }
    
    public BigInteger encrypt( BigInteger m ) {
        return m.modPow( e, N );
    }
    
    public BigInteger decrypt( BigInteger m ) {
        return m.modPow( d, N );
    }
    
    public BigInteger getE() {
        return e;
    }
    
    public BigInteger getN() {
        return N;
    }
    
    private List<BigInteger> m;
    private BigInteger e, d, N;
    private List<BigInteger> x;
}
