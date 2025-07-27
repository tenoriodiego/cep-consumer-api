// package com.salutis.cep_consumer_api.config;

// import org.springframework.stereotype.Component;

// import com.github.tomakehurst.wiremock.WireMockServer;
// import com.github.tomakehurst.wiremock.client.WireMock;
// import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
// import static com.github.tomakehurst.wiremock.client.WireMock.get;
// import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
// import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
// import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

// import jakarta.annotation.PostConstruct;
// import jakarta.annotation.PreDestroy;

// @Component
// public class WireMockInitializer {

//     private WireMockServer wireMockServer;

//     @PostConstruct
//     public void startWireMockServer() {
//         wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8081));
//         wireMockServer.start();

//         WireMock.configureFor("localhost", 8081);

//         // Exemplo de stub
//         stubFor(get(urlEqualTo("/api/cep/01001000"))
//                 .willReturn(aResponse()
//                         .withStatus(200)
//                         .withHeader("Content-Type", "application/json")
//                         .withBody("""
//                             {
//                               "cep": "01001-000",
//                               "logradouro": "Praça da Sé",
//                               "bairro": "Sé",
//                               "localidade": "São Paulo",
//                               "uf": "SP"
//                             }
//                             """)));
//     }

//     @PreDestroy
//     public void stopWireMockServer() {
//         wireMockServer.stop();
//     }
// }

