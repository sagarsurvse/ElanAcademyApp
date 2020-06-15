package com.example.admin.elanlivelearningapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rahuljanagouda.statusstories.StatusStoriesActivity;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder> {

    Context context;
    ArrayList<MtemModel> arrayList;
    boolean isCacheEnabled = true;
    boolean isImmersiveEnabled = true;
    boolean isTextEnabled = true;
    long storyDuration = 3000L;

    DatabaseReference databaseReference,status2,status3,status4,status5,status6,status7,status8;

    public CustomAdapter(Context context, ArrayList<MtemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public  CustomAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_listitem, viewGroup, false);
        return new viewHolder(view);
    }
    @Override
    public  void onBindViewHolder(CustomAdapter.viewHolder viewHolder,int position) {
        viewHolder.iconName.setText(arrayList.get(position).getName());
        viewHolder.icon.setImageResource(arrayList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView icon;
        TextView iconName;
        private final Context contextS;

        public viewHolder(View itemView) {
            super(itemView);
            contextS = itemView.getContext();
            icon = (CircleImageView) itemView.findViewById(R.id.icon);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);



        }
      /*  @Override
        public void onClick(View v) {

            Toast.makeText(contextS,"The Item Clicked is: "+getLayoutPosition(),Toast.LENGTH_SHORT).show();
        }*/

       public void onClick(View v) {
            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    /*intent =  new Intent(context, CoursesActivity.class);
                    Toast.makeText(context, "succussss", Toast.LENGTH_SHORT).show();*/
                    databaseReference = FirebaseDatabase.getInstance().getReference("All_Image_Uploads_Database");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                               Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;

                case 1:
                    status2 = FirebaseDatabase.getInstance().getReference("staus2");
                    status2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                                Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;


                case 2:
                    status3 = FirebaseDatabase.getInstance().getReference("staus3");
                    status3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                                Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;

                case 3:
                    status4 = FirebaseDatabase.getInstance().getReference("staus4");
                    status4.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                                Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;


                case 4:
                    status5 = FirebaseDatabase.getInstance().getReference("staus5");
                    status5.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                                Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;


                case 5:
                    status6 = FirebaseDatabase.getInstance().getReference("staus6");
                    status6.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                                Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;


                case 6:
                    status7 = FirebaseDatabase.getInstance().getReference("staus7");
                    status7.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                                Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;

                case 7:
                    status8 = FirebaseDatabase.getInstance().getReference("staus8");
                    status8.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {



                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                                ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);
                                String sagar = imageUploadInfo.getImageURL().toString();

                                String[] resources = new String[]{sagar};

                                Intent a = new Intent(context, StatusStoriesActivity.class);
                                a.putExtra(StatusStoriesActivity.STATUS_RESOURCES_KEY, resources);
                                a.putExtra(StatusStoriesActivity.STATUS_DURATION_KEY, storyDuration);
                                a.putExtra(StatusStoriesActivity.IS_IMMERSIVE_KEY, isImmersiveEnabled);
                                a.putExtra(StatusStoriesActivity.IS_CACHING_ENABLED_KEY, isCacheEnabled);
                                a.putExtra(StatusStoriesActivity.IS_TEXT_PROGRESS_ENABLED_KEY, isTextEnabled);
                                context.startActivity(a);
                            }




                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {



                        }
                    });

                    break;


                default:
                    intent =  new Intent(context, CoursesActivity.class);
                    break;
            }
            /*context.startActivity(intent);*/
        }
    }




}