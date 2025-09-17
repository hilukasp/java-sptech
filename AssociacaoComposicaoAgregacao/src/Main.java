//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Teste de Streaming (composição)
        ComposicaoStreaming netflix = new ComposicaoStreaming("Netflix");
        netflix.adicionarFilme("Matrix");
        netflix.adicionarFilme("Vingadores");
        netflix.listarFilmes();

        System.out.println();

        // Teste de Prateleira (agregação)
        AgregacaoLivro l1 = new AgregacaoLivro("Dom Casmurro");
        AgregacaoLivro l2 = new AgregacaoLivro("O Senhor dos Anéis");

        AgregacaoPrateleira prateleira = new AgregacaoPrateleira("Literatura");
        prateleira.adicionarLivro(l1);
        prateleira.adicionarLivro(l2);
        prateleira.listarLivros();

        //se a tabela pai sumir, tod registro filhos irão sumir
        netflix=null;
        //System.out.println(netflix.getFilmes().get(0).titulo);

        prateleira=null;
        //System.out.println(prateleira.getLivros().get(0).titulo);
        System.out.println(l1.titulo);
    }
}