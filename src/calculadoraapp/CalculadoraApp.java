package calculadoraapp;

import java.util.Scanner;
import java.util.ArrayList;

/*
 * @author Marc
 */
public class CalculadoraApp {

    /**
     * @param args the command line arguments
     */

    private static double num1;
    private static double num2;
    //Las siguientes tres líneas son los dos números de la operación y el resultado en String.
    private static String num1S;
    private static String num2S;
    private static String resultadoS;
    private static String operador;
    private static double resultado;
    private static Scanner inScanner;
    private static ArrayList<String> listaTeclas;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        inScanner = new Scanner(System.in);
        listaTeclas = new ArrayList<>();
        ponerTeclasPermitidasArrayList();
        encender();
        
    }
    public static void ponerTeclasPermitidasArrayList(){
        for(int i=0; i<=9; i++){
            listaTeclas.add(Integer.toString(i));
        }
        listaTeclas.add("+");
        listaTeclas.add("-");
        listaTeclas.add("*");
        listaTeclas.add("/");
    }
    public static void encender(){
        System.out.println("Calculadora encendida");
        System.out.println("Escribe el primer número y apreta la tecla \"enter\":");
        recojerTeclas(1);
        System.out.println();
        System.out.println("Escribe el operador y apreta la tecla \"enter\":");
        recojerTeclas(2);
        System.out.println();
        operar();
    }
    public static void recojerTeclas(int ordenTecla){
        switch(ordenTecla){
            case 1:
                num1S = inScanner.next();
                break;
            case 2:
                operador = inScanner.next();
                break;
            case 3:
                num2S = inScanner.next();
                break;
            case 0:
                llamarMetOperaciones();
//
                
                operador = inScanner.next();
                if(operador.equals("=")){
                    System.out.println();
                    System.out.println("El resultado es: "+resultado);
                    System.out.println();
                    System.out.println("Calculadora apagada");
                }else{
                    num1 = resultado;
                    operar();
                }
                break;
        }
    }
    public static void llamarMetOperaciones(){
        num1 = Double.parseDouble(num1S);
        num2 = Double.parseDouble(num2S);
        
        switch(operador){
            case "+":
                resultado = suma();
                break;
            case "-":
                resultado = resta();
                break;
            case "*":
                resultado = multiplicacion();
                break;
            case "/":
                resultado = division();
                break;
        }
        resultadoS = String.valueOf(resultado);
    }
    public static double suma(){
        return num1 + num2;
    }
    public static double resta(){
        return num1 - num2;
    }
    public static double multiplicacion(){
        return num1 * num2;
    }
    public static double division(){
        return num1 / num2;
    }
    public static void operar(){
        System.out.println("Escribe el segundo número y apreta la tecla \"enter\":");
        recojerTeclas(3);
        System.out.println();
        System.out.println("Escribe un operador o el símbolo \"=\" y apreta la tecla \"enter\":");
        recojerTeclas(0);
    }
    public static void reinicializarVariables(){
        num1 = 0;
        num2 = 0;
        operador = null;
        num1S = null;
        num2S = null;
        operador = null;
    }
}
