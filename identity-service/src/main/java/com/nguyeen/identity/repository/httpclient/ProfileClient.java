package com.nguyeen.identity.repository.httpclient;

import com.nguyeen.identity.dto.request.ProfileCreationRequest;
import com.nguyeen.identity.dto.response.UserProfileReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "profile-service",url = "${app.service.profile}")//domain tới service
public interface ProfileClient {

    @PostMapping(value = "users",produces = MediaType.APPLICATION_JSON_VALUE)//preoduces : tạo ra request với body dạng JSON
    UserProfileReponse createProfile(@RequestBody ProfileCreationRequest request);
}
