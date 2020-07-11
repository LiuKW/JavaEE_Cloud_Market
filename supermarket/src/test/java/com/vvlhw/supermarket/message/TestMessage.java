package com.vvlhw.supermarket.message;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.vvlhw.supermarket.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class TestMessage {

    @Test
    void testSendMessage()
    {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GDTQEyrJ7Tr7ZZXAXBG", "5FDgNY8FsteR2I1KZxWAvyQWpooDd4");
        IAcsClient client = new DefaultAcsClient(profile);

        // 构建请求
        CommonRequest request = new CommonRequest();


        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");

        request.setSysAction("SendSms");

        //自定义参数（手机号，验证码，签名，模板）
        request.putQueryParameter("PhoneNumbers", "13018612893");
        request.putQueryParameter("SignName", "恺威kingwait");
        request.putQueryParameter("TemplateCode", "SMS_195860979");

        // 构建一个短信验证码
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 2333);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));


        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }



    @Test
    void getRandomNum()
    {
        Random random = new Random();
        Integer number = random.nextInt(9000) + 1000;
        System.out.println(number);
    }

    @Test
    void soutRandom()
    {
        for (int i = 0; i < 10; i++) {
            getRandomNum();
        }
    }

}
