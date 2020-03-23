package edu.nf.shopping.comment.entity;

import edu.nf.shopping.goods.entity.ImgsType;
import lombok.Data;

/**
 * @author Achine
 * @date 2020/2/26
 */
@Data
public class ImgInfo {
    private String imgId;
    private String imgName;
    private String imgFile;
    private Integer imgType;
}
