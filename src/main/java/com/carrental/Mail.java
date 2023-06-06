/* package com.carrental;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Properties;

public class EmailSender {

    private static final String APPLICATION_NAME = "My Email Application";
    private static final String CREDENTIALS_FILE_PATH = "credentials.json";
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    public static void main(String[] args) {
        try {
            NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            Gmail service = createGmailService(httpTransport, jsonFactory);

            final String senderEmail = "votre_adresse_email@gmail.com";
            final String recipientEmail = "destinataire@example.com";
            final String subject = "Sujet de l'e-mail";
            final String body = "Contenu de l'e-mail";

            sendMessage(service, senderEmail, recipientEmail, subject, body);
            System.out.println("L'e-mail a été envoyé avec succès !");
        } catch (IOException | GeneralSecurityException e) {
            System.out.println("Une erreur s'est produite lors de l'envoi de l'e-mail : " + e.getMessage());
        }
    }

    private static Gmail createGmailService(NetHttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        Credential credential = authorize(httpTransport, jsonFactory);
        return new Gmail.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    private static Credential authorize(NetHttpTransport httpTransport, JsonFactory jsonFactory) throws IOException {
        FileInputStream credentialsStream = new FileInputStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(credentialsStream));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientSecrets, Arrays.asList(GmailScopes.GMAIL_SEND))
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        String redirectUri = "urn:ietf:wg:oauth:2.0:oob";
        String authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectUri).build();
        System.out.println("Open the following URL in your browser:");
        System.out.println(authorizationUrl);
        System.out.println("Enter the authorization code:");
        String authorizationCode = System.console().readLine();

        GoogleTokenResponse tokenResponse = flow.newTokenRequest(authorizationCode).setRedirectUri(redirectUri).execute();
        return flow.createAndStoreCredential(tokenResponse, "user");
    }

    private static void sendMessage(Gmail service, String senderEmail, String recipientEmail, String subject, String body)
            throws IOException {
        MimeMessage email = createEmail(senderEmail, recipientEmail, subject, body);
        Message message = createMessageWithEmail(email);
        service.users().messages().send("me", message).execute();
    }

    private static MimeMessage createEmail(String senderEmail, String recipientEmail, String subject, String body)
            throws IOException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(senderEmail));
        email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recipientEmail));
        email.setSubject(subject);
        email.setText(body);
        return email;
    }

    private static Message createMessageWithEmail(MimeMessage email) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        return new Message().setRaw(encodedEmail);
    }
}

 */
