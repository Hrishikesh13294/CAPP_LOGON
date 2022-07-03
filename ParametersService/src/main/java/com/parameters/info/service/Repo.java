package com.parameters.info.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parameters.info.entity.parameter;

@Repository
public interface Repo extends JpaRepository<parameter, Integer>{

}
