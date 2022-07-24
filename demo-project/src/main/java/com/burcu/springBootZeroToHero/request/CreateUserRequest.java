package com.burcu.springBootZeroToHero.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserRequest {

    @NotNull
    @Length(min = 5, max = 15, message = "Min 5, Max 15  character!")
    private String userName;

    @NotNull
    @Length(min = 5, max = 15)
    private String password;

    @NotNull
    @Length(min = 15, max = 35)
  //  @Pattern(regexp = "^(.+)@(\\\\S+)$", message = "Email is not valid!")
    @Email
    private String email;
}
