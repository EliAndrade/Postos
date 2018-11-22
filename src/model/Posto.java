package model;

import java.util.TreeSet;

public class Posto {
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private double latitude;
    private double longitude;
    
    private boolean gasolina;
    private boolean etanol;
    private boolean diesel;
    
    private float precoGasolina;
    private float precoEtanol;
    private float precoDiesel;
    
    private TreeSet<Integer> espera;

    public Posto() {
    }  

    public Posto(String nome, String endereco, String cidade, String estado, double latitude, double longitude) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gasolina = false;
        this.espera = new TreeSet<>();
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isGasolina() {
        return gasolina;
    }

    public void setGasolina(boolean gasolina) {
        this.gasolina = gasolina;
    }

    public TreeSet<Integer> getEspera() {
        return espera;
    }

    public void adicionarEspera(int tempo) {
        espera.add(tempo);
        if (espera.size() > 10) {
            espera.remove(espera.last());
        }
    }

    public boolean isEtanol() {
        return etanol;
    }

    public void setEtanol(boolean etanol) {
        this.etanol = etanol;
    }

    public boolean isDiesel() {
        return diesel;
    }

    public void setDiesel(boolean diesel) {
        this.diesel = diesel;
    }

    public float getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(float precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public float getPrecoEtanol() {
        return precoEtanol;
    }

    public void setPrecoEtanol(float precoEtanol) {
        this.precoEtanol = precoEtanol;
    }

    public float getPrecoDiesel() {
        return precoDiesel;
    }

    public void setPrecoDiesel(float precoDiesel) {
        this.precoDiesel = precoDiesel;
    }
    
    
}
