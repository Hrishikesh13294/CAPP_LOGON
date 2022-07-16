package com.project.info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "projectName" }))
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String projectName;
	@Length(min = 1000, max = 9999, message = "No can not be greater or less than 4 digits")
	private int respDAE;
	@Length(min = 1000, max = 9999, message = "No can not be greater or less than 4 digits")
	private int respW;
	@Length(min = 1000, max = 9999, message = "No can not be greater or less than 4 digits")
	private int respDesigner;
	@Length(min = 1000, max = 9999, message = "No can not be greater or less than 4 digits")
	private int projectManager;

}
