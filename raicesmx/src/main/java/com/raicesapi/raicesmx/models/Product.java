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
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	@JsonProperty("product_id")
	@Getter
	@Setter
	private Integer product_id;
	
	@Column(name = "name")
	@JsonProperty("name")
	@Getter
	@Setter
	private String name;
	
	@Column(name = "description")
	@JsonProperty("description")
	@Getter
	@Setter
	private String description;
	
	@Column(name = "ingredients")
	@JsonProperty("ingredients")
	@Getter
	@Setter
	private String ingredients;
	
	@Column(name = "meal_time")
	@JsonProperty("meal_time")
	@Getter
	@Setter
	private String meal_time;
	
	@Column(name = "image")
	@JsonProperty("image")
	@Getter
	@Setter
	private byte[] image;
	
	@Column(name = "price")
	@JsonProperty("price")
	@Getter
	@Setter
	private int price;
	
	@Column(name = "extras")
	@JsonProperty("extras")
	@Getter
	@Setter
	private String extras;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter
	@Setter
	private Set<OrderHasProduct> order_has_product = new HashSet<>();
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter
	@Setter
	private Set<DietHasProduct> diet_has_product = new HashSet<>();
}
