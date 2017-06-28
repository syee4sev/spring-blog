package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by everardosifuentes on 6/22/17.
 */
public interface PostRepository extends CrudRepository<Post, Long>  {


    Post findByTitle(String title);
//    Post findByTitleIsLike(String title);



}
