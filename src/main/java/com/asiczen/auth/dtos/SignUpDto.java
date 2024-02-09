package com.asiczen.auth.dtos;

public record SignUpDto (String firstName, String lastName, String userName, char[] password) { }