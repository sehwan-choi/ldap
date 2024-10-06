package com.example.ldap;

import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@Entry(base = "dc=company,dc=com", objectClasses = {"inetOrgPerson", "organizationalPerson", "person","top"})
public class Person {

    @Id
    private Name dn; // DN을 저장하는 필드, javax.naming.Name 타입

    @Attribute(name = "cn")
    private String fullName;

    @Attribute(name = "sn")
    private String lastName;

    @Attribute(name = "mail")
    private String email;

    @Attribute(name = "telephoneNumber")
    private String phoneNumber;

    @Attribute(name = "sn")
    private String sn;

    @Attribute(name = "uid")
    private String uid;

    @Attribute(name = "userPassword")
    private String userPassword;

    @Attribute(name = "ou")
    private String ou;

    @Attribute(name = "title")
    private String title;

    @Attribute(name = "description")
    private String description;
}
