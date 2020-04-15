package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

import de.svenjacobs.loremipsum.LoremIpsum;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ImageButton menuBtn;
    ImageButton searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoremIpsum loremIpsum=new LoremIpsum();
        AnhXa();
        ArrayList<Mail> arrayList=new ArrayList<>();
        for(int i=0;i<10;i++){
            Random obj = new Random();
            int rand_num = obj.nextInt(0xffffff + 1);
// format it as hexadecimal string and print
            String colorCode = String.format("#%06x", rand_num);
            String subject=loremIpsum.getParagraphs();
            String content1=loremIpsum.getParagraphs();
            String content2=loremIpsum.getParagraphs();
            String color=colorCode;
            Random generate=new Random();
            int hour=generate.nextInt(12)+1, minute=generate.nextInt(60);
            String time=hour+":"+minute+" P.M";
            arrayList.add(new Mail(subject,content1,content2,time,color));
        }

        MailAdapter mailAdapter=new MailAdapter(arrayList,this);
        list.setAdapter(mailAdapter);
    }
    void AnhXa(){
        list=findViewById(R.id.list);
        menuBtn=findViewById(R.id.menuBtn);
        searchBtn=findViewById(R.id.searchBtn);
    }
}
