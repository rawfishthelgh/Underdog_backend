package com.underdogCounty.underdogCountyProject.domain.application.entity;

import com.underdogCounty.underdogCountyProject.domain.application.dto.ApplicationRequestDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application {
    @Id @GeneratedValue
    private Long id;
    @Column(length = 20,nullable = false)
    private String name;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 20,nullable = false)
    private String phoneNumber;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Builder
    public Application(String name, String email, String phoneNumber, String contents){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.contents=contents;
    }

    public void update(ApplicationRequestDto applicationRequestDto){
        this.name = applicationRequestDto.getName();
        this.email = applicationRequestDto.getEmail();
        this.contents = applicationRequestDto.getContents();
    }
}
