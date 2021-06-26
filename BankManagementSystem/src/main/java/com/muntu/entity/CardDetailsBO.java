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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Table(name = "CARD_DETAILS")
@Entity
public class CardDetailsBO {
	@Id
	@SequenceGenerator(name = "gen", sequenceName = "CARD_SEQ",initialValue =23426546,allocationSize = 3)
	@GeneratedValue(generator = "gen", strategy = GenerationType.SEQUENCE)
	private Long CardNo;
	@Column(length = 20)
	@NonNull
	private String accountType;
	@NonNull
	private Integer pin;
	@OneToOne(targetEntity = AccountDetailsBO.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)
	@PrimaryKeyJoinColumn(name="accNo",referencedColumnName = "accountNo")
	private AccountDetailsBO accountDetailsBO;
}
