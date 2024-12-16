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
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	@Getter
	@Setter
	private Integer user_id;
	
	@Column(name = "first_name")
	@JsonProperty("first_name")
	@Getter
	@Setter
	private String first_name;
	
	@Column(name = "last_name")
	@JsonProperty("last_name")
	@Getter
	@Setter
	private String last_name;
	
	@Column(name = "email")
	@JsonProperty("email")
	@Getter
	@Setter
	private String email;
	
	@Column(name = "password")
	@JsonProperty("password")
	@Getter
	@Setter
	private String password;
	
	@Column(name = "birthdate")
	@JsonProperty("birthdate")
	@Getter
	@Setter
	private String birthdate;
	
	@Column(name = "address")
	@JsonProperty("address")
	@Getter
	@Setter
	private String address;
	
	@Column(name = "phone")
	@JsonProperty("phone")
	@Getter
	@Setter
	private String phone;
	
	@Column(name = "role")
	@JsonProperty("role")
	@Getter
	@Setter
	private String role;
	
	@OneToMany(mappedBy = "user_id_fk", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter
	@Setter
	private Set<Orders> orders = new HashSet<>();
	
	/*@OneToMany(mappedBy = "user_subscription", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Getter
	@Setter
	private Set<UserSubscription> user_subscription = new HashSet<>();*/
	
}
