package com.too_codemen.application.model;

import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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