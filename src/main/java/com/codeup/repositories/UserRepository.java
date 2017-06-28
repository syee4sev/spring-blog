package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by everardosifuentes on 6/23/17.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

        public User findByUsername(String username);


}
