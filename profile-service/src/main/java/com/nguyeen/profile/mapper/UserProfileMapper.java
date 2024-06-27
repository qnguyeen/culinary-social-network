package com.nguyeen.profile.mapper;

import org.mapstruct.Mapper;

import com.nguyeen.profile.dto.request.ProfileCreationRequest;
import com.nguyeen.profile.dto.response.UserProfileReponse;
import com.nguyeen.profile.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileReponse toUserProfileReponse(UserProfile entity);
}
