package com.nguyeen.api_gateway.repository;

import com.nguyeen.api_gateway.dto.ApiResponse;
import com.nguyeen.api_gateway.dto.request.IntrospectRequest;
import com.nguyeen.api_gateway.dto.response.IntrospectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@Repository
//dùng WebClient chứ không dùng Feign vì WC hỗ trợ tuỳ chỉnh phức tạp và tận dụng reactive
//=> phải set url trên WebClientConfiguration
public interface IdentityClient {
    @PostExchange(value = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);
}
