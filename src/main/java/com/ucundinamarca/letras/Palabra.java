/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucundinamarca.letras;

import java.util.Scanner;

/**
 *
 * @author Alisson Celeita
 */
public class Palabra {
    private String palabra;
    private char repetido=' ';
    
    public Palabra(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite una palabra");
        palabra= entrada.nextLine();
        palabra=palabra.toLowerCase();
        evaluacion(palabra);
    }
    
    private void evaluacion(String palabra){
        for(int i=0;i<palabra.length();i++){
            System.out.println("Leyendo => "+palabra.charAt(i));
            if(i==0){
                repetido=palabra.charAt(i);
                impresion(repetido);
            }else{
                if(repetido==palabra.charAt(i)){
                   repetido=sinRepetir(i);
                } 
                if(repetido=='-'){
                    repetido=validacion(i);
                    if(repetido=='-'){
                        System.out.println("Las letras se repiten");
                    }else{
                       impresion(repetido); 
                    }
                }else{
                    impresion(repetido);
                }
            }
        }
    }
    
    private char sinRepetir(int rango){
        int contador=0;
        char aux=' ';
        for(int i=0; i<rango;i++){
            if(palabra.charAt(i)!=repetido){
                contador=0;
                for(int j=0;j<rango;j++){
                    if(palabra.charAt(i)==palabra.charAt(j)&&i!=j){
                        contador++;
                    }   
                }
                if(contador==0){
                    return palabra.charAt(i);
                } 
            }
        }
        return'-';
    }
    
    private char validacion(int rango){
        int contador=0;
        for(int i=0; i<rango;i++){
            if(palabra.charAt(i)==palabra.charAt(rango)&&i!=rango){
                contador++;
            }
        }
        if(contador==0){
            return palabra.charAt(rango);
        }
        return '-';
    }
    
    private void impresion(char letra){
        System.out.println("Primera letra sin repetir => "+letra);
    }
    
    public static void main (String [] args){
        Palabra palabra= new Palabra();
    }
        
}
