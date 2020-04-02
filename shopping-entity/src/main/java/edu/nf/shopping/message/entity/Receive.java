package edu.nf.shopping.message.entity;

import lombok.Data;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
@Data
public class Receive {
    private String reId;
    private String messageId;
    private String userId;
    private String state;
}