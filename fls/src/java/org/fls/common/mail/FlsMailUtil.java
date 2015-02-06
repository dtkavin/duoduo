/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.mail;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import org.fls.common.mail.entity.FlsAuthenticator;

/**
 * 邮件处理
 *
 * @author Tone
 */
public class FlsMailUtil {

    private String admin_Name = "";
    private String admin_Password = "";
    private String mail_host;
    private String url;

    /**
     * 构造函数
     *
     * @param adminName
     * @param adminPassword
     * @param mailhost
     */
    public FlsMailUtil(String adminName, String adminPassword, String mailhost) {
        this.admin_Name = adminName;
        this.admin_Password = adminPassword;
        this.mail_host = mailhost;
    }

    /**
     * 发送邮件
     *
     * @param user_name
     * @param user_mail
     * @param user_uuid
     */
    public void sendMail(String user_name, String user_mail, String user_uuid) {
        url = "http://localhost:8080/fls/login/LoginAction!authenticator?registerId=" + user_uuid;
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", mail_host);

        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");

        properties.setProperty("mail.smtp.auth", "true");

        FlsAuthenticator authenticator = new FlsAuthenticator(admin_Name, admin_Password);


        Session session = Session.getDefaultInstance(properties, authenticator);

        session.setDebug(true);
        try {


            Address from = new InternetAddress(admin_Name);
            Address to = new InternetAddress(user_mail);

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(from);
            mimeMessage.setSubject("牢骚网注册验证");
            mimeMessage.setSentDate(new Date());
            mimeMessage.setContent("Hi," + user_name + "<br/>"
                    + "欢迎注册牢骚网，请点击一下链接完成注册<br/><a href='" + url + "'>点击" + url + "完成注册</a> <br/>"
                    + "生活中难免挫折，难免遇到遇到狗屎的人和事，但在这里你可以把他们远远的扔出去，<br/>"
                    + "记住 你永远不是那个最倒霉的一个！所以乐观点。",
                    "text/html;charset=utf-8");

            //System.out.println(mimeMessage.getContent());
            mimeMessage.setRecipient(RecipientType.TO, to);
            Transport.send(mimeMessage);

        } catch (Exception e) {

            Logger.getLogger(FlsMailUtil.class.getName()).log(Level.SEVERE, null, e);
        }


    }
}
