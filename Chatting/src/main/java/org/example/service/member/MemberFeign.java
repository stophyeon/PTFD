package org.example.service.member;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "memberApi",url = "http://localhost:8080/member")
//@FeignClient(name = "memberApi",url = "http://KPaaS-member-service-1:8080/member")
public interface MemberFeign {
}
