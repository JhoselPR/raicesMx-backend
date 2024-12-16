package com.raicesapi.raicesmx.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DietHasProductId implements Serializable{
	@Column(name = "diet_id_fk")
	@JsonProperty("diet_id_fk")
    private Integer dietId;
	
	@Column(name = "product_id_fk")
	@JsonProperty("product_id_fk")
    private Integer productId;
}
