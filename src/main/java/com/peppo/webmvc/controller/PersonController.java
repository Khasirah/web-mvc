package com.peppo.webmvc.controller;

import com.peppo.webmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class PersonController {

    @PostMapping(
            value = "/person",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest request,
                               BindingResult bindingResult) {

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        if (!allErrors.isEmpty()) {
            allErrors.forEach(objectError -> {
                System.out.println(objectError.getDefaultMessage());
            });
            fieldErrors.forEach(objectError -> {
                System.out.println(objectError.getField() + " : " + objectError.getDefaultMessage());
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you send invalid data");
        }

        System.out.println(request);

        String response = "success create person " +
                request.getName() +
                " email: " + request.getEmail() +
                " phone: " + request.getPhone() +
                " street: " + request.getAddress().getStreet() +
                " city: " + request.getAddress().getCity() +
                " country: " + request.getAddress().getCountry() +
                " postal code: " + request.getAddress().getPostalCode();

        return ResponseEntity.ok(response);
    }
}
