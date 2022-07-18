package com.project.info.entity;

import javax.crypto.Mac;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;
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
	@Min(value = 1000, message = "Number should be equal to 4 digits")
	@Max(value = 9999, message = "Number should be equal to 4 digits")
	private int respDAE;
	@Min(value = 1000, message = "Number should be equal to 4 digits")
	@Max(value = 9999, message = "Number should be equal to 4 digits")
	private int respW;
	@Min(value = 1000, message = "Number should be equal to 4 digits")
	@Max(value = 9999, message = "Number should be equal to 4 digits")
	private int respDesigner;
	@Min(value = 1000, message = "Number should be equal to 4 digits")
	@Max(value = 9999, message = "Number should be equal to 4 digits")
	private int projectManager;

}
