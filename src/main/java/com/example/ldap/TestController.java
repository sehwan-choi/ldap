package com.example.ldap;

import lombok.RequiredArgsConstructor;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final LdapTemplate ldapTemplate;

    @GetMapping("/{username}")
    public Collection<Person> test(String userName) {
        LdapQuery qry = LdapQueryBuilder.query().where("cn").is("admin");
        return ldapTemplate.find(qry, Person.class);
    }

    @GetMapping
    public Collection<Person> test() {
        LdapQuery qry = LdapQueryBuilder.query().where("objectClass").isPresent();
        return ldapTemplate.find(qry, Person.class);
    }
}
