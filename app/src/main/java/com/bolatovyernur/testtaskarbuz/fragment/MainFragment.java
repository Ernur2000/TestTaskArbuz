package com.bolatovyernur.testtaskarbuz.fragment;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolatovyernur.testtaskarbuz.model.Date;
import com.bolatovyernur.testtaskarbuz.model.Place;
import com.bolatovyernur.testtaskarbuz.R;
import com.bolatovyernur.testtaskarbuz.model.Time;
import com.bolatovyernur.testtaskarbuz.model.Weight;
import com.bolatovyernur.testtaskarbuz.adapter.DateAdapter;
import com.bolatovyernur.testtaskarbuz.interfaces.DateRecyclerViewClickListener;
import com.bolatovyernur.testtaskarbuz.adapter.PlaceAdapter;
import com.bolatovyernur.testtaskarbuz.interfaces.PlaceRecyclerviewClickListener;
import com.bolatovyernur.testtaskarbuz.adapter.TimeAdapter;
import com.bolatovyernur.testtaskarbuz.interfaces.TimeRecyclerViewClickListener;
import com.bolatovyernur.testtaskarbuz.adapter.WeightAdapter;
import com.bolatovyernur.testtaskarbuz.interfaces.WeightRecyclerViewClickListener;
import com.bolatovyernur.testtaskarbuz.databinding.FragmentMainBinding;
import com.bolatovyernur.testtaskarbuz.db.AppDatabase;
import com.bolatovyernur.testtaskarbuz.db.Info;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainFragment extends Fragment implements PlaceRecyclerviewClickListener, WeightRecyclerViewClickListener, DateRecyclerViewClickListener, TimeRecyclerViewClickListener {
    private FragmentMainBinding binding;
    private final ArrayList<Place> place = new ArrayList<>();
    private final ArrayList<Weight> weight = new ArrayList<>();
    private final ArrayList<Date> date = new ArrayList<>();
    private final ArrayList<Time> time = new ArrayList<>();
    private AppDatabase db;
    private int num = 1;
    private int posPlace;
    private int posWeight;
    private int posDate;
    private int posTime;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapter();
        fillData();
        setOnclickListener(view);
    }
    public void fillData(){
        String[] quotes = new String[] {"неспелый", "спелый", "уже сорван"};
        String randomQuote = quotes[(int) (Math.random() * quotes.length)];
        binding.tvState.setText(randomQuote);
        binding.tvState.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        place.add(new Place("1 ряд 1 место"));
        place.add(new Place("1 ряд 2 место"));
        place.add(new Place("1 ряд 3 место"));
        place.add(new Place("2 ряд 1 место"));
        place.add(new Place("2 ряд 2 место"));
        place.add(new Place("2 ряд 3 место"));

        weight.add(new Weight("3-5кг"));
        weight.add(new Weight("6-8кг"));
        weight.add(new Weight("9+кг"));

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d", new Locale("ru"));
        String day = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String tomorrow = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String thirdDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String forthDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String fifthDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String sixthDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String sevensDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String eightsDay = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR,1);
        String ninesDay = dateFormat.format(calendar.getTime());

        date.add(new Date(day));
        date.add(new Date(tomorrow));
        date.add(new Date(thirdDay));
        date.add(new Date(forthDay));
        date.add(new Date(fifthDay));
        date.add(new Date(sixthDay));
        date.add(new Date(sevensDay));
        date.add(new Date(eightsDay));
        date.add(new Date(ninesDay));

        time.add(new Time("11:00-13:00"));
        time.add(new Time("12:00-14:00"));
        time.add(new Time("13:00-15:00"));
        time.add(new Time("14:00-16:00"));
        time.add(new Time("15:00-17:00"));
        time.add(new Time("16:00-18:00"));
        time.add(new Time("17:00-19:00"));
        time.add(new Time("18:00-20:00"));
        time.add(new Time("19:00-21:00"));
        time.add(new Time("20:00-22:00"));
    }
    public void setAdapter(){
        LinearLayoutManager layoutManagerHorizontal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerHorizontal2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerHorizontal3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerHorizontal4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvPlace.setLayoutManager(layoutManagerHorizontal);
        binding.rvWeight.setLayoutManager(layoutManagerHorizontal2);
        binding.rvDate.setLayoutManager(layoutManagerHorizontal3);
        binding.rvTime.setLayoutManager(layoutManagerHorizontal4);

        binding.rvPlace.setHasFixedSize(true);
        binding.rvWeight.setHasFixedSize(true);
        binding.rvDate.setHasFixedSize(true);
        binding.rvTime.setHasFixedSize(true);

        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(),place,this);
        binding.rvPlace.setAdapter(placeAdapter);

        WeightAdapter weightAdapter = new WeightAdapter(getContext(),weight,this);
        binding.rvWeight.setAdapter(weightAdapter);

        DateAdapter dateAdapter = new DateAdapter(getContext(),date,this);
        binding.rvDate.setAdapter(dateAdapter);

        TimeAdapter timeAdapter = new TimeAdapter(getContext(),time,this);
        binding.rvTime.setAdapter(timeAdapter);
        binding.tvNum.setText(MessageFormat.format("{0}", num));
    }
    public void setOnclickListener(View view){
        db = AppDatabase.getDbInstance(view.getContext().getApplicationContext());
        binding.tvPlus.setOnClickListener(view1 -> {
            if (num<3) {
                binding.tvNum.setText(MessageFormat.format("{0}", ++num));
            }
        });

        binding.tvMinus.setOnClickListener(view1 -> {
            if (num>1) {
                binding.tvNum.setText(MessageFormat.format("{0}", --num));
            }
        });
        binding.btnOrder.setOnClickListener(view1 -> {
            List<Info> info = new ArrayList<>();
            info.add(new Info(1,place.get(posPlace).toString(),weight.get(posWeight).toString(),binding.tvState.getText().toString(),
                    binding.tvCount.getText().toString(),binding.edCity.getText().toString(),
                    binding.edStreet.getText().toString(),binding.edFlat.getText().toString(),
                    binding.edFloor.getText().toString(),date.get(posDate).toString(),time.get(posTime).toString(),binding.edName.getText().toString(),
                    binding.edComment.getText().toString(),binding.checkbox.isChecked()));
            db.infoDao().insertInfo(info);
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_orderSuccessFragment);
        });
    }

    @Override
    public void recyclerviewClickListener(int position) {
        posPlace = position;
    }

    @Override
    public void weightRecyclerviewClickListener(int position) {
        posWeight = position;
    }

    @Override
    public void dateRecyclerViewClickListener(int position) {
        posDate = position;
    }

    @Override
    public void timeRecyclerViewClickListener(int position) {
        posTime = position;
    }
}