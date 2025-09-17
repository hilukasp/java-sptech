public class ViagemTurismo {
    /*Baseado nos temas que estão no final do enunciado (cada aluno foi sorteado com um tema), criar uma classe com 6 atributos (um atributo ID inteiro, pelo menos um atributo String, pelo menos um atributo Double, mais um atributo inteiro). Os atributos devem fazer sentido dentro do contexto da classe.*/

    public Integer id;
    public String pais;
    public Double precounico;
    public Integer quantidadefamilia;
    public Double precototal;
    public String cidade;

    //alt+insert toString
    //toda vez que você exibir o objeto, vai exibir os parametros dentro dele em formato de json
    @Override
    public String toString() {
        return "ViagemTurismo{" +
                "id=" + id +
                ", cidade=" + cidade +
                ", pais=" + pais  +
                ", precounico=" + precounico +
                ", quantidadefamilia=" + quantidadefamilia +
                ", precototal=" + precototal +
                "}";
    }


}
