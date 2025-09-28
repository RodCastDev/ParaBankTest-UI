package co.com.encora.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class UserData {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String ssn;
    private String username;
    private String password;

    public static UserData fromMap(Map<String, String> row, String generatedUsername, String generatedPassword) {
        return new UserData(
                row.get("firstName"),
                row.get("lastName"),
                row.get("address"),
                row.get("city"),
                row.get("state"),
                row.get("zipCode"),
                row.get("phone"),
                row.get("ssn"),
                generatedUsername,
                generatedPassword
        );
    }
}
