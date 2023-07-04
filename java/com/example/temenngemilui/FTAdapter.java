package com.example.temenngemilui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.temenngemilui.fragment_basrengpedas.DeskripsiBasrengPedas;
import com.example.temenngemilui.fragment_basrengpedas.PesanBasrengPds;

public class FTAdapter extends FragmentStateAdapter {
    public FTAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new DeskripsiBasrengPedas();
        }else {
            return new PesanBasrengPds();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
