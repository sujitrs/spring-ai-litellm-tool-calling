package com.example.demo;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;
//http://localhost:8080/ai?userInput=Get the current date and time in the user's timezone
public class MyTools {
    @Tool(description = "Get the current date and time in the user's timezone")
    String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }
//http://localhost:8080/ai?userInput=What is name of the user ?
    @Tool(description = "User's Name")
    String getUser() {
        return "Sujeet";
    }
//http://localhost:8080/ai?userInput=Given first name is "Sujeet", what is its middlename ?
    @Tool(description = "Get middlename of a given user's first name")
    String getMiddleName(@ToolParam(description = "First Name") String  firstName) {
        return "Raosaheb";
    }
//http://localhost:8080/ai?userInput=Given first name is "Sujeet" with last name as "Suryawanshi", what is its middlename ?
    @Tool(description = "Get middlename of a given user's first name and last name")
    String getMiddleNameForFirstAndLastName(@ToolParam(description = "First Name") String  firstName,@ToolParam(description = "Last Name") String  lastName) {
        return "Nagorao";
    }
}
