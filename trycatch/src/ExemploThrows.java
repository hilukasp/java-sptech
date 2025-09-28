import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploThrows {


    public static void main(String[] args) {
        Scanner e=new Scanner(System.in);
        try {
            int num1= e.nextInt();
            if (num1<0||num1>100){
                throw new RuntimeException("Número inválido"); //Você cria um exception
            }
        }catch (RuntimeException erro){
            System.out.println("Divisão por zero");
            erro.printStackTrace();
            //o caminho do erro
        }

    }
}
