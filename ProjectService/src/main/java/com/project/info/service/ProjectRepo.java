package com.project.info.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.info.entity.Project;
@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{

}
