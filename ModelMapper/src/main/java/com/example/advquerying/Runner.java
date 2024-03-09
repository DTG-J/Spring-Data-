package com.example.advquerying;

import com.example.advquerying.services.dtos.UserRegisterDTO;
import com.example.advquerying.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class Runner implements CommandLineRunner {
    private final UserService userService;

    public Runner(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        while (!input.equals("END")){
            String[] tokens = input.split("//|");




          String  command = "";
            switch (tokens[0]){
                case "RegisteUser":
                    command = this.userService.registerUser (new UserRegisterDTO(tokens[1], tokens[2], tokens[3], tokens[4]));
                    break;

                case "LogInUser":

                    break;

                case "LogOut":

                    break;
            }

            System.out.println(command);
            input = bufferedReader.readLine();
        }

    }
}








