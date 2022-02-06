package com.example.relove;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeSFragment extends Fragment {

    RecyclerView recyclerView;
    private StoreAdapter adapter;
    RecyclerView.LayoutManager manager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_homes, container, false);
        ArrayList<StoreItem> storeItems = new ArrayList<>();
        storeItems.add(new StoreItem("https://cdn.discordapp.com/attachments/939308082360639519/939825683323039744/house.jpg", "Home\nCleaners","19"));
        storeItems.add(new StoreItem("https://cdn.discordapp.com/attachments/939308082360639519/939825683050401802/carpet.jpg", "Carpet\nCleaners","4"));
        storeItems.add(new StoreItem("https://cdn.discordapp.com/attachments/939308082360639519/939825683591462922/canvas-hd-prints-paintings-5-pieces-golden.jpg", "Decorators","49"));
        recyclerView = view.findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new StoreAdapter(storeItems);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        int spanCount = 3; // 3 columns
        int spacing = 150; // 50px
        boolean includeEdge = true;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent event) {
                int action = event.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);

                        break;

                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView view, @NonNull MotionEvent event) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


        adapter.setOnItemClickListener(new StoreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), StoreSActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}