package com.yun.redis02springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
// 在企业开发中，所有的对象都需要序列化
public class User implements Serializable {
    private String name;
    private Integer age;
}
