import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Leitura leitura = new Leitura();
		List<Dados> listadadosbrutos = leitura.lerArquivo();
		Processamento processamento = new Processamento(listadadosbrutos);
		Main main = new Main();
		main.exibirMenu(processamento, scanner);
		scanner.close();
	}

	public void exibirMenu(Processamento processamento, Scanner scanner) {
		int opcao = 1;
		while (opcao != 0) {
			System.out.print("1 - Recursos Grandes respondidos\n2 - Não respondidos\n3 - % de requisições por SO\n4 - Média das requisições POST\n0 - Sair\n\nDigite a opção desejada: ");
			try { opcao = scanner.nextInt();
				if (opcao == 1) {processamento.opcaoUm();}
				else if (opcao == 2) {processamento.opcaoDois();}
				else if (opcao == 3) {processamento.opcaoTres();}
				else if (opcao == 4) {processamento.opcaoQuatro();}
				else if (opcao == 0) {}
				else {System.out.println("Valor invalido");}
				
			}	catch(java.util.InputMismatchException e) {
					System.out.println("Erro, insira um numero inteiro!");
					scanner.next();
				}
		}
		
	}
	
	
}
