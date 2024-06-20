package org.example.repository;

import jakarta.persistence.LockModeType;
import org.example.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Post findByPostId(Long id);

    @Modifying
    @Query("update Post p set p.postName = :post_name, " +
            "p.price = :price, " +
            "p.ImagePost = :image_Post, p.ImageReal = :image_real, " +
            "p.categoryId = :category_id, " +
            "p.expireAt = :expire_at " +
            "where p.postId = :post_id")
    void updatePost(@Param("post_id") Long postId,
                       @Param("post_name") String postName,
                       @Param("price") int price,
                       @Param("category_id") int categoryId,
                       @Param("expire_at") LocalDate expireAt,
                       @Param("image_Post") String imagePost,
                       @Param("image_real") String imageReal);

    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllByNickName(Pageable pageable,String nickName) ;

    @Query("SELECT p FROM Post p WHERE p.postName Like %:keyword% and p.postId != :post_id")
    List<Post> findByPostNameKeyword(@Param("keyword") String keyword,@Param("post_id") Long postId);
    //제목과 유사한 키워드에 따라서 검색하는 쿼리입니다.


    @Query("SELECT p FROM Post p WHERE p.categoryId = :category_id and p.postId != :post_id")
    List<Post> findByPostCategory(@Param("category_id") int categoryId,@Param("post_id") Long PostId,Pageable pageable);


    @Modifying
    @Query("UPDATE Post p SET p.state = :state WHERE p.postId = :post_id")
    void updateState(@Param("state") int state, @Param("post_id") Long postId) ;

    List<Post> findByPostIdIn(List<Long> postIds);

    void deleteByPostIdIn(List<Long> postIds);

    @Query("SELECT p FROM Post p WHERE p.postName LIKE %:postName% AND p.state = 1 ORDER BY p.createAt DESC")
    Page<Post> findByPostNameAndStateOrderByCreateAtDesc(@Param("postName") String postName, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.postName LIKE %:postName%")
    List<Post> findByPostName(@Param("postName") String PostName);



    @Query("select count(*) from Post p ")
    int countTuple() ; //Post 인스턴스 수 세기

    @Modifying
    @Query("UPDATE Post p SET p.state = 0 where p.expireAt <= CURRENT_DATE")
    void updatePostsStateForExpiredPosts();

    @Query("Select p FROM Post p WHERE p.state in (-1,0)")
    List<Post> findPostsExpiredOrSelled();

    @Query("SELECT p.ImageReal FROM Post p WHERE p.postId = :post_id")
    String findImageRealByPostId(@Param("post_id") Long post_id);



}
