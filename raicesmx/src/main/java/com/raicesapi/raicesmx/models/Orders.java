package com.raicesapi.raicesmx.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	@JsonProperty("order_id")
	@Getter
	@Setter
	private Integer order_id;
	
	@Column(name = "date_time")
	@JsonProperty("date_time")
	@Getter
	@Setter
	private String date_time;
	
	@Column(name = "notes")
	@JsonProperty("notes")
	@Getter
	@Setter
	private String notes;
	
	@Column(name = "quantity")
	@JsonProperty("quantity")
	@Getter
	@Setter
	private int quantity;
	
	@Column(name = "status")
	@JsonProperty("status")
	@Getter
	@Setter
	private String status;
	
	@ManyToOne
	@JoinColumn(name="user_id_fk", nullable = false)
	@JsonProperty("user_id_fk")
	@JsonBackReference
	@Getter
	@Setter
	private User user_id_fk;
	
	/*@OneToMany(mappedBy = "order_has_product", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter
	@Setter
	private Set<OrderHasProduct> order_has_product = new HashSet<>();*/
	
	 @JsonGetter("user_name")
	    public String getUserName() {
	        return user_id_fk.getFirst_name() + " " + user_id_fk.getLast_name();
	    }

	    @JsonGetter("user_address")
	    public String getUserAddress() {
	        return user_id_fk.getAddress();
	    }
	    @JsonGetter("user_email")
	    public String getEmail() {
	        return user_id_fk.getEmail();
	    }
}
