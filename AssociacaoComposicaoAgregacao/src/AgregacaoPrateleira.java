import java.util.ArrayList;
import java.util.List;

public class AgregacaoPrateleira {
    public String nome;
    public List<AgregacaoLivro> livros;

    public AgregacaoPrateleira(String nome) {
        this.nome = nome;
        this.livros=new ArrayList<>();
    }

    public AgregacaoPrateleira(String nome, List<AgregacaoLivro> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public void adicionarLivro(AgregacaoLivro livro){
        livros.add(livro);
    }

    public void removerLivro(AgregacaoLivro livro){
        livros.remove(livro);
    }

    public void listarLivros(){
        System.out.println("Livro na pratileira de " + nome + ":");
        for (AgregacaoLivro l:livros){
            System.out.println("- "+l.titulo);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AgregacaoLivro> getLivros() {
        return livros;
    }

    public void setLivros(List<AgregacaoLivro> livros) {
        this.livros = livros;
    }
}
