package com.raicesapi.raicesmx.models;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderHasProductId implements Serializable{
	@Column(name = "product_id_fk")
	@JsonProperty("product_id_fk")
    private Integer product_id_fk;
	
	@Column(name = "order_id_fk")
	@JsonProperty("order_id_fk")
    private Integer order_id_fk;
}
