package com.gxa;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class IndexDemo {

    private  RestHighLevelClient client;
    @Before
    public void init(){
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.10.12",9200,"http"))
        );
    }


    @Test
    public void test01() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        //创建索引
        CreateIndexResponse response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        System.out.println(response.isAcknowledged());

    }
    @Test
    public void test02() throws IOException {
// 查询索引 - 请求对象
        GetIndexRequest request = new GetIndexRequest("user");
// 发送请求，获取响应
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        System.out.println("aliases:"+response.getAliases());
        System.out.println("mappings:"+response.getMappings());
        System.out.println("settings:"+response.getSettings());
    }
    @Test
    public void test03() throws IOException {
// 删除索引 - 请求对象
        DeleteIndexRequest request = new DeleteIndexRequest("user");
// 发送请求，获取响应
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
// 操作结果
        System.out.println("操作结果 ： " + response.isAcknowledged());
    }
}
