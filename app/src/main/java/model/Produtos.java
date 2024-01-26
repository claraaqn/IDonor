package model;

public class Produtos {

    private long id;
    private String tipo;
    private int quantidade;

    public Produtos() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
