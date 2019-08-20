/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersimulacion;

/**
 *
 * @author user1
 */
import net.objecthunter.exp4j.*;
public class composicion{
    GeneradorCongruencial generador;
    float rand1,rand2;
    expresion lista[];
    Expression e;
    int i;
   composicion(){
    
    lista=new expresion[2];
    
    i=0;
    
  
   }
   void agregar(String operacion,double area){
     lista[i] = new expresion(new ExpressionBuilder(operacion)
    .variables("R")
    .build(),area);
    i++;
    //.setVariable("x", 2.3)
    //.setVariable("y", 3.14);
    //double result = e.evaluate();
       
       
    }
    String evaluar(float seed, float a, float c, float m,int iteraciones){
         generador=new GeneradorCongruencial(seed, a,c, m);
         int x=0;
         double result=0;
         String resultado="";
         for(int s=0;s<=iteraciones;s++){
         rand1=generador.nextRandom();
          rand2=generador.nextRandom();
          i=2;
          x=0;
         while(i>0){
           
           if(rand1<lista[x].area){
             lista[x].e.setVariable("R",rand2);
             result=lista[x].e.evaluate();
             resultado=resultado+" , "+result;
            }
            i--;
            x++;
        
         
         }
         }
        return resultado;
   
   
     }
}
class expresion{
    Expression e;
    
    double area;
    expresion(Expression e,double area){
        this.e=e;
        this.area=area;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author 
 */
class GeneradorCongruencial{
    /*
X0 = la semilla (X0 > 0)
a= el multiplicador (a>0)
c= constante aditiva (c>0)
m= el modulo (m>X0  , m>a y m>c)
    */
    private float seed;//semilla
    private float a;//multiplicador
    private float c;//constante aditiva
    private float m;//modulo
    private float ultimoRandom;
    private float ultimaSemilla;
    /*
Lineal:
N=m=2^g
a=1+4k
g y k relativamente primos
ri=Xi/m
g y k enteros positivos
    
    -----------
    Cuando se quiere construir un generador de números aleatorios para simular los
valores de una variable aleatoria, se deben elegir los parámetros de tal manera
que se garantice un periodo largo para que se puedan hacer todos los ensayos de
simulación, por lo tanto se deben tener en cuenta las siguientes condiciones:
• a debe ser un número impar, no divisible ni por 3 ni por 5.
• c usualmente puede ser cualquier constante, sin embargo, para asegurar
buenos resultados, se debe seleccionar a de tal forma que, a mod 8 = 5 para
una computadora binaria, o a mod 200 = 21 para computadora decimal.
• m debe ser el número entero más grande que la computadora acepte.
De acuerdo con Hull y Dobell, los mejores resultados para un generador
congruencial mixto en una computadora binaria son:
• c = 8*a±3
• a = cualquier entero
• X0 = Cualquier entero impar.
• M = 2b
 donde b >2 y que m sea aceptado por la computadora. 
    */

    public GeneradorCongruencial(float seed, float a, float c, float m) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }
    
       
    public float nextRandom(){
        ultimaSemilla = ( a*ultimaSemilla  + c) % m; //divido
        float rnd = ultimaSemilla/(m);
        return rnd;
    }
    
    
    

    //usar 2 contructores y 2 metodos para generar los numeros    
}