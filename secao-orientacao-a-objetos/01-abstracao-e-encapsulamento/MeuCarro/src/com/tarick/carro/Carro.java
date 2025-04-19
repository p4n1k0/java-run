package com.tarick.carro;

public class Carro {
  String marca;
  String modelo;
  int ano;

  public Carro(String marca, String modelo, int ano) {
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
  }

  public void exibirInformacoes() {
    System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano);
  }
}
