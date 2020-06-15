package com.example.admin.elanlivelearningapp.Bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.admin.elanlivelearningapp.CustomAdapter;
import com.example.admin.elanlivelearningapp.CustomAdapterMicro;
import com.example.admin.elanlivelearningapp.CustomAdapterdescount;
import com.example.admin.elanlivelearningapp.MtemModel;
import com.example.admin.elanlivelearningapp.MtemModelMicro;
import com.example.admin.elanlivelearningapp.MtemModeldescount;
import com.example.admin.elanlivelearningapp.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by Belal on 1/23/2018.
 */

public class HomeFragment extends Fragment {
    @Nullable
    private ArrayList<String> mNames = new ArrayList<>();



    ArrayList<MtemModel> arrayList;
    ArrayList<MtemModeldescount> arrayListdecount;
    ArrayList<MtemModelMicro> arraymicro;
    RecyclerView recyclerView,recyclerView2,recyclerView3;

    GridView gridView,gridView1;

    int icons[] = {R.drawable.crashcourse,R.drawable.vacabulry,R.drawable.quiz,R.drawable.zolozy,R.drawable.crashcourse,R.drawable.vacabulry,R.drawable.quiz,R.drawable.zolozy};
    String iconsName[] = {"Crash Cours..", "Vocubulary", "New-V Qui..", "Zoology-L..", "Brainy Bot", "Got It?", "Daily News", "Get Punny"};

    int iconsdecount[] = {R.drawable.livea,R.drawable.liveb,R.drawable.livec,R.drawable.livea,R.drawable.liveb,R.drawable.livec,R.drawable.livea,R.drawable.liveb,R.drawable.livec};
    String iconsNamedeount[] = {"GERMAN LANGUAGE (A1,A2,B1,B2,C1,C2)", "IELTS / PTE / TOEFEL", "MBA Entrance Exam: CAT","GERMAN LANGUAGE (A1,A2,B1,B2,C1,C2)", "IELTS / PTE / TOEFEL", "MBA Entrance Exam: CAT","GERMAN LANGUAGE (A1,A2,B1,B2,C1,C2)", "IELTS / PTE / TOEFEL", "MBA Entrance Exam: CAT"};

    int iconsmicro[] = {R.drawable.livea,R.drawable.liveb,R.drawable.livec,R.drawable.livea,R.drawable.liveb,R.drawable.livec,R.drawable.livea,R.drawable.liveb,R.drawable.livec};
    String iconsNamemicro[] = {"GERMAN LANGUAGE (A1,A2,B1,B2,C1,C2)", "IELTS / PTE / TOEFEL", "MBA Entrance Exam: CAT","GERMAN LANGUAGE (A1,A2,B1,B2,C1,C2)", "IELTS / PTE / TOEFEL", "MBA Entrance Exam: CAT","GERMAN LANGUAGE (A1,A2,B1,B2,C1,C2)", "IELTS / PTE / TOEFEL", "MBA Entrance Exam: CAT"};

    private static final String TAG = "MainActivity";
    TextView textView;
    ViewPager mViewPager;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View rootview = inflater.inflate(R.layout.fragment_home_elan, null);
        mViewPager = (ViewPager) rootview.findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(getActivity());
        mViewPager.setAdapter(adapterView);


        mViewPager= (ViewPager) rootview.findViewById(R.id.viewPage);
        CirclePageIndicator indicator1 = (CirclePageIndicator)
                rootview.findViewById(R.id.indicator2);


        indicator1.setViewPager(mViewPager);

        final float density = getResources().getDisplayMetrics().density;

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerofersandsbrands);
        arrayList = new ArrayList<MtemModel>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView2 = (RecyclerView) rootview.findViewById(R.id.recycview2);
        arrayListdecount = new ArrayList<MtemModeldescount>();

        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        recyclerView3 = (RecyclerView) rootview.findViewById(R.id.recycview3);
        arraymicro = new ArrayList<MtemModelMicro>();

        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView3.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0; i < icons.length; i++) {
            MtemModel itemModel = new MtemModel();
            itemModel.setImage(icons[i]);
            itemModel.setName(iconsName[i]);

            //add in array list
            arrayList.add(itemModel);
        }

        for (int i = 0; i < iconsdecount.length; i++) {
            MtemModeldescount itemModel1 = new MtemModeldescount();
            itemModel1.setImage(iconsdecount[i]);
            itemModel1.setName(iconsNamedeount[i]);

            //add in array list
            arrayListdecount.add(itemModel1);
        }

        for (int i = 0; i < iconsmicro.length; i++) {
            MtemModelMicro itemModel3 = new MtemModelMicro();
            itemModel3.setImage(iconsmicro[i]);
            itemModel3.setName(iconsNamemicro[i]);

            //add in array list
            arraymicro.add(itemModel3);
        }
        CustomAdapter adapter = new CustomAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);

        CustomAdapterdescount adapter1 = new CustomAdapterdescount(getActivity(), arrayListdecount);
        recyclerView2.setAdapter(adapter1);

        CustomAdapterMicro adapter3 = new CustomAdapterMicro(getActivity(), arraymicro);
        recyclerView3.setAdapter(adapter3);


        return rootview;
    }
}
