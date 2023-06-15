package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import javafx.scene.image.Image;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GMailer{

    public static void sendAccountConfirmation(String mail){
        // Recipient's email ID needs to be mentioned.
        String to = mail;

        // Sender's email ID needs to be mentioned
        String from = "uircarrental@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("uircarrental@gmail.com", "tvnvvjpnzhdggxnc");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Your account has been created successfully !");



            // Now set the actual message
            message.setContent("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                            "<head>\n" +
                            "<!--[if gte mso 9]>\n" +
                            "<xml>\n" +
                            "  <o:OfficeDocumentSettings>\n" +
                            "    <o:AllowPNG/>\n" +
                            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                            "  </o:OfficeDocumentSettings>\n" +
                            "</xml>\n" +
                            "<![endif]-->\n" +
                            "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                            "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                            "  <title></title>\n" +
                            "  \n" +
                            "    <style type=\"text/css\">\n" +
                            "      @media only screen and (min-width: 620px) {\n" +
                            "  .u-row {\n" +
                            "    width: 600px !important;\n" +
                            "  }\n" +
                            "  .u-row .u-col {\n" +
                            "    vertical-align: top;\n" +
                            "  }\n" +
                            "\n" +
                            "  .u-row .u-col-25 {\n" +
                            "    width: 150px !important;\n" +
                            "  }\n" +
                            "\n" +
                            "  .u-row .u-col-100 {\n" +
                            "    width: 600px !important;\n" +
                            "  }\n" +
                            "\n" +
                            "}\n" +
                            "\n" +
                            "@media (max-width: 620px) {\n" +
                            "  .u-row-container {\n" +
                            "    max-width: 100% !important;\n" +
                            "    padding-left: 0px !important;\n" +
                            "    padding-right: 0px !important;\n" +
                            "  }\n" +
                            "  .u-row .u-col {\n" +
                            "    min-width: 320px !important;\n" +
                            "    max-width: 100% !important;\n" +
                            "    display: block !important;\n" +
                            "  }\n" +
                            "  .u-row {\n" +
                            "    width: 100% !important;\n" +
                            "  }\n" +
                            "  .u-col {\n" +
                            "    width: 100% !important;\n" +
                            "  }\n" +
                            "  .u-col > div {\n" +
                            "    margin: 0 auto;\n" +
                            "  }\n" +
                            "}\n" +
                            "body {\n" +
                            "  margin: 0;\n" +
                            "  padding: 0;\n" +
                            "}\n" +
                            "\n" +
                            "table,\n" +
                            "tr,\n" +
                            "td {\n" +
                            "  vertical-align: top;\n" +
                            "  border-collapse: collapse;\n" +
                            "}\n" +
                            "\n" +
                            "p {\n" +
                            "  margin: 0;\n" +
                            "}\n" +
                            "\n" +
                            ".ie-container table,\n" +
                            ".mso-container table {\n" +
                            "  table-layout: fixed;\n" +
                            "}\n" +
                            "\n" +
                            "* {\n" +
                            "  line-height: inherit;\n" +
                            "}\n" +
                            "\n" +
                            "a[x-apple-data-detectors='true'] {\n" +
                            "  color: inherit !important;\n" +
                            "  text-decoration: none !important;\n" +
                            "}\n" +
                            "\n" +
                            "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } #u_content_text_6 a { color: #ffffff; } #u_content_text_8 a { color: #ffffff; } #u_content_text_10 a { color: #ffffff; } #u_content_text_9 a { color: #ffffff; } @media (max-width: 480px) { #u_content_heading_6 .v-container-padding-padding { padding: 10px 22px 0px !important; } #u_content_heading_6 .v-text-align { text-align: center !important; } #u_content_heading_7 .v-container-padding-padding { padding: 0px 22px 10px !important; } #u_content_heading_7 .v-text-align { text-align: center !important; } #u_content_heading_2 .v-container-padding-padding { padding: 30px 22px 10px !important; } #u_content_heading_2 .v-text-align { text-align: left !important; } #u_content_text_2 .v-container-padding-padding { padding: 10px 22px !important; } #u_content_text_3 .v-container-padding-padding { padding: 10px 22px 30px !important; } #u_content_menu_3 .v-font-size { font-size: 15px !important; } #u_content_menu_3 .v-padding { padding: 6px 20px !important; } #u_content_text_6 .v-container-padding-padding { padding: 10px !important; } #u_content_text_6 .v-line-height { line-height: 50% !important; } }\n" +
                            "    </style>\n" +
                            "  \n" +
                            "  \n" +
                            "\n" +
                            "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                            "\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f1f1f1;color: #000000\">\n" +
                            "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                            "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                            "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f1f1f1;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                            "  <tbody>\n" +
                            "  <tr style=\"vertical-align: top\">\n" +
                            "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                            "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f1f1f1;\"><![endif]-->\n" +
                            "    \n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0f0909;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0f0909;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #353550;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:5px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                            "  <tr>\n" +
                            "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                            "      \n" +
                            "      <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1656487470905-mail.png\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 23%;max-width: 133.4px;\" width=\"133.4\"/>\n" +
                            "      \n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0f0909;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0f0909;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #353550;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_heading_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h2 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 20px; font-weight: 400;\"><strong>Your account has<br /></strong></h2>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_heading_7\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 0px 15px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h2 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 20px; font-weight: 400;\"><strong>been created successfully !<br /></strong></h2>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_heading_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 44px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h1 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #333333; line-height: 140%; text-align: left; word-wrap: break-word; font-family: 'Lato',sans-serif; font-size: 20px; font-weight: 400;\"><strong>Dear Customer </strong></h1>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_text_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 44px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; line-height: 170%; text-align: justify; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">This email serves as confirmation that your account has been successfully created and is ready for you to explore our services.</span></p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"> </p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\"> We appreciate your decision to join our community, and we are excited to have you on board.</span></p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"> </p>\n" +
                            "<p style=\"line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\"><span style=\"line-height: 23.8px;\">To get started, please visit the app and log in using your credentials. </span>We value your privacy and assure you that your information is securely stored. If you have any concerns or questions regarding the security of your account, please refer to our Privacy Policy on our app and website.</span></p>\n" +
                            "<p style=\"line-height: 170%;\"> </p>\n" +
                            "<p style=\"line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">Should you have any questions or require assistance, feel free to reach out to our support team at <a rel=\"noopener\" href=\"mailto:uircarrental@gmail.com\" target=\"_blank\">uircarrental@gmail.com</a>.</span></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_text_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 44px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-family: Lato, sans-serif; font-size: 18px; line-height: 25.2px;\">Sincerely,</span></strong><br /><span style=\"font-family: Lato, sans-serif; font-size: 18px; line-height: 25.2px;\">Team Rent . ez </span></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0a2a60;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0a2a60;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                            "  <tr>\n" +
                            "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                            "      \n" +
                            "      <img align=\"center\" border=\"0\" src=\"https://images.unsplash.com/photo-1471479917193-f00955256257?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2831&q=80\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 600px;\" width=\"600\"/>\n" +
                            "      \n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0a2a60;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0a2a60;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #6279ff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #6279ff;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_menu_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:9px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<div class=\"menu\" style=\"text-align:center\">\n" +
                            "<!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
                            "\n" +
                            "  <!--[if (mso)|(IE)]><td style=\"padding:10px 20px\"><![endif]-->\n" +
                            "  \n" +
                            "    <a href=\"https://unlayer.com\" target=\"_self\" style=\"padding:10px 20px;display:inline-block;color:#ffffff;font-family:'Open Sans',sans-serif;font-size:18px;text-decoration:none\"  class=\"v-padding v-font-size\">\n" +
                            "      Follow us on social media for more \n" +
                            "    </a>\n" +
                            "  \n" +
                            "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "  \n" +
                            "\n" +
                            "<!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
                            "</div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #000000;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #000000;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.instagram.com/rent__ez/?igshid=MzRlODBiNWFlZA%3D%3D\" target=\"_blank\">Instagram</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_8\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://youtube.com/@RentEZ\" target=\"_blank\">Youtube</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_10\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.linkedin.com/in/rent-ez-22906227b/\" target=\"_blank\">Linkedin</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_9\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.facebook.com/profile.php?id=100093280942401\" target=\"_blank\">Facebook</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "  </tbody>\n" +
                            "  </table>\n" +
                            "  <!--[if mso]></div><![endif]-->\n" +
                            "  <!--[if IE]></div><![endif]-->\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>\n",
                    "text/html");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public static void sendReservationConfirmation(String mail){
        // Recipient's email ID needs to be mentioned.
        String to = mail;

        // Sender's email ID needs to be mentioned
        String from = "uircarrental@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("uircarrental@gmail.com", "tvnvvjpnzhdggxnc");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Your reservation has been confirmed !");



            // Now set the actual message
            message.setContent("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                            "<head>\n" +
                            "<!--[if gte mso 9]>\n" +
                            "<xml>\n" +
                            "  <o:OfficeDocumentSettings>\n" +
                            "    <o:AllowPNG/>\n" +
                            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                            "  </o:OfficeDocumentSettings>\n" +
                            "</xml>\n" +
                            "<![endif]-->\n" +
                            "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                            "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                            "  <title></title>\n" +
                            "  \n" +
                            "    <style type=\"text/css\">\n" +
                            "      @media only screen and (min-width: 620px) {\n" +
                            "  .u-row {\n" +
                            "    width: 600px !important;\n" +
                            "  }\n" +
                            "  .u-row .u-col {\n" +
                            "    vertical-align: top;\n" +
                            "  }\n" +
                            "\n" +
                            "  .u-row .u-col-25 {\n" +
                            "    width: 150px !important;\n" +
                            "  }\n" +
                            "\n" +
                            "  .u-row .u-col-100 {\n" +
                            "    width: 600px !important;\n" +
                            "  }\n" +
                            "\n" +
                            "}\n" +
                            "\n" +
                            "@media (max-width: 620px) {\n" +
                            "  .u-row-container {\n" +
                            "    max-width: 100% !important;\n" +
                            "    padding-left: 0px !important;\n" +
                            "    padding-right: 0px !important;\n" +
                            "  }\n" +
                            "  .u-row .u-col {\n" +
                            "    min-width: 320px !important;\n" +
                            "    max-width: 100% !important;\n" +
                            "    display: block !important;\n" +
                            "  }\n" +
                            "  .u-row {\n" +
                            "    width: 100% !important;\n" +
                            "  }\n" +
                            "  .u-col {\n" +
                            "    width: 100% !important;\n" +
                            "  }\n" +
                            "  .u-col > div {\n" +
                            "    margin: 0 auto;\n" +
                            "  }\n" +
                            "}\n" +
                            "body {\n" +
                            "  margin: 0;\n" +
                            "  padding: 0;\n" +
                            "}\n" +
                            "\n" +
                            "table,\n" +
                            "tr,\n" +
                            "td {\n" +
                            "  vertical-align: top;\n" +
                            "  border-collapse: collapse;\n" +
                            "}\n" +
                            "\n" +
                            "p {\n" +
                            "  margin: 0;\n" +
                            "}\n" +
                            "\n" +
                            ".ie-container table,\n" +
                            ".mso-container table {\n" +
                            "  table-layout: fixed;\n" +
                            "}\n" +
                            "\n" +
                            "* {\n" +
                            "  line-height: inherit;\n" +
                            "}\n" +
                            "\n" +
                            "a[x-apple-data-detectors='true'] {\n" +
                            "  color: inherit !important;\n" +
                            "  text-decoration: none !important;\n" +
                            "}\n" +
                            "\n" +
                            "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } #u_content_text_6 a { color: #ffffff; } #u_content_text_8 a { color: #ffffff; } #u_content_text_10 a { color: #ffffff; } #u_content_text_9 a { color: #ffffff; } @media (max-width: 480px) { #u_content_heading_6 .v-container-padding-padding { padding: 10px 22px 0px !important; } #u_content_heading_6 .v-text-align { text-align: center !important; } #u_content_heading_7 .v-container-padding-padding { padding: 0px 22px 10px !important; } #u_content_heading_7 .v-text-align { text-align: center !important; } #u_content_heading_2 .v-container-padding-padding { padding: 30px 22px 10px !important; } #u_content_heading_2 .v-text-align { text-align: left !important; } #u_content_text_2 .v-container-padding-padding { padding: 10px 22px !important; } #u_content_text_3 .v-container-padding-padding { padding: 10px 22px 30px !important; } #u_content_menu_3 .v-font-size { font-size: 15px !important; } #u_content_menu_3 .v-padding { padding: 6px 20px !important; } #u_content_text_6 .v-container-padding-padding { padding: 10px !important; } #u_content_text_6 .v-line-height { line-height: 50% !important; } }\n" +
                            "    </style>\n" +
                            "  \n" +
                            "  \n" +
                            "\n" +
                            "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                            "\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f1f1f1;color: #000000\">\n" +
                            "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                            "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                            "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f1f1f1;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                            "  <tbody>\n" +
                            "  <tr style=\"vertical-align: top\">\n" +
                            "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                            "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f1f1f1;\"><![endif]-->\n" +
                            "    \n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0f0909;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0f0909;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #353550;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:5px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                            "  <tr>\n" +
                            "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                            "      \n" +
                            "      <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1656487470905-mail.png\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 23%;max-width: 133.4px;\" width=\"133.4\"/>\n" +
                            "      \n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0f0909;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0f0909;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #353550;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_heading_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h2 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 20px; font-weight: 400;\"><strong>Your reservation has<br /></strong></h2>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_heading_7\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 0px 15px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h2 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 20px; font-weight: 400;\"><strong>been confirmed !<br /></strong></h2>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_heading_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 44px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h1 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #333333; line-height: 140%; text-align: left; word-wrap: break-word; font-family: 'Lato',sans-serif; font-size: 20px; font-weight: 400;\"><strong>Dear Customer </strong></h1>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_text_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 44px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; line-height: 170%; text-align: justify; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">We are delighted to inform you that your reservation has been successfully confirmed. </span></p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"> </p>\n" +
                            "<p style=\"line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\"><span style=\"line-height: 23.8px;\">To view your reservation in detail, please visit the app and log in using your credentials. </span></span></p>\n" +
                            "<p style=\"line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">We value your privacy and assure you that your information is securely stored. If you have any concerns or questions regarding the security of your account, please refer to our Privacy Policy on our app and website.</span></p>\n" +
                            "<p style=\"line-height: 170%;\"> </p>\n" +
                            "<p style=\"line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">Should you have any questions or require assistance, feel free to reach out to our support team at <a rel=\"noopener\" href=\"mailto:uircarrental@gmail.com\" target=\"_blank\">uircarrental@gmail.com</a>.</span></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_text_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 44px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-family: Lato, sans-serif; font-size: 18px; line-height: 25.2px;\">Sincerely,</span></strong><br /><span style=\"font-family: Lato, sans-serif; font-size: 18px; line-height: 25.2px;\">Team Rent . ez </span></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0a2a60;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0a2a60;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                            "  <tr>\n" +
                            "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                            "      \n" +
                            "      <img align=\"center\" border=\"0\" src=\"https://images.unsplash.com/photo-1471479917193-f00955256257?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2831&q=80\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 600px;\" width=\"600\"/>\n" +
                            "      \n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0a2a60;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0a2a60;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #6279ff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #6279ff;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_menu_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:9px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<div class=\"menu\" style=\"text-align:center\">\n" +
                            "<!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
                            "\n" +
                            "  <!--[if (mso)|(IE)]><td style=\"padding:10px 20px\"><![endif]-->\n" +
                            "  \n" +
                            "    <a href=\"https://unlayer.com\" target=\"_self\" style=\"padding:10px 20px;display:inline-block;color:#ffffff;font-family:'Open Sans',sans-serif;font-size:18px;text-decoration:none\"  class=\"v-padding v-font-size\">\n" +
                            "      Follow us on social media for more \n" +
                            "    </a>\n" +
                            "  \n" +
                            "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "  \n" +
                            "\n" +
                            "<!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
                            "</div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #000000;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #000000;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.instagram.com/rent__ez/?igshid=MzRlODBiNWFlZA%3D%3D\" target=\"_blank\">Instagram</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_8\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://youtube.com/@RentEZ\" target=\"_blank\">Youtube</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_10\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.linkedin.com/in/rent-ez-22906227b/\" target=\"_blank\">Linkedin</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_9\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.facebook.com/profile.php?id=100093280942401\" target=\"_blank\">Facebook</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "  </tbody>\n" +
                            "  </table>\n" +
                            "  <!--[if mso]></div><![endif]-->\n" +
                            "  <!--[if IE]></div><![endif]-->\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>\n",
                    "text/html");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public static void sendReminder(String mail){
        // Recipient's email ID needs to be mentioned.
        String to = mail;

        // Sender's email ID needs to be mentioned
        String from = "uircarrental@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("uircarrental@gmail.com", "tvnvvjpnzhdggxnc");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Friendly Reminder: Your Reservation is Ending Soon");



            // Now set the actual message
            message.setContent("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                            "<head>\n" +
                            "<!--[if gte mso 9]>\n" +
                            "<xml>\n" +
                            "  <o:OfficeDocumentSettings>\n" +
                            "    <o:AllowPNG/>\n" +
                            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                            "  </o:OfficeDocumentSettings>\n" +
                            "</xml>\n" +
                            "<![endif]-->\n" +
                            "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                            "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                            "  <title></title>\n" +
                            "  \n" +
                            "    <style type=\"text/css\">\n" +
                            "      @media only screen and (min-width: 620px) {\n" +
                            "  .u-row {\n" +
                            "    width: 600px !important;\n" +
                            "  }\n" +
                            "  .u-row .u-col {\n" +
                            "    vertical-align: top;\n" +
                            "  }\n" +
                            "\n" +
                            "  .u-row .u-col-25 {\n" +
                            "    width: 150px !important;\n" +
                            "  }\n" +
                            "\n" +
                            "  .u-row .u-col-100 {\n" +
                            "    width: 600px !important;\n" +
                            "  }\n" +
                            "\n" +
                            "}\n" +
                            "\n" +
                            "@media (max-width: 620px) {\n" +
                            "  .u-row-container {\n" +
                            "    max-width: 100% !important;\n" +
                            "    padding-left: 0px !important;\n" +
                            "    padding-right: 0px !important;\n" +
                            "  }\n" +
                            "  .u-row .u-col {\n" +
                            "    min-width: 320px !important;\n" +
                            "    max-width: 100% !important;\n" +
                            "    display: block !important;\n" +
                            "  }\n" +
                            "  .u-row {\n" +
                            "    width: 100% !important;\n" +
                            "  }\n" +
                            "  .u-col {\n" +
                            "    width: 100% !important;\n" +
                            "  }\n" +
                            "  .u-col > div {\n" +
                            "    margin: 0 auto;\n" +
                            "  }\n" +
                            "}\n" +
                            "body {\n" +
                            "  margin: 0;\n" +
                            "  padding: 0;\n" +
                            "}\n" +
                            "\n" +
                            "table,\n" +
                            "tr,\n" +
                            "td {\n" +
                            "  vertical-align: top;\n" +
                            "  border-collapse: collapse;\n" +
                            "}\n" +
                            "\n" +
                            "p {\n" +
                            "  margin: 0;\n" +
                            "}\n" +
                            "\n" +
                            ".ie-container table,\n" +
                            ".mso-container table {\n" +
                            "  table-layout: fixed;\n" +
                            "}\n" +
                            "\n" +
                            "* {\n" +
                            "  line-height: inherit;\n" +
                            "}\n" +
                            "\n" +
                            "a[x-apple-data-detectors='true'] {\n" +
                            "  color: inherit !important;\n" +
                            "  text-decoration: none !important;\n" +
                            "}\n" +
                            "\n" +
                            "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } #u_content_text_6 a { color: #ffffff; } #u_content_text_8 a { color: #ffffff; } #u_content_text_10 a { color: #ffffff; } #u_content_text_9 a { color: #ffffff; } @media (max-width: 480px) { #u_content_heading_6 .v-container-padding-padding { padding: 10px 22px 0px !important; } #u_content_heading_6 .v-text-align { text-align: center !important; } #u_content_heading_7 .v-container-padding-padding { padding: 0px 22px 10px !important; } #u_content_heading_7 .v-text-align { text-align: center !important; } #u_content_heading_2 .v-container-padding-padding { padding: 30px 22px 10px !important; } #u_content_heading_2 .v-text-align { text-align: left !important; } #u_content_text_2 .v-container-padding-padding { padding: 10px 22px !important; } #u_content_text_3 .v-container-padding-padding { padding: 10px 22px 30px !important; } #u_content_menu_3 .v-font-size { font-size: 15px !important; } #u_content_menu_3 .v-padding { padding: 6px 20px !important; } #u_content_text_6 .v-container-padding-padding { padding: 10px !important; } #u_content_text_6 .v-line-height { line-height: 50% !important; } }\n" +
                            "    </style>\n" +
                            "  \n" +
                            "  \n" +
                            "\n" +
                            "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                            "\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f1f1f1;color: #000000\">\n" +
                            "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                            "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                            "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f1f1f1;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                            "  <tbody>\n" +
                            "  <tr style=\"vertical-align: top\">\n" +
                            "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                            "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f1f1f1;\"><![endif]-->\n" +
                            "    \n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0f0909;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0f0909;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #353550;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:5px 10px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                            "  <tr>\n" +
                            "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                            "      \n" +
                            "      <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1656487470905-mail.png\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 23%;max-width: 133.4px;\" width=\"133.4\"/>\n" +
                            "      \n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0f0909;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0f0909;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #353550;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_heading_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h2 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 20px; font-weight: 400;\"><strong>Your reservation is<br /></strong></h2>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_heading_7\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 0px 15px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h2 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word; font-family: 'Open Sans',sans-serif; font-size: 20px; font-weight: 400;\"><strong>ending soon !<br /></strong></h2>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_heading_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 44px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <h1 class=\"v-text-align v-line-height v-font-size\" style=\"margin: 0px; color: #333333; line-height: 140%; text-align: left; word-wrap: break-word; font-family: 'Lato',sans-serif; font-size: 20px; font-weight: 400;\"><strong>Dear Customer </strong></h1>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_text_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 44px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; line-height: 170%; text-align: justify; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">We wanted to take a moment to remind you that your reservation with us is ending soon. </span></p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"> </p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">We understand that sometimes plans can change, and if you require any modifications to your reservation or need to extend your stay, please let us know as soon as possible. We will do our best to accommodate your needs and ensure a seamless experience. Please note that availability might be limited due to high demand, so we encourage you to reach out to us promptly to secure any changes or extensions you may require. </span></p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"> </p>\n" +
                            "<p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">We genuinely hope that your trip with the vehicle has been comfortable and enjoyable thus far. If there is anything else we can assist you with, please don't hesitate to reach out. We are here to ensure your satisfaction and make your experience a memorable one.</span></p>\n" +
                            "<p style=\"line-height: 170%;\"> </p>\n" +
                            "<p style=\"line-height: 170%;\"><span style=\"font-family: Lato, sans-serif; line-height: 27.2px; font-size: 16px;\">Should you have any questions or require assistance, feel free to reach out to our support team at <a rel=\"noopener\" href=\"mailto:uircarrental@gmail.com\" target=\"_blank\">uircarrental@gmail.com</a>.</span></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table id=\"u_content_text_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 44px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-family: Lato, sans-serif; font-size: 18px; line-height: 25.2px;\">Sincerely,</span></strong><br /><span style=\"font-family: Lato, sans-serif; font-size: 18px; line-height: 25.2px;\">Team Rent . ez </span></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0a2a60;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0a2a60;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                            "  <tr>\n" +
                            "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                            "      \n" +
                            "      <img align=\"center\" border=\"0\" src=\"https://images.unsplash.com/photo-1471479917193-f00955256257?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2831&q=80\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 600px;\" width=\"600\"/>\n" +
                            "      \n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0a2a60;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0a2a60;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #6279ff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #6279ff;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_menu_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:9px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "<div class=\"menu\" style=\"text-align:center\">\n" +
                            "<!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
                            "\n" +
                            "  <!--[if (mso)|(IE)]><td style=\"padding:10px 20px\"><![endif]-->\n" +
                            "  \n" +
                            "    <a href=\"https://unlayer.com\" target=\"_self\" style=\"padding:10px 20px;display:inline-block;color:#ffffff;font-family:'Open Sans',sans-serif;font-size:18px;text-decoration:none\"  class=\"v-padding v-font-size\">\n" +
                            "      Follow us on social media for more \n" +
                            "    </a>\n" +
                            "  \n" +
                            "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "  \n" +
                            "\n" +
                            "<!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
                            "</div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #000000;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #000000;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_6\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.instagram.com/rent__ez/?igshid=MzRlODBiNWFlZA%3D%3D\" target=\"_blank\">Instagram</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_8\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://youtube.com/@RentEZ\" target=\"_blank\">Youtube</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_10\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.linkedin.com/in/rent-ez-22906227b/\" target=\"_blank\">Linkedin</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"150\" style=\"background-color: #353550;width: 150px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-25\" style=\"max-width: 320px;min-width: 150px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #353550;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table id=\"u_content_text_9\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div class=\"v-text-align v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 140%;\"><a rel=\"noopener\" href=\"https://www.facebook.com/profile.php?id=100093280942401\" target=\"_blank\">Facebook</a></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "  </tbody>\n" +
                            "  </table>\n" +
                            "  <!--[if mso]></div><![endif]-->\n" +
                            "  <!--[if IE]></div><![endif]-->\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>\n",
                    "text/html");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}