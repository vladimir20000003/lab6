package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class SecondActivity  extends AppCompatActivity{
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle arguments = getIntent().getExtras();
        User user = (User) arguments.getSerializable(User.class.getSimpleName());
        TextView inf = (TextView) findViewById(R.id.username);
        inf.setText("Здравствуйте, " + user.getFirstname());
        ListView list = (ListView) findViewById(R.id.sites);

        ArrayList<Site> sites = new ArrayList<>();
        sites.add(new Site("Усадьба Дубровицы и Знаменская церковь", "Дворянская усадьба недалеко от Подольска (в деревне Дубровицы) была построена еще в XVII веке. Первым владельцем здания и земли в округе был боярин Морозов. В дальнейшем хозяева усадьбы менялись: здесь жили и Голицыны, и Дмитриевы-Мамоновы, и Потемкины.",
                R.drawable.dubr, 55.441287, 37.494456));
        sites.add(new Site("Фонтан Первый балл Наташи Ростовой", "Фонтан, посвященный героям произведения «Война и мир» – популярное место для встреч у влюбленных пар. Он установлен в 2014 году в честь Дня города. Идея создания фонтана принадлежит главе Подольска – Николаю Пестову. ",
                R.drawable.firstbal, 55.425181, 37.527570));
        sites.add(new Site("Площадь Славы", "Площадь Воинской Славы посвящена Великой Отечественной войне. На территории расположен мемориал в память о подвиге советского народа – установлен еще в 1971 году и в 2010-м реконструирован. ",
                R.drawable.ploslav, 55.432058, 37.554840));
        sites.add(new Site("Краеведческий музей", "История Подольского краеведческого музея началась в 1971 году — им занимались энтузиасты-общественники. Сначала экспозиция находилась в небольшом двухэтажном здании, но, благодаря местным жителям, коллекция быстро увеличилась.",
                R.drawable.museum, 55.432306, 37.549121));
        sites.add(new Site("Памятник подольским курсантам", "Памятник Подольским курсантам – это знаковый монумент, напоминающий о подвиге молодых курсантов во время Великой Отечественной войны. Именно эти люди сдерживали врагов на подступе к Москве до прихода советских войск.",
                R.drawable.kursant, 55.423096, 37.518342));
        sites.add(new Site("Усадьба Ивановское", "Ивановское — одна из самых известных усадеб Подмосковья. Еще 200 лет назад вокруг здания шумели леса и рядом тихо журчала речка Пахра, а ближайшим населенным пунктом было крестьянская деревня на несколько домов. Сегодня дворянское имение находится в черте города, сохраняя большую парковую территорию.",
                R.drawable.ivan, 55.434494, 37.521249));

        SitesAdapter sitesAdapter = new SitesAdapter(this, R.layout.list_item, sites);
        list.setAdapter(sitesAdapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Site selected = (Site) parent.getItemAtPosition(position);
                Intent intent=new Intent(SecondActivity.this,MapActivity.class);
                intent.putExtra("Site", selected);
                startActivity(intent);
            }
        };
        list.setOnItemClickListener(itemListener);

    }


}
