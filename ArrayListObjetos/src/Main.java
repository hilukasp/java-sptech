import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //ArrayList<Tipagem> nome =new ArrayList<>();
        ArrayList<ViagemTurismo> viagens=new ArrayList<>();
        //objeto também é considerado um tipo

        ViagemTurismo viagem1= new ViagemTurismo();
        viagem1.id=1;
        viagem1.cidade="Brasilia";
        viagem1.pais="Brasil";
        viagem1.precounico=100.0;
        viagem1.quantidadefamilia=3;
        viagem1.precototal= viagem1.precounico*viagem1.quantidadefamilia;

        //adiciona o objeto a lista
        viagens.add(viagem1);

        ViagemTurismo viagem2= new ViagemTurismo();
        viagem2.id=2;
        viagem2.cidade="Tokyo";
        viagem2.pais="Japão";
        viagem2.precounico=2000.0;
        viagem2.quantidadefamilia=4;
        viagem2.precototal= viagem2.precounico*viagem2.quantidadefamilia;
        viagens.add(viagem2);

        ViagemTurismo viagem3= new ViagemTurismo();
        viagem3.id=3;
        viagem3.cidade="Nova York";
        viagem3.pais="Estado Unidos";
        viagem3.precounico=3000.0;
        viagem3.quantidadefamilia=2;
        viagem3.precototal= viagem3.precounico*viagem3.quantidadefamilia;
        viagens.add(viagem3);

        ViagemTurismo viagem4 = new ViagemTurismo();
        viagem4.id = 4;
        viagem4.cidade = "Paris";
        viagem4.pais = "França";
        viagem4.precounico = 2500.0;
        viagem4.quantidadefamilia = 5;
        viagem4.precototal = viagem4.precounico * viagem4.quantidadefamilia;
        viagens.add(viagem4);


        Main main = new Main();
        System.out.println(viagens);
        main.Exibir(viagens);

        //converte ArrayList em array -> viagens.toArray(new ViagemTurismo[0])
        main.ExibirVetorPrimitivo(viagens.toArray(new ViagemTurismo[0]));
    }

    void Exibir(List<ViagemTurismo> objeto){
        System.out.println("ArrayList");
        System.out.println(objeto.get(0).cidade);

        //para cada objeto faça
        for(ViagemTurismo viagem:objeto){
            System.out.println(viagem.toString());
        }

    }
    void ExibirVetorPrimitivo(ViagemTurismo[] objeto){
        System.out.println();
        System.out.println("array");
        System.out.println(objeto[0].cidade);
        for(ViagemTurismo viagem:objeto){
            System.out.println(viagem.toString());
        }

    }

}