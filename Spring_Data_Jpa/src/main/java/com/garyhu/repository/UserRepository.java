package com.garyhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.garyhu.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

	public User findByName(String name);
	
	@Query("select u from User u where u.name=?1")
	public User obtainUser(String name);
	
	@Query("select u from User u where u.departmentId=?1")
	public List<User> queryUser(Integer departmentId);
	
	@Modifying
	@Query("update User u set u.name=?1 where u.id=?2")
	public int saveUser(String name,Integer id);
	
	@Query("select u from User u where u.departmentId=?1")
	public Page<User> getUser(Integer departmentId,Pageable page);
	
}
