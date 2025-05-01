package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @GetMapping("/public/resource")
    public String publicResource() {
        return "This is a public resource";
    }

    @GetMapping("/user/resource")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userResource() {
        return "This is a user resource";
    }

    @GetMapping("/admin/resource")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminResource() {
        return "This is an admin resource";
    }
}