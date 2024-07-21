package com.example.soc.service;

import com.example.soc.model.Role;
import com.example.soc.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("USER").get();  //без перевірки що така роль справді існує
    }
}
