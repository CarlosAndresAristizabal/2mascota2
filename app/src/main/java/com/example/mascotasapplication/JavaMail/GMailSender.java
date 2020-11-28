package com.example.mascotasapplication.JavaMail;

import android.util.Log;

import com.example.mascotasapplication.Menu.Dialogo;
import com.example.mascotasapplication.R;

import java.security.Security;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GMailSender extends javax.mail.Authenticator implements Dialogo.DialogoListener {
    private String Email;
    private String Contraseña;

    Dialogo dialogo = new Dialogo();

    private final Session session;
    static {
        Security.addProvider(new JSSEProvider());
    }


    public GMailSender( String Email, String Contraseña) {
        this.Email = dialogo.getDialog().findViewById(R.id.email).toString();
        this.Contraseña = dialogo.getDialog().findViewById(R.id.contraseña).toString();
        Log.d("usuario", this.Email);


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        session = Session.getDefaultInstance(props, this);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(Email,Contraseña);
    }

    public synchronized void sendMail(String subject, String body,
                                      String sender, String recipients) throws Exception {
        MimeMessage message = new MimeMessage(session);
        DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/html"));
        message.setSender(new InternetAddress(sender));
        message.setSubject(subject);
        message.setDataHandler(handler);

        if (recipients.indexOf(',') > 0)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
        else
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));

        Transport.send(message);
    }

    public void applyTexts(String Email, String Contraseña) {

    }


    }
