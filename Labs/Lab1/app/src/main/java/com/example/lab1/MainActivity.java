package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textid);
        String text = "\t    Canadian National Anthem\n\n English version\n\n" +
                "\t    O Canada!\n" +
                "\t    Our home and native land!\n" +
                "\t    True patriot love in all of us command.\n" +
                "\t    With glowing hearts we see thee rise,\n" +
                "\t    The True North strong and free!\n" +
                "\t    From far and wide,\n" +
                "\t    O Canada, we stand on guard for thee.\n" +
                "\t    God keep our land glorious and free!\n" +
                "\t    O Canada, we stand on guard for thee.\n" +
                "\t    O Canada, we stand on guard for thee.\n" +
                "\n\n\n" +
                "\t    French version\n\n" +
                "\t    Ô Canada! Terre de nos aïeux,\n" +
                "\t    Ton front est ceint de fleurons glorieux!\n" +
                "\t    Car ton bras sait porter l'épée,\n" +
                "\t    Il sait porter la croix!\n" +
                "\t    Ton histoire est une épopée\n" +
                "\t    Des plus brillants exploits.\n" +
                "\t    Et ta valeur, de foi trempée,\n" +
                "\t    Protégera nos foyers et nos droits.\n" +
                "\t    Protégera nos foyers et nos droits.\n" +
                "\n\n\n" +
                "\t    Bilingual version\n\n" +
                "\t    O Canada! Our home and native land!\n" +
                "\t    True patriot love in all of us command,\n" +
                "\t    Car ton bras sait porter l'épée,\n" +
                "\t    Il sait porter la croix!\n" +
                "\t    Ton histoire est une épopée\n" +
                "\t    Des plus brillants exploits,\n" +
                "\t    God keep our land glorious and free!\n" +
                "\t    O Canada, we stand on guard for thee.\n" +
                "\t    O Canada, we stand on guard for thee.\n";
        SpannableString ss = new SpannableString(text);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 0, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
    }
}