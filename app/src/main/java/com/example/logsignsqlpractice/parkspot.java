package com.example.logsignsqlpractice;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class parkspot extends AppCompatActivity {
    private TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkspot);

        textViewDisplay = findViewById(R.id.textViewDisplay);

        // Get data from DatabaseHelper2
        DatabaseHelper2 dbHelper = new DatabaseHelper2(this);
        Cursor cursor = dbHelper.getData();

        // Check if cursor is not null and has data
        if (cursor != null && cursor.moveToFirst()) {
            // Initialize a StringBuilder to store the data
            StringBuilder dataStringBuilder = new StringBuilder();

            // Loop through the cursor rows
            do {
                // Directly access column indexes
                int addressIndex = cursor.getColumnIndex("address");
                int spaceIndex = cursor.getColumnIndex("space");
                int vehiclePreferenceIndex = cursor.getColumnIndex("vehiclepreference");
                int datesIndex = cursor.getColumnIndex("dates");
                int timingOfAvailIndex = cursor.getColumnIndex("timingofavail");
                int amountIndex = cursor.getColumnIndex("amount");

                // Check if column indexes are valid (-1 indicates not found)
                if (addressIndex != -1 && spaceIndex != -1 && vehiclePreferenceIndex != -1 &&
                        datesIndex != -1 && timingOfAvailIndex != -1 && amountIndex != -1) {
                    // Retrieve data from cursor using column indexes
                    String address = cursor.getString(addressIndex);
                    String space = cursor.getString(spaceIndex);
                    String vehiclePreference = cursor.getString(vehiclePreferenceIndex);
                    String dates = cursor.getString(datesIndex);
                    String timingOfAvail = cursor.getString(timingOfAvailIndex);
                    String amount = cursor.getString(amountIndex);

                    // Append data to StringBuilder
                    dataStringBuilder.append("Address: ").append(address).append("\n")
                            .append("Space: ").append(space).append("\n")
                            .append("Vehicle Preference: ").append(vehiclePreference).append("\n")
                            .append("Dates: ").append(dates).append("\n")
                            .append("Timing of Availability: ").append(timingOfAvail).append("\n")
                            .append("Amount: ").append(amount).append("\n\n");
                }
            } while (cursor.moveToNext());

            // Close the cursor
            cursor.close();

            // Set the text of the TextView to the data stored in the StringBuilder
            textViewDisplay.setText(dataStringBuilder.toString());
        } else {
            // If cursor is empty or null, display a message
            textViewDisplay.setText("No data available.");
        }
    }
}
