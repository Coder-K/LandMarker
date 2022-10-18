package com.example.landmarker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListViewConfig {
    private Context context;
    private  MarkAdapted  markAdapted;
    public  void  setConfig(RecyclerView recyclerView,Context context1,List<Marks> marksList,List<String> keys){

        markAdapted = new MarkAdapted(marksList,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context1));
        recyclerView.setAdapter(markAdapted);

    }

    class ListItemView extends RecyclerView.ViewHolder{
        private TextView Name, Address,Discription,Latitude,Longitude;

        private String key ;

        public ListItemView (ViewGroup parent){
            super(LayoutInflater.from(context).inflate(R.layout.landmark_list,parent,false));

            Name = (TextView) itemView.findViewById(R.id.name_txtv);
            Address = (TextView) itemView.findViewById(R.id.address_txtv);
            Discription =(TextView) itemView.findViewById(R.id.Discription_txtv);
            Latitude =(TextView) itemView.findViewById(R.id.longitude_txtv);
            Longitude =(TextView) itemView.findViewById(R.id.longitude_txtv);



        }
        public  void bind(Marks mark,String key){
            Name.setText(mark.getName());
            Address.setText(mark.getAddress());
            Discription.setText(mark.getDescription());
            Longitude.setText(mark.getLongitude());
            Latitude.setText(mark.getLatitude());
            this.key= key;


        }

    }
    class MarkAdapted extends RecyclerView.Adapter<ListItemView>{

        private List<Marks> marksList;
        private  List<String > keys;

        public MarkAdapted(List<Marks> marksList, List<String> keys) {
            this.marksList = marksList;
            this.keys = keys;
        }

        @NonNull
        @Override
        public ListItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ListItemView( parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ListItemView holder, int position) {
        holder.bind(marksList.get(position),keys.get(position));
        }

        @Override
        public int getItemCount() {
            return marksList.size();
        }
    }

}
