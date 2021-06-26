package com.muntu.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Table(name = "ACCOUNT_DETAILS")
@Entity
public class AccountDetailsBO {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "ACCOUNT_SEQ",initialValue = 23536364,allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long accountNo;
	@Column(length = 20)
	@NonNull
	private String fName;
	@Column(length = 20)
	@NonNull
	private String middleName;
	@Column(length = 20)
	@NonNull
	private String lName;
	@NonNull
	private LocalDate dob;
	@Column(length = 1)
	@NonNull
	private String gender;
	@Column(length = 30)
	@NonNull
	private String email;
	@Column(length = 5)
	@NonNull
	private String marital;
	@Column(length = 50)
	@NonNull
	private String addr;
	@Column(length = 20)
	@NonNull
	private String city;
	@NonNull
	private Integer pinCode;
	@Column(length = 20)
	@NonNull
	private String state;
	@OneToOne(targetEntity = AccountDetailsBO2.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "accountDetailsBO")
	private AccountDetailsBO2 accountDetailsBO2;

	@NonNull
	@OneToMany(targetEntity = BankTransactionBO.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "accNo", referencedColumnName = "accountNo")
	@OrderColumn(name = "LIST_INDX") // index colum cfg
	@ListIndexBase(value = 1) // index col base value
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(FetchMode.JOIN)
	private List<BankTransactionBO> bankTransaction;

	@OneToOne(targetEntity = CardDetailsBO.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "accountDetailsBO")
	private CardDetailsBO cardDetailsBO;

}
