/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucundinamarca.letras;

import java.util.Scanner;

/**
 * Esta clase dice cual es la primera letra sin repetir en una palabra
 * @author Alisson Celeita
 * @param palabra Es la palabra digitada por el usuario.
 * @param repetido Es el caracter sin repetir
 */
public class Palabra {
    private String palabra;
    private char repetido=' ';
    
    /**
     * En el constructor se le pide la palabra al usuario.
     */
    
    public Palabra(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite una palabra");
        palabra= entrada.nextLine();
        palabra=palabra.toLowerCase();
        evaluacion(palabra);
    }
    /**
     * Este metodo evalua cada una de las letras de la palabra y dependiendo el caso direcciona a los otros metodos.
     * @param palabra 
     */
    
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
    
    /**
     * Este metodo realiza la primera validacion para saber si una letra se esta repitiendo
     * @param rango es el indice para saber que letra es;
     * @return Retorna la letra que no se este repitiendo
     * El caracter - es para indicar que las letras se repiten
     */
    
    private char sinRepetir(int rango){
        int contador=0;
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
    /**
     * Este metodo realiza la segunda validacion para saber que letra no se esta repitiendo
     * @param rango es el indice para saber que letra es;
     * @return Retorna la letra que no se este repitiendo
     * El caracter - es para indicar que las letras se repiten
     */
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
    
    /**
     * Este metodo imprime la letra que no se este repitiendo
     * @param letra recibe la letra que no se esta repitiendo
     */
    
    private void impresion(char letra){
        System.out.println("Primera letra sin repetir => "+letra);
    }
    
    public static void main (String [] args){
        Palabra palabra= new Palabra();
    }
        
}
