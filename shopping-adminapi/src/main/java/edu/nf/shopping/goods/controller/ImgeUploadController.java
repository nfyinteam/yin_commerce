package edu.nf.shopping.goods.controller;

import edu.nf.shopping.util.FIleNameUtils;
import edu.nf.shopping.util.UploadAddressUtils;
import edu.nf.shopping.vo.BaseController;
import edu.nf.shopping.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Achine
 * @date 2020/3/13
 */
@RestController
public class ImgeUploadController extends BaseController {
    @Autowired
    private RestTemplate rest;

    @PostMapping("/imgeUpload")
    @ApiOperation(value = "上传图片", notes = "上传单张照片到文件服务器",
            httpMethod = "post")
    public ResponseVO uploadImage(MultipartFile file) throws IOException{
        File newFile = file.getResource().getFile();
        FileSystemResource resource = new FileSystemResource(newFile);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", resource);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(param);
        ResponseEntity<String> responseEntity = rest.exchange(UploadAddressUtils.GOODS_IMGES, HttpMethod.POST, httpEntity, String.class);
        return success(200);
    }
}
