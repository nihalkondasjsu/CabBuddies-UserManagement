package com.cabbuddies.usermanagement.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabbuddieslib.data.user.UserDetails;

public interface UserDetailsJPA extends JpaRepository<UserDetails,Long>{

}
