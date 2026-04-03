package app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unidade;
    private Float valor;
    private String local;

    public Sensor() {}

    public Sensor(Long id, String unidade, Float valor, String local) {
        this.id = id;
        this.unidade = unidade;
        this.valor = valor;
        this.local = local;
    }

    public Long getId() { return id; }

    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }

    public Float getValor() { return valor; }
    public void setValor(Float valor) { this.valor = valor; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
}