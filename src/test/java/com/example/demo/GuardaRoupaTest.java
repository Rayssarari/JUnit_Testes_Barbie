package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardaRoupaTest {

    private GuardaRoupa guardaRoupa;

    @BeforeEach void preparar() {
        guardaRoupa = new GuardaRoupa(500);
    }
    @Test @DisplayName("Ver preço com desconto de 10% em 200 que deve retornar 180.")
    void AplicarPrecoComDesconto() {
        double resultado = guardaRoupa.precoComDesconto(200, 10);
        assertEquals(180, resultado,0.01);
    }
    @Test @DisplayName("Lançar exceção se número de desconto negativo")
    void RejeitarDescontoNegativo(){
        assertThrows(IllegalArgumentException.class, ()-> guardaRoupa.precoComDesconto(200, 110));
        }

    @Test @DisplayName("Ver se cabe no orçamento")
    void cabeNoOrcamento() {
    assertTrue(guardaRoupa.cabeNoOrcamento(350));
    }

    @Test @DisplayName("Preço igual ao orçamento deve passar")
    void deveAceitarPrecoIgualAoOrcamento(){
    assertTrue(guardaRoupa.cabeNoOrcamento(500));
    }

    @Test @DisplayName("Acima de 200 passa")
    void ehDeGala() {
    assertTrue(guardaRoupa.ehDeGala(230));
    }
    @Test @DisplayName("Abaixo de 200, não deve passar")
    void naoDeveSerGala(){
    assertFalse(guardaRoupa.ehDeGala(197));
    }
    @Test @DisplayName("Igual a 200 não passa")
    void naoEhGala(){
        assertFalse(guardaRoupa.ehDeGala(200));
    }
}