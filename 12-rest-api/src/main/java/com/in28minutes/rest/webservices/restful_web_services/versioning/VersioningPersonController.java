package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    //Version APIs for Breaking Changes
    //Versioning Types:
    //1. URI Versioning
    //2. Request Parameter Versioning
    //3. Header Versioning
    //4. Media Type Versioning (a.k.a Content Negotiation or Accept Header Versioning)

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
