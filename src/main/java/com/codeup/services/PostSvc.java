package com.codeup.services;

import com.codeup.models.Post;
import com.codeup.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by everardosifuentes on 6/20/17.
 */
@Service("PostSvc")
public class PostSvc {
    private PostRepository postDao;

//    private List<Post> posts = new ArrayList<Post>();

//    @Service("PostSvc")
//        private List<Ad> ads;

    //  constructor
        @Autowired
        public PostSvc(PostRepository postDao) {
            this.postDao = postDao;
//            createPosts();
        }

        public Iterable<Post> findAll() {
            return postDao.findAll(); // select * from posts
        }

        public Post save(Post post) {
            postDao.save(post); // insert into posts(title, body) values(?, ?)
            return post;
        }

        public Post findOne(long id) {
            return postDao.findOne(id); // select * from posts where id = ?
        }


        public void deletePost(long id){
            postDao.delete(id);
        }

//        public Post updatePost(Post post){
//            postDao.save(post);
//            return post;
//        }

}
