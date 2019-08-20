/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersimulacion;
import java.util.Random;

/**
 *
 * @author WINDOWS 10
 */
public class MRechazo {
    private double R1,R2;
    private double x,M;
    /*funcion de la distribucion
    f(x)=20x*(1-x)^3
        a=20
        b=3
    */
    public MRechazo(){
        Random rnd = new Random();
        R1=rnd.nextDouble();
        R2=rnd.nextDouble();
    }
    public String calcular(){
        String res=" ";
        definirX(0,1);
        calcularM();
        double pru = 20*R1*(double)Math.pow((1-R1),3)/M;
        System.out.println(R1+"   "+R2+"    "+pru);
        if(R2<=pru){
            res= "variable aceptada";
        }
        else{
            res= "variable no aceptada";
        }
        return res;
    }
    public void definirX(int a, int b){
        x=a+(b-a)*R1;
    }
    public void calcularM(){
        M=135/64;
    }
    public void newRandom(){
        Random rnd = new Random();
        R1=rnd.nextDouble();
        R2=rnd.nextDouble();
    }
    public double getR1(){
        return R1;
    }
    public double getR2(){
        return R2;
    }
    public double getX(){
        return x;
    }
    public double getM(){
        return M;
    }
}
