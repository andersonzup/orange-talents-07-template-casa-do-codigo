package br.com.zup.casadocodigo.config.exception;

public class ErroFormResponse {

    private String campo;
    private String erro;

    public ErroFormResponse(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
