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
        return ResponseEntity.ok("Successful call: Hello from an unprotected endpoint.");
    }

    @RequestMapping(value = { "/protected", "/restricted", "/api/protected", "/api/restricted" })
    public ResponseEntity helloAuthenticatedPeople() {
        return ResponseEntity.ok("Successful call: Hello from an Okta OAuth2 protected endpoint.");
    }

    @PreAuthorize("hasAuthority('Admins')")
    @RequestMapping(value = { "/admin", "/api/admin" })
    public ResponseEntity helloAdmins() {
        return ResponseEntity.ok("Successful call: Hello from an Okta OAuth2 protected endpoint - scoped to 'Admins'.");
    }

//    @PreAuthorize("#oauth2.hasScope('defaultScope')") // TODO: sadly this crashes not being able to find the oauth2 object
    @PreAuthorize("hasAnyAuthority('SCOPE_defaultScope')")
    @RequestMapping(value = { "/scoped", "/api/scoped" })
    public ResponseEntity helloScope() {
        return ResponseEntity.ok("Successful call: Hello from an Okta OAuth2 protected endpoint - scoped to 'SCOPE_defaultScope'.");
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_developerApp')")
    @RequestMapping(value = { "/devapp", "/api/devapp" })
    public ResponseEntity helloScopedApp() {
        return ResponseEntity.ok("Successful call: Hello from an Okta OAuth2 protected endpoint - scoped to 'SCOPE_developerApp'.");
    }

}
