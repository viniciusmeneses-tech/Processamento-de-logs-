import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Processamento{
	
	private List<Dados> dadosbrutos;
	
	public Processamento(List<Dados> dadosbrutos){
		this.dadosbrutos = dadosbrutos;
	}

	public void opcaoUm() {
		List<String> dadosprocessados = new ArrayList<>();
		for(int n=0; n<dadosbrutos.size();n++){
			int codigo=dadosbrutos.get(n).getCodigoResposta();
			int tamanho=dadosbrutos.get(n).getTamanhoObj();
			if( codigo >= 200 && codigo <= 299 && tamanho > 2000){
				String dado = (dadosbrutos.get(n).getCodigoResposta())+ " " + (dadosbrutos.get(n).getTamanhoObj())+ " " + (dadosbrutos.get(n).getIP());
				dadosprocessados.add(dado);
			}
		}
		Escrita escrita = new Escrita();
		escrita.salvarArquivo("recursosGrandes.txt", dadosprocessados);
	}
	
	public void opcaoDois() {
		List<String> dadosprocessados = new ArrayList<>();
		LocalDateTime dataantes=LocalDateTime.of(2021, 10, 31, 23, 59, 59);
		LocalDateTime datadepois=LocalDateTime.of(2021, 12, 1, 00, 00, 00);
		for(int n=0; n<dadosbrutos.size();n++){
			int codigo=dadosbrutos.get(n).getCodigoResposta();
			String ref=dadosbrutos.get(n).getReferencia();
			LocalDateTime data=dadosbrutos.get(n).getData();
			if( codigo >= 400 && codigo <= 499 && data.isAfter(dataantes) && data.isBefore(datadepois)){
				String dado = (codigo) + " \"" +(ref)+ "\" " +"Nov/2021";
				dadosprocessados.add(dado);
			}
		}
		Escrita escrita = new Escrita();
		escrita.salvarArquivo("naoRespondidosNovembro.txt", dadosprocessados);
	}
	
	public void opcaoTres() {
		List<String> sistemasOperacionais = new ArrayList<>();
		float[] quantidadeSO = {0, 0, 0, 0, 0, 0};
		LocalDateTime inicio2021 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		LocalDateTime fim2021 = LocalDateTime.of(2022, 01, 01, 0, 0, 0);
		for (int i = 0; i < dadosbrutos.size(); i++) {
			LocalDateTime data = dadosbrutos.get(i).getData();
			String tipoSO = dadosbrutos.get(i).getUserAgent();
			if (data.isAfter(inicio2021) && data.isBefore(fim2021)) {
				
				if (tipoSO.contains("Android") || tipoSO.contains("Mobile")) {
				    quantidadeSO[4] += 1;
				}
				else if (tipoSO.contains("Windows")){
					quantidadeSO[0] += 1;
				}
				else if (tipoSO.contains("Macintosh")){
					quantidadeSO[1] += 1;
				}
				else if (tipoSO.contains("Ubuntu")) {
					quantidadeSO[2] += 1;
				}
				else if (tipoSO.contains("Fedora")) {
				    quantidadeSO[3] += 1;
				}
				
				else if (tipoSO.contains("X11")) {
				    quantidadeSO[5] += 1;
				}
				
			}
		}
		
		float total = 0;
		for (int i = 0; i < 6; i ++) {
			total += quantidadeSO[i];
		}
		String[] sistemas = {"Windows", "Macintosh", "Ubuntu", "Fedora", "Mobile", "Linux, outros"};
		for (int i = 0; i < 6; i++) {
			sistemasOperacionais.add( sistemas[i] + " " + String.format("%.4f", (quantidadeSO[i]/total * 100)));
		}
		
		Escrita escrita = new Escrita();
		escrita.salvarArquivo("sistemasOperacionais.txt", sistemasOperacionais);
		
	}
	
	public void opcaoQuatro() {
		int tamanhos = 0;
		int quantidade = 0;
		LocalDateTime inicio2021 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		LocalDateTime fim2021 = LocalDateTime.of(2022, 01, 01, 0, 0, 0);
		for (int i = 0; i < dadosbrutos.size(); i++) {
			String metodo = dadosbrutos.get(i).getMetodo();
			LocalDateTime data = dadosbrutos.get(i).getData();
			if ( metodo.equals("POST") && data.isAfter(inicio2021) && data.isBefore(fim2021)) {
				tamanhos += dadosbrutos.get(i).getTamanhoObj();
				quantidade += 1;
				
			}
			
		}
		int media = tamanhos/quantidade;
		System.out.printf("O total de requisições do tipo POST em 2021 é de: %d", quantidade);
		System.out.printf("\nA média do tamanho destas requisições é de: %d\n", media);
	}
}



