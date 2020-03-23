package edu.nf.shopping.goods.entity;

/**
 * @author Achine
 * @date 2020/2/26
 */
public class ImgsInfo {
    private String imgId;
    private String imgName;
    private String imgFile;
    private ImgsType imgType;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public ImgsType getImgType() {
        return imgType;
    }

    public void setImgType(ImgsType imgType) {
        this.imgType = imgType;
    }
}
