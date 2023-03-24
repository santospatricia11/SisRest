package com.sisrest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisrest.configuration.security.CurrentUser;
import com.sisrest.configuration.security.UserPrincipal;
import com.sisrest.exception.ResourceNotFoundException;
import com.sisrest.model.entities.UsuarioGoogle;
import com.sisrest.repositories.UsuarioGoogleRepository;

@RestController
public class UsuarioGoogleController {

	@Autowired
	private UsuarioGoogleRepository userRepository;


    @GetMapping("/api/user/me")
    @PreAuthorize("hasRole('USER')")
    public UsuarioGoogle getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
