package org.example.service.purchase;

import org.example.dto.post.PostFeignReq;
import org.example.dto.post.PostFeignRes;
import org.example.dto.post.MessageRes;
import org.example.dto.purchase.PaymentsReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "postApi",url = "http://localhost:7080/Post")
//@FeignClient(name = "postApi",url = "http://KPaaS-post-service-1:7080/Post")
public interface PostFeign {
    @PostMapping("/payments/sell")
    public PostFeignRes SoldOut(@RequestBody PostFeignReq postFeignReq);

    @PostMapping(value = "/real_image",consumes = MediaType.APPLICATION_JSON_VALUE)
    public MessageRes getRealImage(@RequestParam("post_id") Long postId);
    @PostMapping("/emails/{consumer_email}")
    public String SendEmail(@RequestBody List<PaymentsReq> paymentsReqList, @PathVariable("consumer_email") String consumer_email);

}