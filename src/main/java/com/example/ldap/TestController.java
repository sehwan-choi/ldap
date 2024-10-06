package com.example.ldap;

import lombok.RequiredArgsConstructor;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final LdapTemplate ldapTemplate;

    @GetMapping("/{userName}")
    public Collection<Person> test(@PathVariable("userName") String userName) {
        LdapQuery qry = LdapQueryBuilder.query().where("cn").is(userName);
        return ldapTemplate.find(qry, Person.class);
    }

    @GetMapping
    public Collection<Person> test() {
        LdapQuery qry = LdapQueryBuilder.query().where("objectClass").isPresent();
        return ldapTemplate.find(qry, Person.class);
    }
}
