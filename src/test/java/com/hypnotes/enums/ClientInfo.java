package com.hypnotes.enums;

import java.util.List;

public enum ClientInfo {
    client(List.of(0,0,1930,1760),"orhan","gulmez","test_orhan_gulmez@mailsac.com","A123456asdfa.,") //Arrays.asList(1760) 0-> enterprise
    ;
    private List<Integer> clientId;
    private String firstName, lastName, email, password;

    ClientInfo(List<Integer> clientId, String firstName, String lastName, String email, String password) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public List<Integer> getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
