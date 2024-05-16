package org.example.dto.product;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SendProduct {
    private String productName;
    private String image_real;

    @Builder
    public SendProduct(String productName,String image_real){
        this.image_real=image_real;
        this.productName=productName;
    }
}
