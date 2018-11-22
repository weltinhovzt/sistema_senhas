/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.model;

/**
 *
 * @author welti_000
 */
public class SenhaCaixa extends Senha {

    private int id_senhaCaixa;
    private int numeroSenha;
    private String setor;
    private String tipoAtendimento;
    private String sigla;
    private String dataSenha;
    private String horaSenha;
    private String statusSenha;
    private int guiche;

    public int getId_senhaCaixa() {
        return id_senhaCaixa;
    }

    public void setId_senhaCaixa(int id_senhaCaixa) {
        this.id_senhaCaixa = id_senhaCaixa;
    }

    @Override
    public int getNumeroSenha() {
        return numeroSenha;
    }

    @Override
    public void setNumeroSenha(int numeroSenha) {
        this.numeroSenha = numeroSenha;
    }

    @Override
    public String getSetor() {
        return setor;
    }

    @Override
    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    @Override
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    @Override
    public String getSigla() {
        return sigla;
    }

    @Override
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String getDataSenha() {
        return dataSenha;
    }

    @Override
    public void setDataSenha(String dataSenha) {
        this.dataSenha = dataSenha;
    }

    @Override
    public String getHoraSenha() {
        return horaSenha;
    }

    @Override
    public void setHoraSenha(String horaSenha) {
        this.horaSenha = horaSenha;
    }

    @Override
    public String getStatusSenha() {
        return statusSenha;
    }

    @Override
    public void setStatusSenha(String statusSenha) {
        this.statusSenha = statusSenha;
    }

    @Override
    public int getGuiche() {
        return guiche;
    }

    @Override
    public void setGuiche(int guiche) {
        this.guiche = guiche;
    }

}
