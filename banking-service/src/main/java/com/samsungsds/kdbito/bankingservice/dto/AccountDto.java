package com.samsungsds.kdbito.bankingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	
    private Long id;
    private String customerName;
    private String accountAlias;
    private Integer balance;
    private String remark;

}
