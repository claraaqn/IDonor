package model;

import java.util.Date;

public class Doacao {

    private long id;
    private Produtos produto;
    private Date datadoacao;
    private String nome;

    public Doacao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Date getDatadoacao() {
        return datadoacao;
    }

    public void setDatadoacao(Date datadoacao) {
        this.datadoacao = datadoacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Doacao{" +
                "id=" + id +
                ", produto=" + produto +
                ", datadoacao=" + datadoacao +
                ", nome='" + nome + '\'' +
                '}';
    }
}
