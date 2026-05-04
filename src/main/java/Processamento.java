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
			int codigo=dadosbrutos.get(n).getcodigoResposta();
			int tamanho=dadosbrutos.get(n).gettamanhoObj();
			if( codigo >= 200 && codigo <= 299 && tamanho > 2000){
				String dado = (dadosbrutos.get(n).getcodigoResposta())+ " " + (dadosbrutos.get(n).gettamanhoObj())+ " " + (dadosbrutos.get(n).getIP());
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
			int codigo=dadosbrutos.get(n).getcodigoResposta();
			String ref=dadosbrutos.get(n).getreferencia();
			LocalDateTime data=dadosbrutos.get(n).getdata();
			if( codigo >= 400 && codigo <= 499 && data.isAfter(dataantes) && data.isBefore(datadepois)){
				String dado = (codigo) + " \"" +(ref)+ "\" " +"Nov/2021";
				dadosprocessados.add(dado);
			}
		}
		Escrita escrita = new Escrita();
		escrita.salvarArquivo("naoRespondidosNovembro.txt", dadosprocessados);
	}
	
	public void opcaoQuatro() {
		
		
	}
}



