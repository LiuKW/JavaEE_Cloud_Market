package com.vvlhw.supermarket.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;

public class SendMsgUtil {

    public static synchronized boolean sendMsg(String phoneNum, String code)
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
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "恺威kingwait");
        request.putQueryParameter("TemplateCode", "SMS_195860979");

        // 构建一个短信验证码
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));


        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

}
