package com.raicesapi.raicesmx.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "diet")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Diet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diet_id")
	@JsonProperty("diet_id")
	@Getter
	@Setter
	private Integer diet_id;
	
	@Column(name = "diet_type")
	@JsonProperty("diet_type")
	@Getter
	@Setter
	private String diet_type;
	
	@Column(name = "additional_info")
	@JsonProperty("additional_info")
	@Getter
	@Setter
	private String additional_info;
	
	@OneToMany(mappedBy = "diet", fetch = FetchType.LAZY)
	@JsonManagedReference("diet-product")
	@Getter
	@Setter
	private Set<DietHasProduct> diet_has_product = new HashSet<>();
	
}