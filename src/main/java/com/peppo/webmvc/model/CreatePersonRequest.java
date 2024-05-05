package com.peppo.webmvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    @NotBlank // annotation untuk validasi tidak boleh kosong
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;
    private CreateAddressRequest address;
    private List<String> hobbies;
    private List<CreateSocialMediaRequest> socialMedias;
}
