import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.io.IOException;


public class Escrita {
	private String saida = System.getProperty("user.dir") + File.separator + "Análise";
	public void criarPasta() {
		
		File pasta = new File(saida);
		if (!pasta.exists()) {
		    pasta.mkdir();
		}
		
	}
	public void salvarArquivo(String nome, List<String> lista) {
		criarPasta();
		
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(saida + File.separator + nome))) {
			for (int i = 0; i < lista.size(); i++) {
				escritor.write(lista.get(i));
				escritor.newLine();
				
			}
			System.out.println("Arquivo salvo com sucesso!");
		}
		
		catch(IOException e) {
			System.out.println("Erro ao salvar o arquivo.");
			
		}
		
	}
}
