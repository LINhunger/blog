package com.qg.blog.util;

/**
 * Created by hunger on 2016/10/18.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendCommonPostMail {

    public static int  Send(String email) {
        final String url = "http://sendcloud.sohu.com/webapi/mail.send.json";
        final String apiUser = "LINhunger_test_wSjmFq";
        final String apiKey = "hnSlC9YBquMJccGs";
        final String ciphertext = Encryption.getMD5(email);

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost(url);

        List params = new ArrayList();
        // 不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
        params.add(new BasicNameValuePair("api_user", apiUser));
        params.add(new BasicNameValuePair("api_key", apiKey));
        params.add(new BasicNameValuePair("from", "466400960@qq.com"));
        params.add(new BasicNameValuePair("fromname", "小戈"));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("subject", "来自好胖友林寒戈的邀请！"));
        params.add(new BasicNameValuePair("html",
/*                "真的太棒了！能让自己的好朋友欣赏自己的作品，小戈同学真的感到很开心，" +
                "接下来快登录前台去完善账户信息！来看我的成果吧，哇哈哈" +
                "<h1>这是一段小小的测试</h1><br/><img src ='https://hp-static.b3log.org/images/mail/verify-banner1.png'/>" +*/
                        "<style type=\"text/css\">html,\n" +
                        "    body {\n" +
                        "        margin: 0;\n" +
                        "        padding: 0;\n" +
                        "    }\n" +
                        "</style>\n" +
                        "<center>\n" +
                        "<table style=\"background:#f6f7f2;font-size:13px;font-family:microsoft yahei;\">\n" +
                        "\t<tbody>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<td>\n" +
                        "\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600px\">\n" +
                        "\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-top:120px;background: url(http://7xi9bi.com1.z0.glb.clouddn.com/35069/2015/07/20/5891eacba5ba41f389168121f08be02f.jpg) no-repeat;\" width=\"538px\">\n" +
                        "\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t<td height=\"70px\" valign=\"middle\" width=\"100%\"><img alt=\"logo\" src=\"http://7xi9bi.com1.z0.glb.clouddn.com/35069/2015/07/20/1686ccdd7919429a8beeb4f3f15d5eb1.png\" style=\"margin-left:50px;\" /></td>\n" +
                        "\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t<td align=\"center\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"background:#fff;height:411px;\" width=\"465px\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"color:#666;line-height:1.5\" valign=\"top\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:360px;text-align:left;margin-top:50px;margin-bottom:80px;\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<p>亲爱的用户您好：</p>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"text-indent:2em\">真的太棒了！能让自己的好朋友欣赏自己的作品，小戈同学真的感到很开心<br />\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t接下来快登录前台去完善账户信息！来看我的成果吧，哇哈哈！！！<br />\n" +
                                "<h1>这是一个测试页面</h1><br/>"+
                                "<a href='http://localhost:8080/ggblog/user/" + ciphertext+"/form?email=" +email+ "'>点击前往注册界面</a></p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"margin-bottom:40px;\"><a href=\"https://www.baidu.com\" style=\"display:inline-block;width:139px;height:38px;line-height:38px;color:#fff;font-size:14px;vertical-align:middle;background:url(http://7xi9bi.com1.z0.glb.clouddn.com/35069/2015/07/20/0edb116f982044ba85ecd313f20e881c.jpg);text-decoration:none\">开始注册</a></div>\n" +
                        "\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"border-top:1px dashed #ccc;margin:20px\">&nbsp;</div>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"37px\" style=\"background:#dededc\">&nbsp;</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t</tbody>\n" +
                        "\t\t\t</table>\n" +
                        "\t\t\t</td>\n" +
                        "\t\t</tr>\n" +
                        "\t</tbody>\n" +
                        "</table>\n" +
                        "</center>"));
        try {
        params.add(new BasicNameValuePair("resp_email_id", "true"));
        httpost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httpost);
        // 处理响应
            return response.getStatusLine().getStatusCode();
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            httpost.releaseConnection();
        }
        return 0;
    }
}
