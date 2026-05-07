import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leitura {

    private String entrada = System.getProperty("user.dir") + "\\src\\main\\resources\\access.log";
    
    public List<Dados> lerArquivo() {
        List<Dados> listaDados = new ArrayList<>();
        BufferedReader leitor = null;

        try {
            leitor = new BufferedReader(new FileReader(entrada));
            String linha;

            while ((linha = leitor.readLine()) != null) {
            	Dados dado = separarLinhas(linha);
            	if (dado != null) {
            	    listaDados.add(dado);
            	}
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");

        } finally {
            try {
                if (leitor != null) {
                    leitor.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }

        return listaDados;
    }


    private Dados separarLinhas(String linha) {

        String regex = "^(\\S+) \\S+ \\S+ \\[([^\\]]+)\\] \"([^\"]+)\" (\\d{3}) (\\S+) \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linha);

        if (matcher.find()) {

            String ip = matcher.group(1);

            // Data e hora converter para LocalDateTime
            String dataTexto = matcher.group(2); // 19/Dec/2020:13:57:26 + 0100 em LocalDateTime
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
            LocalDateTime data = LocalDateTime.parse(dataTexto, formatter);

            //"GET /index.php HTTP/1.1"
            String requisicao = matcher.group(3);
            String[] partesReq = requisicao.split(" ");
            String metodo = partesReq[0];
            String recurso = partesReq[1];
            
            int codigoResposta = 0;
            int tamanhoObj = 0;
            
            try {
            codigoResposta = Integer.parseInt(matcher.group(4));	
            }catch(NumberFormatException e){codigoResposta = 0;}
            try {
            tamanhoObj = Integer.parseInt(matcher.group(5));
            }catch(NumberFormatException e) {tamanhoObj = 0;}
            String referencia = matcher.group(6);
            String userAgent = matcher.group(7);

            //No log não existe userID pra usar
            String userID = "-";

            return new Dados(ip,userID, data, metodo,recurso,codigoResposta,tamanhoObj,userAgent,referencia);
        }

        return null;
    }
}