package com.raicesapi.raicesmx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_subscription")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_subscription_id")
	@Getter
	@Setter
	private Integer user_subscription_id;
	
	@Column(name = "start_date")
	@JsonProperty("start_date")
	@Getter
	@Setter
	private String start_date;
	
	@Column(name = "end_date")
	@JsonProperty("end_date")
	@Getter
	@Setter
	private String end_date;
	
	@Column(name = "is_active")
	@JsonProperty("is_active")
	@Getter
	@Setter
	private boolean is_active;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	@JsonProperty("user_id")
	@JsonBackReference
	@Getter
	@Setter
	private User user_id_fk;
	
	@ManyToOne
	@JoinColumn(name="subscription_id", nullable = false)
	@JsonProperty("subscription_id")
	@JsonBackReference
	@Getter
	@Setter
	private Subscription subscription_id_fk;
}
