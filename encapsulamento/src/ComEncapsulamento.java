public class ComEncapsulamento {
    private String titular;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }
    //construtor, garante que o atributo do saldo seja iniciado como negativo
    public ComEncapsulamento(String titular, double saldo) {
        if (saldo>0){
            this.saldo = saldo;
        }
        this.titular = titular;
    }

    public void setSaldo(double valor) {
        if (valor >= 0) {
            saldo = valor;
        } else {
            System.out.println("Não é permitido saldo negativo!");
        }
       // this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}

