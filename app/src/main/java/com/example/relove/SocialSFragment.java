package com.example.relove;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SocialSFragment extends Fragment {
    RecyclerView recyclerView;
    private StoreAdapter adapter;
    RecyclerView.LayoutManager manager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_homes, container, false);
        ArrayList<StoreItem> storeItems = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recylerView);
        storeItems.add(new StoreItem("https://media.discordapp.net/attachments/939308082360639519/939785766500970516/Screen_Shot_2022-02-05_at_11.32.00_PM.png", "Venue\nCoordinator","4"));
        storeItems.add(new StoreItem("https://media.discordapp.net/attachments/939308082360639519/939784118709927958/Screen_Shot_2022-02-05_at_10.48.34_PM.png", "Event\nCatering","11"));
        storeItems.add(new StoreItem("https://media.discordapp.net/attachments/939308082360639519/939784120882585640/34x2lzer-900.jpg", "Party\nPlanners","9"));recyclerView = view.findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new StoreAdapter(storeItems);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        int spanCount = 3; // 3 columns
        int spacing = 150; // 50px
        boolean includeEdge = true;
        recyclerView.addItemDecoration(new SocialSFragment.GridSpacingItemDecoration(spanCount, spacing, includeEdge));
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