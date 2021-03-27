package com.davondevelops.budgetApp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.davondevelops.budgetApp.models.Expenses;
import com.davondevelops.budgetApp.models.Income;
import com.davondevelops.budgetApp.models.Savings;
import com.davondevelops.budgetApp.models.User;
import com.davondevelops.budgetApp.services.MainService;
import com.davondevelops.budgetApp.services.UserService;
import com.davondevelops.budgetApp.validations.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	 private final UserValidator userValidator;
	 private final MainService mainService;

	 

	
	

	public MainController(UserService userService, UserValidator userValidator, MainService mainService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.mainService = mainService;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			userService.registerUser(user);
			session.setAttribute("loggedInUser", user);
			return "redirect:/welcome";
		}
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("email") String email,@RequestParam("password") String password, RedirectAttributes result) {
		if(userService.authenticateUser(email, password)) {
			session.setAttribute("loggedInUser", userService.findByEmail(email));
			return "redirect:/dashboard";
		}
		else {
			result.addFlashAttribute("error", "Invalid Login Attempt");
			return "redirect:/";
		}
	}
	@RequestMapping("/welcome")
	public String welcome(HttpSession session, Model model) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("user",user);
			
			return "welcome.jsp";
		}
	}
	
	@RequestMapping("/revenues/new")
	public String newRevenues(@ModelAttribute("income") Income income, HttpSession session, Model model) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("user",user);
			
			return "newRevenue.jsp";
		}
	}
	
	@PostMapping("/revenue/add")
	public String addRevenue(@Valid @ModelAttribute("income") Income income, BindingResult result, HttpSession session ) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		else {
			if(result.hasErrors()) {
				return "newRevenue.jsp";
			}
			mainService.newRevenue(income);
			return "redirect:/revenue/more";
		}
	}
	
	@RequestMapping("revenue/more")
	public String moreRevenues(HttpSession session) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		return "moreRevenues.jsp";
	}
	
	@RequestMapping("/expense/new")
	public String newExpense(@ModelAttribute("expense") Expenses expense, HttpSession session, Model model) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("user",user);
			
			return "newExpense.jsp";
		}
	}
	
	@PostMapping("/expense/add")
	public String addExpense(@Valid @ModelAttribute("expense") Expenses expense, BindingResult result, HttpSession session ) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		else {
			if(result.hasErrors()) {
				return "newExpense.jsp";
			}
			mainService.newExpense(expense);
			return "redirect:/expenses/more";
		}
	}
	
	@RequestMapping("expenses/more")
	public String moreExpenses(HttpSession session) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		return "moreExpenses.jsp";
	}
	
	
	@RequestMapping("/savings/add")
	public String addSavings(@ModelAttribute("savings") Savings savings, HttpSession session, Model model) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		model.addAttribute("user",user);
		return "savings.jsp";
	}
	
	@PostMapping("/savings/update")
	public String updateSavings(@Valid @ModelAttribute("savings") Savings savings, BindingResult result, HttpSession session ) {
		User user =(User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		mainService.saveSavings(savings);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		float weeklyIncome= mainService.calculateWeeklyIncome(user);
		Savings savings=mainService.findSavings(user);
		float weeklyExpenses= mainService.calculateWeeklyExpenses(user);
		model.addAttribute("user", user);
		model.addAttribute("weeklyExpenses", weeklyExpenses);
		model.addAttribute("savings", savings);
		model.addAttribute("weeklyIncome", weeklyIncome);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/schedule")
	public String schedule(HttpSession session, Model model){
		User user= (User) session.getAttribute("loggedInUser");
		if(user==null) {
			return "redirect:/";
		}
		List <Expenses>expenses=mainService.findExpenses(user);
		Savings savings=mainService.findSavings(user);
		List <Income> income=mainService.findRevenues(user);
		model.addAttribute("user", user);
		model.addAttribute("income", income);
		model.addAttribute("savings", savings);
		model.addAttribute("expenses", expenses);
		return "schedule.jsp";
	}
}
