package com.catfact.api.utils;

public class Utils {
    public static String SO;
    public static String urlCatFact;

    public static void setarSistemaOperacional() {
        String nameSO = System.getProperty("os.name");
        if (nameSO.contains("Mac")) {
            SO = "MAC";
        } else if (nameSO.contains("Windows")) {
            SO = "WINDOWS";
        } else if (nameSO.contains("Linux")) {
            SO = "LINUX";
        } else {
            System.out.println("Nenhum sistema operacional encontrado.");
        }
    }

    public static void setarAmbienteAPI() {
        urlCatFact= "https://catfact.ninja/";
    }

}
