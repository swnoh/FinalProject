package com.example.cst2335.finalproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Displays the outside weather, includes a picture, current, maximum, and minimum temperature and
 * a progress bar.
 ************************************************************************************************/
public class OutsideWeatherFragment extends Fragment {

    /**
     * Attributes
     *******************************************************************************/
    protected static final String ACTIVITY_NAME = "OutsideWeather_Fragment";
    private ImageView weatherImage;
    private TextView currentTempTextView;
    private TextView minTempTextView;
    private TextView maxTempTextView;
    private ProgressBar progressBar;

    /**
     * Default constructor
     ********************************************************************************/
    public OutsideWeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Set view and inflate layout and initialize all widgets
     *******************************************************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_outside_weather, container, false);
        // Inflate the layout for this fragment
        setRetainInstance(true);

       /* Initialize widgets */
       weatherImage = (ImageView) view.findViewById(R.id.imageView3);
       currentTempTextView = (TextView) view.findViewById(R.id.textView3);
       minTempTextView = (TextView) view.findViewById(R.id.textView4);
       maxTempTextView = (TextView) view.findViewById(R.id.textView5);
       progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

       progressBar.setVisibility(View.VISIBLE);
       String url_weather = "http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=d99666875e0e51521f0040a3d97d0f6a&mode=xml&units=metric";

       /* Call execute(), then android will call the 3 methods from the inner class */
       ForecastQuery forecastObject = new ForecastQuery();
       forecastObject.execute(url_weather);  //execute() will automatically call the 3 functions in the AsyncTask interface

       Log.i(ACTIVITY_NAME, "In onCreate()");
       return view;

   }//end onCreateView()


    /**
     * ForcastQuery class - inner class to handle the AsyncTask
     * *****************************************************************************************/
    private class ForecastQuery extends AsyncTask<String, Integer, String> {

        /**
         * Attribute
         ************************************************************/
        private String currentTemperature;
        private String minTemperature;
        private String maxTemperature;
        private String iconName;
        private Bitmap weatherPic;

        //parse part
        private XmlPullParser parser;
        private int status;
        int eventType;
        String tagName = null;

        /**
         *  Parameter passed in are a array list.
         *  Process the url connection, getting the temperatures, and picture
         **************************************************************************************/
        protected String doInBackground(String... args) {
            Log.i(ACTIVITY_NAME, "In doInBackground()");

            URL url = null;
            HttpURLConnection myConnection = null;

            try {
                url = new URL(args[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();
                InputStream theStream = connection.getInputStream();

                parser = Xml.newPullParser();
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                parser.setInput(theStream, null);
                parser.nextTag();

                eventType = XmlPullParser.START_DOCUMENT;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            tagName = parser.getName();
                            if (tagName.equals("temperature")) {
                                currentTemperature = parser.getAttributeValue(null, "value");
                                publishProgress(25);
                                minTemperature = parser.getAttributeValue(null, "min");
                                publishProgress(50);
                                maxTemperature = parser.getAttributeValue(null, "max");
                                publishProgress(75);
                            }

                            if (tagName.equals("weather")) {
                                iconName = parser.getAttributeValue(null, "icon");
                            }

                    }
                    eventType = parser.next();
                }

                String imageFile = iconName + ".png";

                /* Check if image file exist  */
                if (fileExistance(imageFile)) {
                    Log.i(ACTIVITY_NAME, "Found weather image locally: " + imageFile);
                    FileInputStream inputStream = null;
                    try {
                        inputStream = new FileInputStream(getActivity().getBaseContext().getFileStreamPath(imageFile));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    weatherPic = BitmapFactory.decodeStream(inputStream);
                }

                URL theImageURL = new URL("http://openweathermap.org/img/w/" + iconName + ".png");
                weatherPic = getImage(theImageURL);

                Log.i(ACTIVITY_NAME, "Weather image was downloaded: " + imageFile);

                FileOutputStream outputStream = getActivity().openFileOutput(iconName + ".png", Context.MODE_PRIVATE);
                weatherPic.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
                outputStream.flush();
                outputStream.close();

                publishProgress(100);  //complete upload


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (XmlPullParserException xmle) {
                xmle.printStackTrace();
            }

            return "";
        }

        /**
         *  Get weather image from website
         ***********************************************************************/
        public Bitmap getImage(URL url) {
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    return BitmapFactory.decodeStream(connection.getInputStream());
                } else
                    return null;
            } catch (Exception e) {
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }//end Bitmap()

        /** Check if weather image file exist.
         ******************************************************************************/
        public boolean fileExistance(String fName) {
            File file = getActivity().getBaseContext().getFileStreamPath(fName);
            return file.exists();
        }//end fileExistance()

        /**
         *  Processes the progress. Passes in an array of integers.
         ***************************************************************************/
        protected void onProgressUpdate(Integer... value) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(value[0]);
        }//end onProgressUpdate()

        /**
         *  Display temperature output.
         * *************************************************************************/
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.INVISIBLE);
            weatherImage.setImageBitmap(weatherPic);
            currentTempTextView.setText("Current temperature: " + currentTemperature);
            minTempTextView.setText("Minimum temperature: " + minTemperature);
            maxTempTextView.setText("Maximum temperature: " + maxTemperature);
        }//end onPostExecute()
    }

 }/* END OutsideWeatherFragment Class */