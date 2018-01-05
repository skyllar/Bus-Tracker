package com.bustracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	HashMap<String, String> address = new HashMap<String, String>();
	// Hashmap<String , String > address = new Hashmap<String,String> ;
	private Spinner spinner1, spinner2;
	private Button btnSubmit;
	public String source, destination;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addinMap();
		addItemsOnSpinner2();
		addItemsOnSpinner1();

		addListenerOnSpinnerItemSelection();
	}

	// add items into spinner dynamically

	public void addinMap() {
		address.put(
				"IIIT-H",
				"IIIT Bus Stop, Old Mumbai Highway, FCI Employees Cooperative Housing Society, Gachibowli, Hyderabad, Telangana 500032");
		address.put(
				"Kothagudaa",
				"Kothaguda Bus Stop, Gachibowli Miyapur Road, Laxmi Cyber City, Whitefields, Kothaguda, Hyderabad, Telangana 500084");
		address.put(
				"WiproCircle",
				"Wipro Circle, ISB Road, Financial District, Nanakram Guda, Hyderabad, Telangana 500032");
		address.put(
				"BiodiversityPark",
				"Biodiversity Park Bus Stop, Old Mumbai Highway, Silpa Gram Craft Village, HITEC City, Hyderabad, Telangana 500081");
		address.put(
				"Mehdipatnam",
				"Mehdipatnam Bus Stop, Mehdipatnam Road, Santosh Nagar, Mehdipatnam, Hyderabad, Telangana 500028");
		address.put(
				"Lingampally",
				"Lingampally Bus Stop, Gouthami Nagar Colony, Jawahar Colony, Chanda Nagar, Hyderabad, Telangana 500050");
		address.put(
				"Secunderabad",
				"Secunderabad Bus Stop, Station Road, Regimental Bazaar, Shivaji Nagar, Secunderabad, Telangana 500003");

	}

	public void addItemsOnSpinner2() {

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		List<String> list = new ArrayList<String>();

		Iterator iterator = address.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			list.add((String) mapEntry.getKey());
		}

		// list.add("list 1");
		// list.add("list 2");
		// list.add("list 3");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter);
	}

	public void addItemsOnSpinner1() {

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();

		Iterator iterator = address.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			list.add((String) mapEntry.getKey());
		}

		// list.add("list 1");
		// list.add("list 2");
		// list.add("list 3");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter);

	}

	public void addListenerOnSpinnerItemSelection() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

	// // get the selected dropdown list value
	// public void addListenerOnButton() {
	//
	// spinner1 = (Spinner) findViewById(R.id.spinner1);
	// spinner2 = (Spinner) findViewById(R.id.spinner2);
	// btnSubmit = (Button) findViewById(R.id.btnSubmit);
	//
	// btnSubmit.setOnClickListener(new OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	//
	// Toast.makeText(MainActivity.this,
	// "OnClickListener : " +
	// "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
	// "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
	// Toast.LENGTH_SHORT).show();
	// }
	//
	// });
	// }

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public void sendMessage(View view) {

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		// btnSubmit = (Button) findViewById(R.id.btnSubmit);

		source = String.valueOf(spinner1.getSelectedItem());

		destination = String.valueOf(spinner2.getSelectedItem());

		try {
			Log.d("salman", "ssss");
			// URL myURL = new URL(
			// "http://1-dot-supple-design-766.appspot.com/resources/psend/loc/"
			// + message1 + "/" + message2 + "/" + message3);
			// Log.d("hello", myURL.toString());
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);

			GetLatLong gt = new GetLatLong();

			EditText editText = (EditText) findViewById(R.id.addressET);
			String address = editText.getText().toString();

			GetLatLong
					.getLatLongFromGivenAddress("Old Mumbai Hwy, FCI Employees Cooperative Housing Society, Gachibowli Hyderabad, Telangana");

			// Toast.makeText(
			// getApplicationContext(),
			// new RequestTask().doInBackground(source, destination),
			// Toast.LENGTH_LONG).show();

			Log.d("salman", "abcd");
			System.out.println("hello");
			Location locationA = new Location(
					"IIIT Bus Stop, Old Mumbai Highway, FCI Employees Cooperative Housing Society, Gachibowli, Hyderabad, Telangana 500032");
			locationA.setLatitude(17.445287);
			locationA.setLongitude(78.352621);
			Location locationB = new Location(
					"Wipro Circle, ISB Road, Financial District, Nanakram Guda, Hyderabad, Telangana 500032");
			locationB.setLatitude(17.425814);
			locationB.setLongitude(78.340547);
			double distance = locationA.distanceTo(locationB);

			String d = gt.getDistance(17.445287, 78.352621, 17.434421,
					78.502550);
//
			Toast.makeText(
					MainActivity.this,
					Double.toString(GetLatLong.lat) + "\t"
							+ Double.toString(GetLatLong.lng) + "\n" + d,
					Toast.LENGTH_LONG).show();

			StrictMode.ThreadPolicy policy1 = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy1);

			Toast.makeText(getApplicationContext(),
					new RequestTask().doInBackground(source, destination),
					Toast.LENGTH_LONG).show();

		} catch (Exception e) {
			Log.d("salman", "hhhh");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Intent intent = new Intent(this ,DisplayMessageActivity.class );

		// Bundle extras = new Bundle();

		// extras.putString("Images",ImagePlace);
		// extras.putString("text1",message1);
		// extras.putString("text2",message2);
		// extras.putString("text3",message3);

		// intent.putExtras(extras);

		// Log.d("App_khan" ,message3 );
		// startActivity(intent);
		//
	}

}