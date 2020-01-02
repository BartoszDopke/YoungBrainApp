package com.pracainzynierska.inzynierka;

import android.app.AlarmManager ;
import android.app.DatePickerDialog ;
import android.app.Notification ;
import android.app.PendingIntent ;
import android.content.Context ;
import android.content.Intent ;
import android.os.Bundle ;
import android.view.View ;
import android.widget.Button ;
import android.widget.DatePicker ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.text.SimpleDateFormat ;
import java.util.Calendar ;
import java.util.Date ;
import java.util.Locale ;
public class NotificationActivity extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
   // final Calendar myCalendar = Calendar.getInstance () ;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_notification) ;
    }

}