package com.aj.com.restful.Repo;

import com.aj.com.restful.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User, Long>{

}
