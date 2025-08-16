package com.example.productservice_aug25.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModal {
    private Long id;
    private Date createTime;
    private Date lastModifyAt;
}
