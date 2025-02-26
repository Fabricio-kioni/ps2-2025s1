import java.util.List;

public interface GerenciadorNomes {
    int MAX_CARACTERES_NOMES = 20;

    List<String> obterNomes();

    void adicionarNomes(String nome);
}