package com.muntu.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Table(name = "BANK_TRANSACTION")
@NoArgsConstructor
@Entity
public class BankTransactionBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	@NonNull
	private Long accountNo;
	@NonNull
	private LocalDate date;
	@NonNull
	@Column(length = 1)
	private String mode;
	@NonNull
	private Float amount;
}
