package Fragments.ZiyaretListesi;

import Activities.HomeActivity;
import Patient.VisitInformations;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.example.esh_ajanda.R;

import java.util.ArrayList;

public class frg_ZiyaretListesiBasarisiz extends Base_frg_ZiyaretListesi {


    public frg_ZiyaretListesiBasarisiz(Context context) {
        super(context,VisitInformations.TAMAMLANMADI);
    }






    @Override
    public void genel_guncelle() {

        innerVisits=dbsqLiteOfVisit.getAllUnCompletedVisitsOfPatient();

        setAdapter(innerVisits,innerVisits.size());

    }

    @Override
    public void onResume() {
        super.onResume();

        genel_guncelle();
    }



    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        boolean sonuc=false;

        switch (item.getItemId())
        {
            case R.id.menu_ziyaretler_yenile:

                genel_guncelle();

                sonuc=true;

                break;

            case R.id.menu_ziyaretler_ana_sayfaya_git:


                Intent intent= new Intent(activity, HomeActivity.class);
                activity.startActivity(intent);

                activity.finish();

                sonuc=true;
                break;

        }


        return sonuc;

    }



}
