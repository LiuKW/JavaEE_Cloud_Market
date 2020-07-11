package com.vvlhw.supermarket.config;


import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102600764050";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDwXYDvsFkN67GwFVIe2rsPEIuBqHrMCkBp1Q6EOuwl6ZtqD08rXgP9judP9/cIvqqAr5B4UGCIDfpppoXiJ7sbkAe69iq607p9Gvln4Og+WKNdHyhAQPipBMnTEMc0LUXNOHnsWEhMwAhlU6MA9/8ZmrYCSOdQvRH9A6BcrOtePtkDtSl5MjLyxRLhdvv2KPW2CSwwSNOj1pu8ufZqle++Y6xVRxs69wMWm56RHp0QovzsX4AFuW4WQin9JqI15qs4HjsnWoyptqbRZPJdMsD/X2h2cexEyRe++yvdtQW67n1QXgabCQuoez4vWVbfynp4FMpsPUYc5haht6n9/nUpAgMBAAECggEAT0PGfUR+WaTcF+EwD5S6EyG1n7BbrmXDECN+ggScU3RSGAusY/TBBCDYDvsKsAuQVpeO4N5Atx1E8wpDJG1Nuq0on3MGbE3eNdtrW+JDNCwu00qvD2Fdnv9BPyVNS9uSJTb2ngYO8aByJFgMbQlbSqpGU0KPZYS0JefIPkeX5p/XfMMb2TjmOZyfl/sZQEgZOBxS90k7N3+y6FZHi1gaxZcHKXM0TnbnbKC5o/Isbar0I2lnPDUd7ysXcmkuanYwKqjyMlHTCZSg3GVknYlKQfYnI846P6F5lsEp60P+hKUJwAg2D2BYvUg3s7sT6EVh6PV2C+Y0HtbdawXpB8mVsQKBgQD5qq+ALWAwJ/fXjbD3b+PVkLBD0gVE5nj0GihlxssWlq+stu6FieKAiy2NECEcWhtyvsZVP5JrrwddmbA6gbvow7gaOZ7oDKVDM4u9DT5DCgEvd5aUfJclHSw5osTzg7EAEnn7ajx1hhGQ3bLsnbtvQ2f/bJPbko/7gKzu86QY+wKBgQD2dmo+fsslrqvENDuynCTjfuEXhFsfq3f4XzndMDvr/iDrMQ6mQV1oNNDIn7IFMUD3yjjPW1nrLuGkwpim3fMypJ6k5McX2fTiWU8IdIK7g+7REMxMe7muHcWmy2FKcxZ3WpSbtTNm7G81fifFDEQVslZJcVN3dosHEIONQA1ZKwKBgQCNLaKOJZqFwKQaZMoUMVYxVt8FisZl/rmYtw3u92mx/UWbsdnQ83Z8X7dDVEKU6LMqwIwgepFOiSvuFtEbVG8woTQCyGB+MWBmTsiO/+UcPZUMBWDF2GoTl5qBgPREC0zUkJ4fuCQ2BLj8JRFfUZZCxWgSfJBjkk4O1uVzPZymbwKBgAgjWNa/cQ3Jerp7zwzSwxUP93bDVA7zpn55BnwbP59HQOcDM6yhs+fg9pPpUgOB4NdNwhp2tb1iSukZ09iOs50UeniPZVOQStm+gTGSR07RyGz21QghfbwWF5SuWoQO0MsYHpgVn6DiZbmqdL247faZcOfz6gGj1GtjTDS5zLcJAoGBAOOxGOhiBgbw1nt0KQXaPaWwdmd8Vb8r90IpVtDWyVdgy2aK2zYS6Of3sD/gqzrCH5Ot5sMWuUcP/4QCf3+cIR9Zc5O+eWF4Q5Dx9AIncIf+uXHLJfuTCzQ7N1qJu+KpkqvVIgy/ZWURDZR49+op+wOrfAF0elCnTgFKwgpXITjL";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuLhpakL105WcpkR/812l9OW7+8KE4I9Nx+mu20DGhFHZGgIWw+ppRbslSsl6hVWzUNk/0HPCHbxU/mWQxp3QRlynlxQ50UGpns57+gwSntR9DL4TF9Yemz4pHFC4qRY8Os24NDifmGOXe4ITFUOipnWXMRIwOBUa4laEnYnZgBpT/VcX9hqK/CDNE9WB9RX6o1oCBUL1woRr6DKtMT7/CBtG05Nwbc3PRD20xJEJ03/uh+/qbTFPlAqvyoeIjoD8GNNx9x3mfsC74aDUNUj2LzTFQGAQf93qxRI4PazIFT08BeZvZERbvp5YRAgWxaohZ82APrTfqbVeX6B0X/m42wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kingwait.com/supermarket/user-order/checkpay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://kingwait.com/supermarket/user-order/checkpay";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志信息
    public static String log_path = "D:\\Alipay";


    //日志
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}