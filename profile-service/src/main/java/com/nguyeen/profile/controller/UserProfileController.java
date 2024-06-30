package com.nguyeen.profile.controller;

import com.nguyeen.profile.dto.request.ProfileCreationRequest;
import com.nguyeen.profile.dto.response.UserProfileReponse;
import com.nguyeen.profile.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/users/{profileId}")
    UserProfileReponse getProfile(@PathVariable String profileId) {
        return userProfileService.getProfile(profileId);
    }

    @GetMapping("/users")
    List<UserProfileReponse> getAllProfile(){
        return userProfileService.getAllProfile();
    }
}
