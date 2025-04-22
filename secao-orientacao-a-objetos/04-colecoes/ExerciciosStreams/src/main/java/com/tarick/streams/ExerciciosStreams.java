package com.tarick.streams;

import java.util.List;

public class ExerciciosStreams {

  public static void main(String[] args) {
    List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<Integer> numerosPares = filtrarNumerosPares(numeros);
    System.out.println(numerosPares.toString());

    List<String> palavras = List.of("java", "stream", "programação", "backend");
    System.out.println(converteParaCaixaAlta(palavras).toString());
  }

  public static List<Integer> filtrarNumerosPares(List<Integer> numeros) {
    return numeros.stream().filter(num -> num % 2 == 0).toList();
  }

  public static List<String> converteParaCaixaAlta(List<String> palavras) {
    return palavras.stream().map(String::toUpperCase).toList();
  }
}
