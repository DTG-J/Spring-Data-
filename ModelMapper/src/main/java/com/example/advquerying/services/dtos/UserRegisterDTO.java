package com.example.advquerying.services.dtos;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDTO {
    @Pattern(regexp = "\\w+@\\w+.\\w+", message = "Email is not matching the pattern.")
    private String email;
   @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*", message = "Password doesn't match the pattern.")
   @Size(min = 6, message = "Password needs to be at least 6 symbols. ")
    private String password;
    private String confirmPassword;
    private String fullName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }
}
