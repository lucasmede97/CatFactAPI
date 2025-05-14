package com.catfact.api.actions;

import com.catfact.api.utils.Utils;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.Assertions;

@Log4j2
public class commonActions extends Utils {
    public static void assertacaoEntreTextos(String msg, String msg2) {
        Assertions.assertEquals(msg, msg2);
        System.out.println("Passou: Comparou o texto esperado como " + msg + " sendo igual ao da tela como " + msg2 + ".");
    }

    public static void assertacaoContemTexto(String msg, String msg2) {
        Assertions.assertTrue(msg.contains(msg2));
        System.out.println("Passou: Comparou o texto esperado como " + msg + " contendo " + msg2 + ".");
    }

    public static void assertacaoTextoNaoVazio(String texto) {
        Assertions.assertFalse(texto.isEmpty(), "Texto está vazio");
        System.out.println("Texto retornado não está vazio");
    }

    public static void assertacaoTextoVazio(String texto) {
        Assertions.assertTrue(texto.isEmpty(), "Texto não está vazio");
        System.out.println("Texto retornado está vazio");
    }

    public static void assertacaoEntreInteiros(int msg, int msg2) {
        Assertions.assertEquals(msg, msg2);
        System.out.println("Passou: Comparou o texto esperado como " + msg + " sendo igual ao da tela como " + msg2 + ".");
    }

    public static void assertacaoTipoString(String valor) {
        Assertions.assertEquals(valor.getClass().getSimpleName(), "String");
        System.out.println("Passou: Comparar o tipo do parâmetro:" + valor.getClass().getSimpleName() + " sendo igual a STRING.");
    }

    public static void assertionsTipoInteger(Integer valor) {
        Assertions.assertEquals(valor.getClass().getSimpleName(), "Integer");
        System.out.println("Passou: Comparar o tipo do parâmetro:" + valor.getClass().getSimpleName() + " sendo igual a INTEGER.");
    }

    public static void assertacaoRetornadoNulo(String valor) {
        Assertions.assertNull(valor);
        System.out.println("Passou: Valor retornado e nulo.");
    }

}
