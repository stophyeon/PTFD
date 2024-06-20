package org.example.service;
import org.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService PostService;
    @Autowired
    private PostRepository PostRepository;
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CountDownLatch latch = new CountDownLatch(2);
//    @BeforeEach
//    void setUp() {
//        PostRepository.save(Post.builder().PostName("커피").userEmail("j6778@naver.com").price(3000).build());
//    }
//    @Test
//    void MultiThread() throws IOException, InterruptedException {
//        SuccessRes result1 = new SuccessRes();
//        AtomicBoolean result2 = new AtomicBoolean();
//
//        PostDto dto1 = PostDto.builder()
//                .Post_name("커피")
//                .price(2500)
//                .build();
//        executorService.execute(()->{
//            try {
//                System.out.println("수정 쿼리 시작");
//                PostService.updatePost(1L,dto1,"j6778@naver.com");
//                System.out.println("수정 쿼리 끝");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            latch.countDown();
//        });
//        executorService.execute(()->{
//            System.out.println("조회 쿼리 시작");
//            int price = PostService.findPostDetail(1L).getPost().getPrice();
//            System.out.println("조회 가격 = " + price);
//            result2.set(price==2500);
//            System.out.println("조회 쿼리 끝");
//            latch.countDown();
//        });
//        latch.await();
//        System.out.println(result2.get());
//    }
}