package com.samsungsds.kdbito.bankingservice.service.impl;

import java.util.Map;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.samsungsds.kdbito.bankingservice.service.BasicService;

import lombok.RequiredArgsConstructor;

@Service
public class BasicServiceImpl implements BasicService {
	
	
	@Override
	public Map<String, Object> getBasicData() {
		// TODO Auto-generated method stub
		Map<String, Object> firstData = new HashMap<>();

		firstData.put("label1", "check1");
		firstData.put("label2", "check2");
		firstData.put("label3", "check3");

		return firstData;
	}
	
}
