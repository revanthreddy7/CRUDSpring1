package com.security.SecureApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//////import lombok.AllArgsConstructor;
//////import lombok.Data;
//////import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_details")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
    @Id
    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getWallet_amt() {
        return wallet_amt;
    }

    public void setWallet_amt(long wallet_amt) {
        this.wallet_amt = wallet_amt;
    }

    private long wallet_amt;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
