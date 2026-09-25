package com.qacart.todo.utils;

import com.qacart.todo.pojo.UserRegister;
import net.datafaker.Faker;

public class UserUtils {

    public static UserRegister generateRandomUser(){
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        UserRegister userRegister = new UserRegister(firstName, lastName, email ,password);
        return userRegister;
    }
}
