import javax.swing.*;

public class TrycatchFinally {
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
        } finally {
            JOptionPane.showMessageDialog(null,"fim do programa");
        }
        //o finally garante que execute e não fique executando. Além disso boas práticas.
            //JOptionPane.showMessageDialog(null,"fim do programa");
        System.exit(0);
    }
}
