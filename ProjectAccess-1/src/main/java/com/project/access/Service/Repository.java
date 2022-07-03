package com.project.access.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.access.Entity.AccessEntity;
@Service
public interface Repository extends JpaRepository<AccessEntity, Integer>{

}
