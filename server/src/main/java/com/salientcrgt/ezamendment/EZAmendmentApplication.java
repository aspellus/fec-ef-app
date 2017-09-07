package com.salientcrgt.ezamendment;

import java.security.SecureRandom;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EZAmendmentApplication {

	public static void main(String[] args) throws Exception {
		
		TrustManager[] trustAllCerts = new TrustManager[]{
			    new X509TrustManager(){
			      @Override
			      public X509Certificate[] getAcceptedIssuers(){ return null; }
			      @Override
			      public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {}
			      @Override
			      public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException{}
			    }
			  };
		SSLContext sslContext = SSLContext.getInstance("SSL");
	    sslContext.init(null, trustAllCerts, new SecureRandom());
	    HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

		  
		SpringApplication.run(EZAmendmentApplication.class, args);
	}
}
