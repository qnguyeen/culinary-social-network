package com.nguyeen.api_gateway.service;

import com.nguyeen.api_gateway.dto.ApiResponse;
import com.nguyeen.api_gateway.dto.request.IntrospectRequest;
import com.nguyeen.api_gateway.dto.response.IntrospectResponse;
import com.nguyeen.api_gateway.repository.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token){//nhận token raw từ httpHeader
        return identityClient.introspect(IntrospectRequest.builder()//truyền token raw vào endpoint Introspect từ IS
                        .token(token)
                .build());
    }
}
