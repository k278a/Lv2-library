package com.sparta.library.dto;

import com.sparta.library.entity.User;

public class UserResponseDto {
    private Long id;
    private String username;
    private String gender;
    private String ssn;    //user 주민번호
    private String upn;    //user 전화번호
    private String useradress;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.gender = user.getGender();
        this.upn = user.getUpn();
        this.useradress = user.getUseradress();

    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getGender() {
        return gender;
    }
    public String getSsn() {
        return ssn;
    }
    public String getUpn() {
        return upn;
    }
    public String getUseradress() {
        return useradress;
    }

}
