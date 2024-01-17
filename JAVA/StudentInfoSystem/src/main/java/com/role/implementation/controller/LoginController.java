package com.role.implementation.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.role.implementation.DTO.UserLoginDTO;
import com.role.implementation.model.User;
import com.role.implementation.repository.UserRepository;
import com.role.implementation.service.DefaultUserService;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
	private JavaMailSender emailSender;

@Autowired
	private DefaultUserService userService;

	@Autowired
	private UserRepository userRepository;

    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public void  loginUser(@ModelAttribute("user") 
	UserLoginDTO userLoginDTO) {
	 userService.loadUserByUsername(userLoginDTO.getUsername());
	}
//---------------------------------------------------------------------------------------------------

  
    private final Map<String, String> otpMap = new HashMap<>();

	@GetMapping("/forgot-password")
	public String forgotPassword(Model model){
	return "forgot_password/forgotpass";
	}

String email1;
	@PostMapping("/forgot-password")
	public String resetPassword(@RequestParam String email, Model model){
		User user = userRepository.findByEmail(email);
		if(user!=null){
			String otp1 = generateOTP();
			otpMap.put(email, otp1);
			sendOTPEmail(email,otp1);
            email1=email;
            System.out.println("Generated OTP: " + otp1);
System.out.println("Stored in otpMap for email " + email);
            return "forgot_password/otp-verification";
        } 
		else {
            return "/login";
        }
	}

	@PostMapping("/reset-password")
    public String resetPassword( @RequestParam String otp, @RequestParam String newPassword, Model model) {
        // Verify OTP
        String storedOTP = otpMap.get(email1);
        System.out.println("Stored OTP: " + storedOTP);
        System.out.println("User-provided OTP: " + otp);

        if (storedOTP != null && storedOTP.equals(otp)) {
            User userDetails = userRepository.findByEmail(email1);
            userDetails.setPassword(new BCryptPasswordEncoder().encode(newPassword));
            userRepository.save((User) userDetails);
            otpMap.remove(email1);
model.addAttribute("message", "Password reset successfully");
            return "/login";
        } else {
        model.addAttribute("message", "Invalid OTP ");
            return "forgot_password/otp-verification";
        }
    }

    private String generateOTP() {
        // Generate a 6-digit random OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    private void sendOTPEmail(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for password reset is: " + otp);
        emailSender.send(message);
    }
}
