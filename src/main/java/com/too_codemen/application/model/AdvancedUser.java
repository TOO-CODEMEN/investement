package com.too_codemen.application.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "advancedUser")
public class AdvancedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "email")
    String email;

    @Column(name = "orgName")
    String orgName;

    @Column(name = "INN")
    int INN; //ИНН

    @Column(name = "webSiteUrl")
    String webSiteUrl;

    @Column(name = "industry")
    String industry;

    @Column(name = "country")
    String country;

    @Column(name = "city")
    String city;

    @Column(name = "position")
    String position;

}
