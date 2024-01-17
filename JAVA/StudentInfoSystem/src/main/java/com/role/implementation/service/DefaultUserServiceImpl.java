package com.role.implementation.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.role.implementation.DTO.UserRegisteredDTO;
import com.role.implementation.model.Role;
import com.role.implementation.model.Student;
import com.role.implementation.model.Teacher;
import com.role.implementation.model.User;
import com.role.implementation.repository.RoleRepository;
import com.role.implementation.repository.StudentRepository;
import com.role.implementation.repository.TeacherRepository;
import com.role.implementation.repository.UserRepository;

@Service
@Transactional
public class DefaultUserServiceImpl implements DefaultUserService{
   @Autowired
	private UserRepository userRepo;
   @Autowired
    private RoleRepository roleRepo;
	@Autowired 
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
   
   
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public User save(UserRegisteredDTO userRegisteredDTO) {
		Role role = new Role();
		if(userRegisteredDTO.getRole().equals("USER")){
		  role = roleRepo.findByRole("USER");
		  Student student = new Student();
		  student.setSname(userRegisteredDTO.getName());
		  studentRepository.save(student);
		}
		 else if(userRegisteredDTO.getRole().equals("FACULTY")){
		 role = roleRepo.findByRole("FACULTY");
		 Teacher teacher=new Teacher();
		 teacher.setTname(userRegisteredDTO.getName());
		 teacherRepository.save(teacher);
		 }
		 else if(userRegisteredDTO.getRole().equals("ADMIN"))
		 {
			role = roleRepo.findByRole("ADMIN");
		   }
		User user = new User();
		user.setEmail(userRegisteredDTO.getEmail_id());
		user.setName(userRegisteredDTO.getName());
		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
		user.setRole(role);
		
		return userRepo.save(user);
	}
}
