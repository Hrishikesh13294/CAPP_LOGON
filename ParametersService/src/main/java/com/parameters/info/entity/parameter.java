package com.parameters.info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class parameter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String stdCode;
	private double KAPR1;
	private double PSIR;
	private double MTP;
	private double RMPX;

}
