package com.samsungsds.kdbito.bankingservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samsungsds.kdbito.bankingservice.entity.Account;
import com.samsungsds.kdbito.bankingservice.service.AccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService accountService;
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@GetMapping("/accounts")
	public String index(Model model) {
		List<Account> accounts = accountService.getAllAccounts();
		model.addAttribute("accounts", accounts);
		logger.info("getAccounts 호출!!!" + accounts.toString());
		return "accounts";
	}

	@GetMapping("/accounts/{id}")
	public String showAccountDetail(@PathVariable Long id, Model model) {
		Optional<Account> account = accountService.getAccountById(id);
		if (account.isPresent()) {
			model.addAttribute("account", account.get());
		} else {
			model.addAttribute("errorMessage", "해당 계좌를 찾을 수 없습니다.");
		}
		return "view";
	}

	@GetMapping("/accounts/add")
	public String openAccountForm(Model model) {
		model.addAttribute("account", new Account());
		return "add";
	}

	@PostMapping("/accounts/add")
	public String openAccount(@ModelAttribute Account account, RedirectAttributes redirectAttributes) {
		accountService.saveAccount(account);
		redirectAttributes.addFlashAttribute("message", "계좌가 개설되었습니다.");
		return "redirect:/accounts";
	}

	@GetMapping("/accounts/{id}/edit")
	public String editAccountForm(@PathVariable("id") Long id, Model model) {

		Optional<Account> account = accountService.getAccountById(id);

		logger.info("editAccountForm 호출!!!" + account.toString());

		model.addAttribute("account", account);
		return "edit";
	}

	@PostMapping("/accounts/{id}/edit")
	public String editAccount(@PathVariable("id") Long id, @ModelAttribute Account account,
			RedirectAttributes redirectAttributes) {
		accountService.saveAccount(account);
		redirectAttributes.addFlashAttribute("message", "계좌가 수정되었습니다.");
		return "redirect:/accounts";
	}

	@GetMapping("/accounts/{id}/delete")
	public String closeAccount(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		accountService.deleteAccountById(id);
		redirectAttributes.addFlashAttribute("message", "계좌가가 해지되었습니다.");
		return "redirect:/accounts";
	}

}
