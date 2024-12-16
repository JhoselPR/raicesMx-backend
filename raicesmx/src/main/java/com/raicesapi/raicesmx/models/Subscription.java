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
@Table(name = "subscription")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id")
	@JsonProperty("subscription_id")
	@Getter
	@Setter
	private Integer subscription_id;
	
	@Column(name = "subscription_type")
	@JsonProperty("subscription_type")
	@Getter
	@Setter
	private String subscription_type;
	
	@Column(name = "benefits")
	@JsonProperty("benefits")
	@Getter
	@Setter
	private String benefits;
	
	@Column(name = "price")
	@JsonProperty("price")
	@Getter
	@Setter
	private int price;
	
	@OneToMany(mappedBy = "subscription_id", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter
	@Setter
	private Set<UserSubscription> user_subscription = new HashSet<>();
}
