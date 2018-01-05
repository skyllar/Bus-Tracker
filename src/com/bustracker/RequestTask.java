package com.bustracker;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class RequestTask extends AsyncTask<String, String, String> {

	String logicServerURI = "http://10.1.131.159:8090";
	String logicServerClass = "/route/";

	@Override
	protected String doInBackground(String... uri) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response;
		String responseString = null;

		// Log.d("salman",uri[0]);
//		String query = "{source:" + "'" + uri[0] + "'" + ",destination:" + "'"
//				+ uri[1] + "'}";
		 String query = uri[0]+","+uri[1];

		try {

			Log.d("salman", "1" );
			response = httpclient.execute(new HttpGet(logicServerURI
					+ logicServerClass + query ));
			Log.d("salman", "2");
			String responseBody = EntityUtils.toString(response.getEntity());
			Log.d("salman", "3" + "..." + responseBody);
			HttpPost httpost = new HttpPost(responseBody);
			Log.d("salman", "4");
			String boundary = "-------------" + System.currentTimeMillis();
			httpost.setHeader("Content-type", "multipart/form-data; boundary="
					+ boundary);
			Log.d("salman", "5");
			// MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			// builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			// builder.setBoundary(boundary);
			// FileBody file = new FileBody(new File(uri[0]));

			// builder.addTextBody("Source", uri[1]+"/"+uri[2]);
			// builder.addTextBody("Destination", uri[2]);
			// builder.addTextBody("rating", uri[3]);
			// builder.addTextBody("longitude", uri[4]);
			// builder.addTextBody("latitude", uri[5]);

			// / builder.addPart("image", file);

			Log.d("salman", "6");

			// httpost.setEntity(builder.build());

			Log.d("salman", "7");
			response = httpclient.execute(httpost);

			Log.d("salman", "8");
			StatusLine statusLine = response.getStatusLine();
			Log.d("salman", "9");
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				Log.d("salman", "10");
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				out.close();
				responseString = out.toString();
				Log.d("salman", "11");
			} else {
				// Closes the connection
				Log.d("salman", "12");
				response.getEntity().getContent().close();
				Log.d("salman", "13");
				throw new IOException(statusLine.getReasonPhrase());

			}
		} catch (ClientProtocolException e) {
			// TODO Handle problems..
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Handle problems..
			e.printStackTrace();
		}
		Log.d("salman", "14");
		return "hello";
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		// Do anything with response..
	}
}
