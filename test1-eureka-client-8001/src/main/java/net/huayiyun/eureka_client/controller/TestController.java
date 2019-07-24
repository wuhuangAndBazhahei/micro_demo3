package net.huayiyun.eureka_client.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import net.huayiyun.common.util.CommonCodeEnum;
import net.huayiyun.common.util.ObjectQO;
import net.huayiyun.common.util.ResultEntity;
import net.huayiyun.common.util.ResultStausEnum;
import net.huayiyun.eureka_client.pojo.qo.User;
import net.huayiyun.eureka_client.util.RedisAPIUtil;
import net.huayiyun.eureka_client.util.RedisTemplateUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereFilename;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.controller
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月26日 9:31
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@RestController
@RequestMapping("/client")
public class TestController {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private GridFsTemplate gridFsTemplate;

    @Autowired
    RedisTemplateUtil redisTemplateUtil;

    @RequestMapping("/login")
    public String login(){
        return new String("客官里面请！");
    }

    @RequestMapping("/mongo/upload")
    public String download() throws IOException{
        File file = new File("C:\\Users\\zlj\\Pictures\\mongoData\\640 (1).gif");
        InputStream context = null;
        try {
            context = new FileInputStream(file);
            //DBObject metadata = new BasicDBObject("user", "Jerry");
            //metadata 可以是object或是document
            User metadata = new User();
            metadata.setName("吾皇驾到");
            gridFsTemplate.store(context, file.getName(), "gif",metadata);
            context.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (context!=null)
                context.close();
            return new String("下载完成！");
        }
    }

    @RequestMapping("/mongo/download")
    public String upload() throws IOException{
//        List<GridFSFile> list = new ArrayList<GridFSFile>();
//        GridFSFindIterable gridFSFiles = gridFsTemplate.find(query(whereFilename().is("fb773378ad024a06ae785437aa83c3a9index1.mp3")));
//        List<GridFSFile> into = gridFSFiles.into(list);
        GridFSFile gridFSFile = gridFsTemplate.findOne(query(where("metadata.name").is("吾皇驾到")));
        GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
        InputStream inputStream = resource.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\zlj\\Desktop\\" + gridFSFile.getFilename()));
//        byte[] arr = new byte[10]; //该数组用来存入从输入文件中读取到的数据
//        int len; //变量len用来存储每次读取数据后的返回值
//        while( ( len=inputStream.read(arr) ) != -1 ) {
//            outputStream.write(arr, 0, len);
//            }//while循环：每次从输入文件读取数据后，都写入到输出文件中

        IOUtils.copy(inputStream,outputStream);
        inputStream.close();
        outputStream.close();
        return new String("上传完成！");
    }

    @RequestMapping("/redis/setKey")
    public ResultEntity redisSetKey(@RequestBody String data){
        ResultEntity entity = new ResultEntity();
        User user = JSON.parseObject(data, new TypeReference<ObjectQO<User>>() {}).getData();
        boolean userKey = redisTemplateUtil.set("userKey", user);
        entity.setStatus(ResultStausEnum.SUCCESS.getCode());
        entity.setCode(CommonCodeEnum.SUCCESS.getCode());
        entity.setMessage(CommonCodeEnum.SUCCESS.getMessage());
        return entity;
    }

    @RequestMapping("/redis/getKey")
    public ResultEntity redisGetKey(){
        ResultEntity entity = new ResultEntity();
        User userKey = redisTemplateUtil.get("userKey", User.class);
        entity.setStatus(ResultStausEnum.SUCCESS.getCode());
        entity.setCode(CommonCodeEnum.SUCCESS.getCode());
        entity.setMessage(CommonCodeEnum.SUCCESS.getMessage());
        entity.setData(userKey);
        return entity;
    }

    @RequestMapping("/redis/delKey")
    public ResultEntity redisDelKey(){
        ResultEntity entity = new ResultEntity();
        redisTemplateUtil.deleteById("userKey");
        entity.setStatus(ResultStausEnum.SUCCESS.getCode());
        entity.setCode(CommonCodeEnum.SUCCESS.getCode());
        entity.setMessage(CommonCodeEnum.SUCCESS.getMessage());
        return entity;
    }


}
