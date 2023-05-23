package com.MyWorkFolio.MyWorkFolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MyWorkFolio.MyWorkFolio.Model.User;

@Repository
@Transactional
public interface UserRepostiory extends JpaRepository<User,Integer>{

	public void deleteUserById(Integer userId);
}
