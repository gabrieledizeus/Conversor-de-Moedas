package Modelo;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Moeda {
    @SerializedName("moeda")
    private double valorConverte;
    private double taxaCambio;

    public Moeda(double taxaCambio) {
        this.taxaCambio = taxaCambio;
    }

    private Map<String, Double> conversion_rates;

    public Moeda(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public double getTaxa(String codigoMoeda) {
        return conversion_rates.get(codigoMoeda);
    }



    public double converterPara(String origem, String destino, double valor) {
        double taxaOrigem = getTaxa(origem);
        double taxaDestino = getTaxa(destino);
        return (valor / taxaOrigem) * taxaDestino;
    }



}
