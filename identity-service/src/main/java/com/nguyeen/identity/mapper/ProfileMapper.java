package com.nguyeen.identity.mapper;

import com.nguyeen.identity.dto.request.ProfileCreationRequest;
import com.nguyeen.identity.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
