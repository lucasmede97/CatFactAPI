package com.catfact.api.actions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.groovy.json.internal.LazyMap;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class apiActions extends commonActions {
    public static Response response;
    public static RequestSpecification request;
    private static final int maximoTentativas = 3;

    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }
    public static void setBasePath(String endpoint) {
        RestAssured.basePath = endpoint;
    }

    public static Response sendGet(LazyMap header, ContentType contentType) {
        for (int i = 0; i < maximoTentativas; i++) {
            response =
                    given()
                            .relaxedHTTPSValidation()
                            .contentType(contentType)
                            .headers(header)
                            .log().all()
                            .when()
                            .get()
                            .then()
                            .log().all()
                            .extract().response();
            if (response.statusCode() < 500) {
                return response;
            }
        }
        Assertions.fail("Apresentou erro com status: " + response.statusCode());
        return null;
    }

    public static Response sendGetParams(LazyMap header, LazyMap param, ContentType contentType) {
        for (int i = 0; i < maximoTentativas; i++) {
            response =
                    given()
                            .relaxedHTTPSValidation()
                            .contentType(contentType)
                            .headers(header)
                            .params(param)
                            .log().all()
                            .when()
                            .get()
                            .then()
                            .log().all()
                            .extract().response();
            if (response.statusCode() < 500) {
                return response;
            }
        }
        Assertions.fail("Apresentou erro com status: " + response.statusCode());
        return null;
    }

    public static Response sendPost(LazyMap header, Object json, ContentType contentType) {
        for (int i = 0; i < maximoTentativas; i++) {
            response =
                    given()
                            .relaxedHTTPSValidation()
                            .contentType(contentType)
                            .headers(header)
                            .body(json)
                            .log().all()
                            .when()
                            .post()
                            .then()
                            .log().all()
                            .extract().response();
            if (response.statusCode() < 500) {
                return response;
            }
        }
        Assertions.fail("Apresentou erro com status: " + response.statusCode());
        return null;
    }

    public static Response sendPost(LazyMap header, ContentType contentType) {
        for (int i = 0; i < maximoTentativas; i++) {
            response =
                    given()
                            .relaxedHTTPSValidation()
                            .contentType(contentType)
                            .headers(header)
                            .log().all()
                            .when()
                            .post()
                            .then()
                            .log().all()
                            .extract().response();
            if (response.statusCode() < 500) {
                return response;
            }
        }
        Assertions.fail("Apresentou erro com status: " + response.statusCode());
        return null;
    }

    public static Response sendDelete(LazyMap header, ContentType contentType) {
        for (int i = 0; i < maximoTentativas; i++) {
            response =
                    given()
                            .relaxedHTTPSValidation()
                            .contentType(contentType)
                            .headers(header)
                            .log().all()
                            .when()
                            .delete()
                            .then()
                            .log().all()
                            .extract().response();
            if (response.statusCode() < 500) {
                return response;
            }
        }
        Assertions.fail("Apresentou erro com status: " + response.statusCode());
        return null;
    }

    public static Response sendPut(LazyMap header, Object json, ContentType contentType) {
        for (int i = 0; i < maximoTentativas; i++) {
            response =
                    given()
                            .relaxedHTTPSValidation()
                            .contentType(contentType)
                            .headers(header)
                            .body(json)
                            .log().all()
                            .when()
                            .put()
                            .then()
                            .log().all()
                            .extract().response();
            if (response.statusCode() < 500) {
                return response;
            }
        }
        Assertions.fail("Apresentou erro com status: " + response.statusCode());
        return null;
    }

    public static Response sendPutParams(LazyMap header, LazyMap params, ContentType contentType) {
        for (int i = 0; i < maximoTentativas; i++) {
            response =
                    given()
                            .relaxedHTTPSValidation()
                            .contentType(contentType)
                            .headers(header)
                            .params(params)
                            .log().all()
                            .when()
                            .put()
                            .then()
                            .log().all()
                            .extract().response();
            if (response.statusCode() < 500) {
                return response;
            }
        }
        Assertions.fail("Apresentou erro com status: " + response.statusCode());
        return null;
    }

    public static String getValorCampoResponseJSON(String campoResponseJson) {
        try {
            return response.jsonPath().get(campoResponseJson).toString();
        } catch (Exception e) {
            Assertions.fail("Erro ao tentar capturar valor do Response JSON! ---- " + e);
            throw e;
        }
    }

    public static String getJSONResponseBody() {
        try {
            return response.asString();
        } catch (Exception e) {
            Assertions.fail("Erro ao tentar capturar o Body Response JSON! ---- " + e);
            throw e;
        }
    }

    public static int getTamanhoCampoResponseJSON(String campoResponseJson) {
        try {
            return response.jsonPath().getList(campoResponseJson).size();
        } catch (Exception e) {
            Assertions.fail("Erro ao tentar capturar o tamanho do array no Response JSON! ---- " + e);
            throw e;
        }
    }
}
