import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GerenciadorNomesArq implements GerenciadorNomes {

	@Override
	public List<String> obterNomes() {
		List<String> nomes = new ArrayList<String>();
		try {
			FileReader arq = new FileReader("Nomes.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {
				nomes.add(linha);
				linha = lerArq.readLine();
			}
			lerArq.close();

		} catch (IOException e) {
			System.out.println("Erro ao tentar ler o arquivo");
			e.getMessage();
		}
		return nomes;
	}

	@Override
	public void adicionarNomes(String nome) {
		Path arq = Paths.get("arquivo.txt");
		try {
			Files.writeString(arq, nome + System.lineSeparator(), StandardOpenOption.APPEND);
			System.out.println("Nome add com sucesso!\n");

		} catch (IOException e) {
			System.out.println("Erro ao tentar escrever no arquivo");
			e.printStackTrace();
		}
	}

	@Override
	public void adicionarNomes(String nome) {
		throw new UnsupportedOperationException("Unimplemented method 'adicionarNomes'");
	}
}