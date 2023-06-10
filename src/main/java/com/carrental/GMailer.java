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

    public static void sendMail(){
        // Recipient's email ID needs to be mentioned.
        String to = "neimahlou@gmail.com";

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
            message.setSubject("Friendly Reminder: Your Reservation Ending Soon");



            // Now set the actual message
            message.setContent("\n" +
                            "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
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
                            "table, td { color: #000000; } </style>\n" +
                            "  \n" +
                            "  \n" +
                            "\n" +
                            "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                            "\n" +
                            "</head>\n" +
                            "\n" +
                            "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #e7e7e7;color: #000000\">\n" +
                            "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                            "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                            "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #e7e7e7;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                            "  <tbody>\n" +
                            "  <tr style=\"vertical-align: top\">\n" +
                            "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                            "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #e7e7e7;\"><![endif]-->\n" +
                            "    \n" +
                            "\n" +
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-image: url('images/image-1.png');background-repeat: no-repeat;background-position: center top;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-image: url('images/image-1.png');background-repeat: no-repeat;background-position: center top;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 15px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div style=\"font-size: 14px; color: #6279ff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-family: Montserrat, sans-serif; font-size: 20px; line-height: 28px;\"><strong><span style=\"line-height: 19.6px;\">Your reservation </span></strong></span><span style=\"font-family: Montserrat, sans-serif; font-size: 20px; line-height: 28px;\"><strong><br><span style=\"line-height: 19.6px;\">is expiring soon !</span></strong></span></p>\n" +
                            "  </div>\n" +
                            "\n" +
                            "      </td>\n" +
                            "    </tr>\n" +
                            "  </tbody>\n" +
                            "</table>\n" +
                            "\n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 40px 24px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div style=\"font-size: 14px; line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"line-height: 160%; text-align: justify;\">Dear Client,</p> <br>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">We hope this email finds you well. We wanted to take a moment to remind you that your reservation with us is ending soon. </p> <br>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">We understand that sometimes plans can change, and if you require any modifications to your reservation or need to extend your stay, please let us know as soon as possible. We will do our best to accommodate your needs and ensure a seamless experience.</p> <br>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">Please note that availability might be limited due to high demand, so we encourage you to reach out to us promptly to secure any changes or extensions you may require.</p><br>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">We would like to take this opportunity to thank you for choosing our services and trusting us with your vehicle needs. We genuinely hope that your trip with the vehicle has been comfortable and enjoyable thus far.</p> <br>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">If there is anything else we can assist you with, please don't hesitate to reach out. We are here to ensure your satisfaction and make your experience a memorable one.</p><br>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">Thank you once again for choosing Rent EZ. We look forward to serving you and hope to welcome you back in the future.</p> <br>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">Best regards,</p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\"> </p>\n" +
                            "<p style=\"line-height: 160%; text-align: justify;\">Rent EZ</p>\n" +
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
                            "<div class=\"u-row-container\" style=\"padding: 0px;background-image: url('images/image-2.png');background-repeat: no-repeat;background-position: center top;background-color: transparent\">\n" +
                            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffdede;\">\n" +
                            "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-image: url('images/image-2.png');background-repeat: no-repeat;background-position: center top;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffdede;\"><![endif]-->\n" +
                            "      \n" +
                            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #6279ff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                            "  <div style=\"background-color: #6279ff;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                            "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                            "  \n" +
                            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                            "  <tbody>\n" +
                            "    <tr>\n" +
                            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 40px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
                            "        \n" +
                            "  <div style=\"font-size: 14px; color: #ffffff; line-height: 160%; text-align: center; word-wrap: break-word;\">\n" +
                            "    <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 16px; line-height: 25.6px; font-family: 'Open Sans', sans-serif;\">All rights reserved UIR.</span></p>\n" +
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