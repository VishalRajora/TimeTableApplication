package com.example.childrenstables;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView timestablelistview;
    public void finaltimetable ( int timetable)
    {

        ArrayList <String> timetablecontent = new ArrayList <String> (  );

        for(int i = 1 ; i<= 10; i++)
        {
            timetablecontent.add ( String.valueOf ( i * timetable ) );

        }
        ArrayAdapter <String> arrayAdapter =new ArrayAdapter <String> ( this,android.R.layout.simple_list_item_1 , timetablecontent)
        {

            @Override
            public View getView(int position ,  View convertView , ViewGroup parent)
            { TextView item = ( TextView ) super.getView(position,convertView,parent);



                // Set the list view item's text color
                item.setTextColor( Color.parseColor("#212121"));

                // Set the item text style to bold
                item.setTypeface(item.getTypeface(), Typeface.BOLD);

                // Change the item text size
                item.setTextSize( TypedValue.COMPLEX_UNIT_DIP,20);

                // return the view
                return item;
            }
        };
        timestablelistview.setAdapter ( arrayAdapter );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timestableseekbar=(SeekBar)findViewById ( R.id.seekbar );
        timestablelistview =(ListView)findViewById ( R.id.list );

        timestableseekbar.setMax ( 20 );
        timestableseekbar.setProgress ( 10 );

        timestableseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                int min = 1;
                int timetable;

                if(progress < min)
                {
                    timetable=min;
                    timestableseekbar.setProgress ( min );

                }
                else
                {
                    timetable = progress;
                }
                finaltimetable ( timetable );



                Log.i ("seeka" , String.valueOf ( timetable ) );

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {


            }
        });

                   finaltimetable ( 10 );
    }
}
