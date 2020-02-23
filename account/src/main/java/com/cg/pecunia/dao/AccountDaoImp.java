package com.cg.pecunia.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountException;

public class AccountDaoImp implements AccountDao {

	private Map<String,Account> map;
	
	public AccountDaoImp() {
		map = new HashMap<>();
	}
	
	@Override
	public String addAccount(Account account) throws AccountException {
		
		if(map.containsKey(account.getAccountNumber()))
				throw new AccountException("account exsist");
		else
			map.put(account.getAccountNumber(), account);
		return account.getAccountNumber();
	}

	@Override
	public List<Account> listAccounts() throws AccountException {
		
		Collection<Account> collection = map.values();
		List<Account> list = new ArrayList<>();
		for(Account a : collection)
			list.add(a);
		return list;
	}



}
