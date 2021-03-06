package Activities;

import Adapters.FragmentAdapters.FragmentPagerAdapterHastalar;
import Adapters.FragmentAdapters.FragmentPagerAdapterZiyaretler;
import DataBaseSQLite.DataBaseSQLiteOfPatient.DBSQLiteOfAllPatients;
import Dialogs.Dialog_ExitApp;
import Fragments.HastaListesi.*;
import Fragments.RandevuListesi.frg_TumRandevuler;
import Fragments.ZiyaretListesi.frg_ZiyaretListesiBasarili;
import Fragments.ZiyaretListesi.frg_ZiyaretListesiBasarisiz;
import Fragments.ZiyaretListesi.frg_ZiyaretListesiTum;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.esh_ajanda.R;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.util.ArrayList;

public class ZiyaretlerActivity extends AppCompatActivity {


    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;
    DBSQLiteOfAllPatients liteOfAllPatients;
    FragmentPagerAdapterZiyaretler adapter;


    ArrayList<Fragment> fragments= new ArrayList<>();
    ArrayList<String> tab_isimleri=new ArrayList<>();

    Context context=ZiyaretlerActivity.this;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ziyaretler);



        liteOfAllPatients = new DBSQLiteOfAllPatients(ZiyaretlerActivity.this);
        liteOfAllPatients.onCreate(liteOfAllPatients.getWritableDatabase());




        toolbar=findViewById(R.id.toolbar_ziyaretler_activity);

        setSupportActionBar(toolbar);

        sayfalariEkle();

        adapter= new FragmentPagerAdapterZiyaretler(
                getSupportFragmentManager(),this,
                fragments,tab_isimleri);


        tabLayout=findViewById(R.id.tablayout_ziyaretler_activity);

        viewPager=findViewById(R.id.viewpager_ziyaretler_activity);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ZiyaretlerActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });






    }





    public  void sayfalariEkle()
    {


        fragments.add(new frg_ZiyaretListesiTum(context));
        fragments.add(new frg_ZiyaretListesiBasarili(context));
        fragments.add(new frg_ZiyaretListesiBasarisiz(context));


        tab_isimleri.add("TÜM ZİYARETLER");
        tab_isimleri.add("TAMAMLANMIŞ ZİYARETLER");
        tab_isimleri.add("TAMAMLANMAMIŞ ZİYARETLER");



    }

    @Override
    public void onBackPressed() {

        new Dialog_ExitApp(context).show();

    }

}