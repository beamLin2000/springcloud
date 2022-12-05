package com.gxa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gxa.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DocumentDemo {
    private RestHighLevelClient client;
    @Before
    public void init(){
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.10.12",9200,"http"))
        );
    }

    @Test
    public void test01() throws IOException {
// 新增文档 - 请求对象
        IndexRequest request = new IndexRequest();
// 设置索引及唯一性标识
        request.index("user").id("1001");
// 创建数据对象
        User user = new User();
        user.setName("zhangsan");
        user.setAge(30);
        user.setSex("男");
        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(user);
// 添加文档数据，数据格式为JSON格式
        request.source(productJson, XContentType.JSON);
// 客户端发送请求，获取响应对象
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
////3.打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_id:" + response.getId());
        System.out.println("_result:" + response.getResult());
    }
    @Test
    public void test02() throws IOException {
        // 修改文档 - 请求对象
        UpdateRequest request = new UpdateRequest();
// 配置修改参数
        request.index("user").id("1001");
// 设置请求体，对数据进行修改
        request.doc(XContentType.JSON, "sex", "女");
// 客户端发送请求，获取响应对象
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println("_index:" + response.getIndex());
        System.out.println("_id:" + response.getId());
        System.out.println("_result:" + response.getResult());
    }
    @Test
    public void test03() throws IOException {
        //1.创建请求对象
        GetRequest request = new GetRequest().index("user").id("1001");
//2.客户端发送请求，获取响应对象
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
////3.打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_type:" + response.getType());
        System.out.println("_id:" + response.getId());
        System.out.println("source:" + response.getSourceAsString());

    }
    @Test
    public void test04() throws IOException {
        //创建请求对象
        DeleteRequest request = new DeleteRequest().index("user").id("1001");
//客户端发送请求，获取响应对象
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
//打印信息
        System.out.println(response.toString());

    }
    @Test
    public void test05() throws IOException {

        //创建批量新增请求对象
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "lisi"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu"));
//客户端发送请求，获取响应对象
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
//打印结果信息
        System.out.println("took:" + responses.getTook());
        System.out.println("items:" + responses.getItems());

    }
    @Test
    public void test06() throws IOException {
        //创建批量删除请求对象
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("user").id("1001"));
        request.add(new DeleteRequest().index("user").id("1002"));
        request.add(new DeleteRequest().index("user").id("1003"));
//客户端发送请求，获取响应对象
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
//打印结果信息
        System.out.println("took:" + responses.getTook());
        System.out.println("items:" + responses.getItems());


    }
}
