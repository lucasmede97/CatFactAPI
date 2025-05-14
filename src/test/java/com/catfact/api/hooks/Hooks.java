package com.catfact.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import static com.catfact.api.utils.Utils.setarAmbienteAPI;
import static com.catfact.api.utils.Utils.setarSistemaOperacional;

public class Hooks {

    @Before("@api")
    public void before() {
        setarSistemaOperacional();
        setarAmbienteAPI();
    }
}
