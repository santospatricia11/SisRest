package com.sisrest.serviceSystem;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.model.entities.SystemRole;
import com.sisrest.repositories.SystemRoleRepository;


public class SystemRoleServiceImpl implements SystemRoleService{

	
	@Autowired
	private SystemRoleRepository systemRoleRepository;
	@Override
	public void createDefaultValues() {
		for (Role availableRole : Role.values()) {
			SystemRole role = findByName(availableRole.name());
			
			if(role == null) {
				role = new SystemRole();
				role.setName(availableRole.name());
				systemRoleRepository.save(role);
			}
		}
		
	}

	@Override
	public SystemRole findByName(String name) {
		if(name == null) {
			throw new IllegalStateException("Name cannot be null");
		}
		
		Optional<SystemRole> optional = systemRoleRepository.findByName(name);
		
		return optional.isPresent() ? optional.get() : null;
		
	}

	@Override
	public SystemRole findDefault() {
		return findByName(Role.ADMIN.name());
	}

}
