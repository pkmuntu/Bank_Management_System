package com.muntu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Table(name = "ACCOUNT_DETAILS")
@Entity
public class AccountDetailsBO2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	@Column(length = 20)
	@NonNull
	private String religion;
	@NonNull
	@Column(length = 20)
	private String category;
	private Float income;
	@Column(length = 20)
	private String education;
	@Column(length = 20)
	private String occupation;
	@Column(length = 20)
	@NonNull
	private String pan;
	@NonNull
	private Integer aadhar;
	@Column(length = 20)
	private String scitizen;
	@Column(length = 20)
	private String eaccount;
	@OneToOne(targetEntity = AccountDetailsBO.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)
	@PrimaryKeyJoinColumn(name="accNo",referencedColumnName = "accountNo")
	private AccountDetailsBO accountDetailsBO;
}
