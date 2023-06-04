package com.project.scolarite.services;

import java.util.List;

import com.project.scolarite.entities.Admin;

public interface AdminServises {

	
		
		
		
		Admin saveAdmin(Admin A);
		Admin updateAdmin(Admin A);
		void deletAdmin(Admin A);
		void deletAdminById(Long id);
		Admin getAdmin(Long id);
		List<Admin> getAllAdmin();
		

	}

