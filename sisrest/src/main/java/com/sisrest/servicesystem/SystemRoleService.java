package com.sisrest.servicesystem;

import com.sisrest.model.entities.SystemRole;

public interface SystemRoleService {
public enum Role{ADMIN,SERVIDOR,ESTUDANTE};
	
	public void createDefaultValues();
	
	public SystemRole findByName(String name);
	
	public SystemRole findDefault();
}
