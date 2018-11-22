/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.model;

/**
 *
 * @author gustavosmc
 */
public abstract class Senha {
   private int numeroSenha;
    private String setor;
    private String tipoAtendimento;
    private String sigla;
    private String dataSenha;
    private String horaSenha;
    private String statusSenha;
    private int guiche;
    /**
     * @return the numeroSenha
     */
    public int getNumeroSenha() {
        return numeroSenha;
    }

    /**
     * @param numeroSenha the numeroSenha to set
     */
    public void setNumeroSenha(int numeroSenha) {
        this.numeroSenha = numeroSenha;
    }

    /**
     * @return the guiche
     */
    public int getGuiche() {
        return guiche;
    }

    /**
     * @param guiche the guiche to set
     */
    public void setGuiche(int guiche) {
        this.guiche = guiche;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * @return the tipoAtendimento
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * @param tipoAtendimento the tipoAtendimento to set
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * @return the dataSenha
     */
    public String getDataSenha() {
        return dataSenha;
    }

    /**
     * @param dataSenha the dataSenha to set
     */
    public void setDataSenha(String dataSenha) {
        this.dataSenha = dataSenha;
    }

    /**
     * @return the horaSenha
     */
    public String getHoraSenha() {
        return horaSenha;
    }

    /**
     * @param horaSenha the horaSenha to set
     */
    public void setHoraSenha(String horaSenha) {
        this.horaSenha = horaSenha;
    }

    /**
     * @return the statusSenha
     */
    public String getStatusSenha() {
        return statusSenha;
    }

    /**
     * @param statusSenha the statusSenha to set
     */
    public void setStatusSenha(String statusSenha) {
        this.statusSenha = statusSenha;
    }
}
