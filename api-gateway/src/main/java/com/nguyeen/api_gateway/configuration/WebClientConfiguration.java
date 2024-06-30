package com.nguyeen.api_gateway.configuration;

import com.nguyeen.api_gateway.repository.IdentityClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfiguration {
    @Bean
    WebClient webClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:8080/identity")
                .build();
    }

    @Bean
    IdentityClient identityClient(WebClient webClient){
        //đăng ký proxy -> khi request method, proxy request tới @PostExchange
        //proxy xử lý việc tuần tự hóa/giải tuần tự hóa dữ liệu, gửi yêu cầu, nhận phản hồi
        //và chuyển đổi phản hồi thành các đối tượng Java
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))//tạo một adapter để kết nối WebClient với OpenFeign
                .build();
        return httpServiceProxyFactory.createClient(IdentityClient.class);//tạo proxy cho IdentityClient
    }
}
