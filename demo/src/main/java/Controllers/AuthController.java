package Controllers;

import Entity.Customer;
import Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/login")
    public String login() {
        return "login"; // trang login.html
    }

    @GetMapping("/api/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/api/register")
    public String register(@ModelAttribute("customer") Customer customer) {
        userService.registerCustomer(customer);
        return "redirect:/login";
    }
}
