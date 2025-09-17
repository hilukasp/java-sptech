import javax.sound.midi.Soundbank;
import javax.swing.*;

public class Trycatch {
    public static void main(String[] args) {
        String sNum1,sNum2;

        sNum1= JOptionPane.showInputDialog("Digite um número");
        sNum2=JOptionPane.showInputDialog("Digite um número");

        try {
            int num1=Integer.parseInt(sNum1);
            int num2=Integer.parseInt(sNum2);

            JOptionPane.showMessageDialog(null, num1/num2);
        }
        //dividir por zero
        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        catch (ArithmeticException e){
            JOptionPane.showMessageDialog(null,
                    e);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,
                    "Digite apenas números: "+e,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            System.out.println("pega todo os outros restos de erro: "+e);
        }
        System.exit(0);
    }
}
