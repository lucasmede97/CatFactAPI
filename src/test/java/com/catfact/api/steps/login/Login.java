package com.catfact.api.steps.login;

import com.catfact.api.payload.login.RequestApiLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import com.catfact.api.config.endPoints;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

import static com.catfact.api.actions.apiActions.*;
import static com.catfact.api.utils.Utils.urlCatFact;
import static com.catfact.api.variaveis.VariaveisGlobais.token;

public class Login {
    static RequestApiLogin requestApiLogin;

    @Given("realizo login com sucesso")
    public static void realizoLoginComSucesso(Map<String, String> map) {
        /*requestApiLogin = new RequestApiLogin(map);
        requestApiLogin.setHeader();
        requestApiLogin.setJson(map);

        setBaseURI(urlCatFact);
        setBasePath(endPoints.endpointPostLogin);
        sendPost(requestApiLogin.getHeader(), requestApiLogin.getJson(), ContentType.JSON);

        token = getValorCampoResponseJSON("token");*/
    }

    @Then("valido que o status seja {int}")
    public static void validoQueOStatusSeja(Integer statusCode) {
        Assertions.assertEquals(statusCode, response.statusCode(), "Response code inválido");
        System.out.println("Response code validado com sucesso! Response esperado: " + statusCode + " Response Code obtido: " + response.statusCode());
    }
}
