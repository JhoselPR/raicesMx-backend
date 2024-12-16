package com.raicesapi.raicesmx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
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
@Table(name = "order_has_product")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderHasProduct {
	@EmbeddedId
	private OrderHasProductId orderHasProductId;
	
	@Column(name = "quantity")
	@JsonProperty("quantity")
	@Getter
	@Setter
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="order_id_fk", nullable = false, insertable = false, updatable = false)
	@JsonProperty("order_id_fk")
	@JsonBackReference
	@Getter
	@Setter
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name="product_id_fk", nullable = false, insertable = false, updatable = false)
	@JsonProperty("product_id_fk")
	@JsonBackReference
	@Getter
	@Setter
	private Product product;
}
