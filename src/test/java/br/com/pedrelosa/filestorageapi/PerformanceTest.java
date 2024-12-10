package br.com.pedrelosa.filestorageapi;

import java.time.LocalDateTime;

public class PerformanceTest {
    public static void main(String[] args) {
        final int iterations = 100000;
        final int multiply = 10;

        // Teste com Lombok
        long startTime = System.nanoTime();
        for (int j = 0; j < multiply; j++) {
            for (int i = 0; i < iterations; i++) {
                LombokClass lc1 = LombokClass.generateRandom();
                LombokClass lc2 = LombokClass.generateRandom();
                Boolean bool1 = lc1.equals(lc2);
                Boolean bool2 = lc2.equals(lc1);
                Integer integer1 = lc1.hashCode();
                Integer integer2 = lc2.hashCode();

                String fina = bool1.toString() + bool2.toString() + integer1 + integer2;
            }
        }
        long endTime = System.nanoTime();
        long durationLombok = (endTime - startTime) / 1000000; // em milissegundos
        System.out.println("Tempo com Lombok: " + durationLombok + " ms");

        // Teste sem Lombok
        startTime = System.nanoTime();
        for (int j = 0; j < multiply; j++) {
            for (int i = 0; i < iterations; i++) {
                PlainClass pc1 = PlainClass.generateRandom();
                PlainClass pc2 = PlainClass.generateRandom();
                Boolean bool1 = pc1.equals(pc2);
                Boolean bool2 = pc2.equals(pc1);
                Integer integer1 = pc1.hashCode();
                Integer integer2 = pc2.hashCode();

                String fina = bool1.toString() + bool2.toString() + integer1 + integer2;
            }
        }
        endTime = System.nanoTime();
        long durationPlain = (endTime - startTime) / 1000000; // em milissegundos
        System.out.println("Tempo sem Lombok: " + durationPlain + " ms");
    }
}
