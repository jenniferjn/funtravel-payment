package id.co.bca.funtravel.payment.configuration;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public HttpComponentsClientHttpRequestFactory defaultHttpRequestFactory() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.getTotalStats();
        HttpClient client = HttpClients
                .custom()
                .setConnectionManager(manager)
                .disableCookieManagement()
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }
    
    @Bean
    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory restFactory) {

        // restFactory.setReadTimeout(this.readTimeout);
        // restFactory.setConnectTimeout(this.connectTimeout);
        // restFactory.setConnectionRequestTimeout(this.connectionRequestTimeout);
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(restFactory));
        
        return restTemplate;
    }
}
