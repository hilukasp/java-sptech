public class Main {
    public static void main(String[] args) {
        SemEncapsulamento contaPublico = new SemEncapsulamento();

        contaPublico.titular = "João";
        contaPublico.saldo = 1000;

        // Qualquer pessoa pode mudar o atributo diretamente
        contaPublico.saldo = -5000; // 👎 Isso não faz sentido!

        System.out.println(contaPublico.titular + " tem saldo: " + contaPublico.saldo);
        System.out.println();

        //----------------------------------------------------------
        ComEncapsulamento contaPrivate=new ComEncapsulamento("João",1000);


        //no setSaldo, há uma validação para não permitir que numeros negativos sejam passados por parametro
        //toda validação dos atributos são feitos ou no metodo construtor ou no get e seter
        contaPrivate.setSaldo(-5000);

        System.out.println(contaPrivate.getTitular()+ " tem saldo: "+contaPrivate.getSaldo());
    }
}
