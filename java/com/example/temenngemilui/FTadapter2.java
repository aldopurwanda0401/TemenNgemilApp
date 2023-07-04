package com.example.temenngemilui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.temenngemilui.fragment_ususpedas.DeskripsiUsusPedas;
import com.example.temenngemilui.fragment_ususpedas.PesanUsusPedas;

public class FTadapter2 extends FragmentStateAdapter {
    public FTadapter2(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new DeskripsiUsusPedas();
        }else {
            return new PesanUsusPedas();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
