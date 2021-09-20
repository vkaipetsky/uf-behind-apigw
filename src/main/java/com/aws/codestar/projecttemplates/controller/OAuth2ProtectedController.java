package com.aws.codestar.projecttemplates.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OAuth2ProtectedController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity helloWorld() {
        return ResponseEntity.ok("{\"Output\":\"Hello, I am open to all!\"}");
    }

    @RequestMapping(value = { "/protected", "/restricted", "/api/protected", "/api/restricted" })
    public ResponseEntity helloAuthenticatedPeople() {
        return ResponseEntity.ok("{\"Output\":\"OAuth2 protected secret lair!!!\"}");
    }

    @PreAuthorize("hasAuthority('Admins')")
    @RequestMapping(value = { "/admin", "/api/admin" })
    public ResponseEntity helloAdmins() {
        return ResponseEntity.ok("{\"Output\":\"OAuth2 protected secret lair, for ADMINS only (need to be in the 'admins' group)\"}");
    }

}
