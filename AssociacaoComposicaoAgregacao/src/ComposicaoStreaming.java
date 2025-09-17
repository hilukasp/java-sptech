import java.util.ArrayList;

public class ComposicaoStreaming {
    String nome;
    ArrayList<ComposicaoFilme> filmes; // composição

    public ComposicaoStreaming(String nome) {
        this.nome = nome;
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(String titulo) {

        //livros.add(livro);
        filmes.add(new ComposicaoFilme(titulo)); // cria dentro → composição
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ComposicaoFilme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<ComposicaoFilme> filmes) {
        this.filmes = filmes;
    }

    public void removerFilme(String titulo){
        filmes.remove(titulo);
    }

    public void listarFilmes() {
        System.out.println("Filmes no streaming " + nome + ":");
        for (ComposicaoFilme f : filmes) {
            System.out.println("- " + f.titulo);
        }
    }
}
