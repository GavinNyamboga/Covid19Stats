package com.dev.covid19stats.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.dev.covid19stats.R;
import com.dev.covid19stats.models.GlobalResources;
import com.dev.covid19stats.network.APIInterface;
import com.dev.covid19stats.network.NetworkStatus;
import com.dev.covid19stats.network.RetrofitClientInstance;

import java.text.NumberFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalFragment extends Fragment {


    APIInterface apiInterface;



    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_global, container, false);

        NetworkStatus networkStatus = new NetworkStatus();
        if (networkStatus.isConnected(getContext())){
            apiInterface = RetrofitClientInstance.getRetrofitInstance().create(APIInterface.class);


            final TextView cases = root.findViewById(R.id.cases_total);
            final TextView recoveries = root.findViewById(R.id.recoveries_total);
            final TextView deaths = root.findViewById(R.id.deaths_total);
            final TextView active = root.findViewById(R.id.active_total);
            final TextView critical = root.findViewById(R.id.critical_total);

            Call<GlobalResources> call = apiInterface.getListResources();
            call.enqueue(new Callback<GlobalResources>() {
                @Override
                public void onResponse(Call<GlobalResources> call, Response<GlobalResources> response) {


                    GlobalResources resources = response.body();

                    if(resources != null) {
                        Integer text = resources.cases;
                        Integer text2 = resources.recovered;
                        Integer text3 = resources.deaths;
                        Integer text4 = resources.active;
                        Integer text5 = resources.critical;

                        String displayCases = NumberFormat.getIntegerInstance().format(text);
                        cases.setText(displayCases);
                        String displayRecoveries = NumberFormat.getIntegerInstance().format(text2);
                        recoveries.setText(displayRecoveries);
                        String displayDeaths = NumberFormat.getIntegerInstance().format(text3);
                        deaths.setText(displayDeaths);
                        String displayActive = NumberFormat.getIntegerInstance().format(text4);
                        active.setText(displayActive);
                        String displayCritical = NumberFormat.getIntegerInstance().format(text5);
                        critical.setText(displayCritical);
                    }

                }

                @Override
                public void onFailure(Call<GlobalResources> call, Throwable t) {

                }
            });
        }
        else {


            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Connect to a network to get the latest results!")
                    .setPositiveButton("OK",null);
            builder.show();

        }




        return root;
    }

}