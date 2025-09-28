import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploThrow {
    public static  int dividir(int a,int b)throws ArithmeticException{
        return a/b;
    }

    public static void main(String[] args) {
        Scanner e=new Scanner(System.in);
        try {
            int num1= e.nextInt();
            int num2= e.nextInt();
            System.out.println(dividir(num1,num2));
        }catch (ArithmeticException erro){
            System.out.println("Divisão por zero");
            erro.printStackTrace();
            //o caminho do erro
        }catch (InputMismatchException erro){
            System.out.println("Digite apenas números");
            erro.printStackTrace();
        }

    }
}
