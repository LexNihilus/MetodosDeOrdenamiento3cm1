/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Burbuja;

import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import java.util.Random;

/**
 *
 * @author Lex VENUS
 */
public class Burbuja {
    void Burbuja()
    {
    }
    public long BurbujaNormal(int a[])//Recibe el arreglo de enteros a ordenar.
    {
       long tiempoI=0, tiempoF=0, tiempoT=0;
       tiempoI=System.currentTimeMillis();
       final int n=a.length;//n controla el numero de iteraciones del ordenamiento.
        for(int i=0;i<n-1;i++)//Comienza el ordenamiento
        {
            for(int j=0;j<n-1;j++)
            {
                if (a[j]>a[j+1])//Aqui definimos el tipo de ordenamiento (mayor-menor o viceversa).
                {
                    int tmp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=tmp;
                }
            }
        }//Termina el ordenamiento.
        tiempoF=System.currentTimeMillis();
        tiempoT=tiempoF-tiempoI;
        return tiempoT;
    }
    public long BurbujaOptimizado(int a[])//Recibe el arreglo de enteros a ordear
    {
        long tiempoI, tiempoF, tiempoT;
        tiempoI=System.currentTimeMillis();
        final int n=a.length;//n controla el numero de iteraciones del ordenamiento.
                for(int i=n-1;i>0;i--){//Comienza el ordenamiento.
                        for(int j=0;j<i;j++){
                                if(a[j]>a[j+1]){//Aqui definimos el tipo de ordenamiento (mayor-menor o viceversa)
                                        int temp=a[j];
                                        a[j]=a[j+1];
                                        a[j+1]=temp;
                                }
                        }
                }//Termina el ordenamiento.
        tiempoF=System.currentTimeMillis();
        tiempoT=tiempoF-tiempoI;
        return tiempoT;
    }
    public int[] aleatorio(int a, int b)
    {
        Random aleatorios= new Random();
        int []vector=new int[a];
        for(int i=0; i<a; i++)
        {
            vector[i]=aleatorios.nextInt(b);
        }
        return vector;
    }
    public void generar()
    {
        Graficador grafica=new Graficador();
        ArrayList<Long> burbuja=new ArrayList<Long>();
        ArrayList<Long> burbujaOP=new ArrayList<Long>();
        int numero=100;
        for(int i=0; i<50;i++)
        {
            int[] vector1=aleatorio(numero, 100);
            int[] vector2=vector1.clone();
            burbuja.add(BurbujaNormal(vector1));
            burbujaOP.add(BurbujaOptimizado(vector2));
            numero=numero+300;
        }
        grafica.agregarp(burbuja, burbujaOP);
        grafica.trazar();
    }
}
