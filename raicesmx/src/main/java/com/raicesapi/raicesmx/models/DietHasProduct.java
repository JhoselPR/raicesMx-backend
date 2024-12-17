package com.raicesapi.raicesmx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "diet_has_product")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DietHasProduct {
	@EmbeddedId
	private DietHasProductId dietHasProductId;
	
	@ManyToOne
	@JoinColumn(name="diet_id_fk", nullable = false, insertable = false, updatable = false)
	@JsonProperty("diet_id_fk")
	@JsonBackReference("diet-product")
	@Getter
	@Setter
	private Diet diet;
	
	@ManyToOne
	@JoinColumn(name="product_id_fk", nullable = false, insertable = false, updatable = false)
	@JsonProperty("product_id_fk")
	@JsonBackReference("product-diet")
	@Getter
	@Setter
	private Product product;
}