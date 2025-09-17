import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String sNum1,sNum2;

        sNum1=JOptionPane.showInputDialog("Digite um número");
        sNum2=JOptionPane.showInputDialog("Digite um número");

        int num1=Integer.parseInt(sNum1);
        int num2=Integer.parseInt(sNum2);

        JOptionPane.showMessageDialog(null, num1/num2);
        System.exit(0);
    }
    //dividir por zero
}