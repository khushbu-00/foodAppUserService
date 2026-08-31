package com.foodapp.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Users")
public class User {

	
	

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userId")
		@SequenceGenerator( name ="userId",
		sequenceName = "userId", 
		initialValue=100,
		allocationSize = 1)
		private Integer userId;
		
		@NotBlank(message ="Name is required")
		private String name;
		
//		@Pattern(regexp = "^[A-Za-z0-9+_.-]@[A-Za-z0-9.-]$")
		@NotBlank(message="Email cannot be leave empty")
		@Email(message ="Invalid email format")
		private String email;
		
		@NotNull
		@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain 10 digits")
		private String phonenumber;
		
		@NotBlank(message ="Address is required")
		private String address;
		
	}

