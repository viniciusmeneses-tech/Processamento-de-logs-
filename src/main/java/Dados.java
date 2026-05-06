import java.time.LocalDateTime;

public class Dados {

    private String IP;
    private String userID;
    private LocalDateTime data;
    private String metodo;
    private String recurso;
    private int codigoResposta;
    private int tamanhoObj;
    private String userAgent;
    private String referencia;

    public Dados(String IP, String userID,LocalDateTime data, String metodo, String recurso, int codigoResposta,int tamanhoObj,String userAgent, String referencia) {

        this.IP = IP;
        this.userID = userID;
        this.data = data;
        this.metodo = metodo;
        this.recurso = recurso;
        this.codigoResposta = codigoResposta;
        this.tamanhoObj = tamanhoObj;
        this.userAgent = userAgent;
        this.referencia = referencia;
    }

    public String getIP() {
        return IP;
    }

    public String getUserID() {
        return userID;

    }

    public LocalDateTime getData() {
        return data;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getRecurso() {
        return recurso;

    }

    public int getCodigoResposta() {
        return codigoResposta;
    }

    public int getTamanhoObj() {
        return tamanhoObj;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getReferencia() {
        return referencia;

    }
}