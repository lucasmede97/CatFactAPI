package com.catfact.api.steps.breends;

import com.catfact.api.config.endPoints;
import com.catfact.api.payload.breends.RequestApiGetBreends;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import java.util.Map;
import static com.catfact.api.actions.apiActions.*;

public class GetBreends {
    static RequestApiGetBreends requestApiGetBreends;

    @When("consulto as raças")
    public static void consultoAsRacas(Map<String, String> map) {
        requestApiGetBreends = new RequestApiGetBreends(map);
        requestApiGetBreends.setHeader();
        requestApiGetBreends.setParams(map);

        setBaseURI(urlCatFact);
        setBasePath(endPoints.endpointGetBreends);
        sendGetParams(requestApiGetBreends.getHeader(), requestApiGetBreends.getParams(), ContentType.JSON);
    }

    @Then("valido que os dados foram retornados com sucesso")
    public static void validoQueOsDadosForamRetornadosComSucesso(Map<String, String> map) {
        assertacaoContemTexto(getJSONResponseBody(),"breed");
        assertacaoContemTexto(getJSONResponseBody(),"country");
        assertacaoContemTexto(getJSONResponseBody(),"origin");
        assertacaoContemTexto(getJSONResponseBody(),"coat");
        assertacaoContemTexto(getJSONResponseBody(),"pattern");
        assertacaoEntreTextos(String.valueOf(getTamanhoCampoResponseJSON("data")), map.get("quantidadeRegistros"));
    }

}