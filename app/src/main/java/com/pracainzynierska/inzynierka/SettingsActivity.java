package com.pracainzynierska.inzynierka;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SettingsActivity extends AppCompatActivity {

    Switch notificationSwitch;
    Button changeButton;
    TextView NicknameTextView;

    private NotificationManager mNotificationManager;
    public static final int NOTIFICATION_CHANNEL_ID = 0;
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.sound);
        String username = getIntent().getStringExtra("username");
        NicknameTextView =  findViewById(R.id.NicknameTextView);
        NicknameTextView.setText(username);
        NicknameTextView.setVisibility(View.INVISIBLE);

        changeButton = findViewById(R.id.nicknameChangeButton);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ProfileEditActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //save switch state
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        notificationSwitch = findViewById(R.id.NotificationSwitch);

        //Set up the Notification Broadcast Intent
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);

        //Check if the Alarm is already set, and check the toggle accordingly
        boolean alarmUp = (PendingIntent.getBroadcast(this, 0, notifyIntent,
                PendingIntent.FLAG_NO_CREATE) != null);

        notificationSwitch.setChecked(alarmUp);

        //Set up the PendingIntent for the AlarmManager
        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_CHANNEL_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                String toastMessage;
                if(isChecked){

                    Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                    alarmIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(Calendar.HOUR_OF_DAY, 8);
                    calendar.set(Calendar.MINUTE, 30);

                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY, alarmIntent);

                    //Set the toast message for the "on" case
                    toastMessage = getString(R.string.alarm_on_toast);
                } else {
                    //Cancel the alarm and notification if the alarm is turned off
                    alarmManager.cancel(notifyPendingIntent);
                    mNotificationManager.cancelAll();

                    //Set the toast message for the "off" case
                    toastMessage = getString(R.string.alarm_off_toast);
                }

                //Show a toast to say the alarm is turned on or off
                Toast.makeText(SettingsActivity.this, toastMessage, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}


