package com.example.admin.elanlivelearningapp.Bottom;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.admin.elanlivelearningapp.Bottom.Models.FirebaseMessageModel;
import com.example.admin.elanlivelearningapp.Bottom.Models.FirebaseUserModel;
import com.example.admin.elanlivelearningapp.Bottom.Models.MessageCell;
import com.example.admin.elanlivelearningapp.Bottom.Models.User;
import com.example.admin.elanlivelearningapp.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by Belal on 1/23/2018.
 */

public class AskFragment extends Fragment {
    @Nullable
    User user = User.getInstance();
    private static final String TAG = "AskFragment";
    ListView listView;

    EditText textComment;
    ImageView btnSend;

    List<FirebaseMessageModel> messages = new ArrayList<FirebaseMessageModel>();

    FirebaseDatabase database;
    DatabaseReference messagesRef;
    DatabaseReference usersRef;



    JSONArray registration_ids = new JSONArray();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View rootview = inflater.inflate(R.layout.activity_chatting, null);
        database = FirebaseDatabase.getInstance();
        usersRef = database.getReference("users");
        messagesRef = database.getReference("messages");





        listView = (ListView) rootview.findViewById(R.id.chattingList);

        textComment = (EditText) rootview.findViewById(R.id.comment_text);
        btnSend = (ImageView) rootview.findViewById(R.id.send_button);
        btnSend.setEnabled(false);
        btnSend.setColorFilter(getResources().getColor(android.R.color.darker_gray));

        textComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() < 5) {
                    btnSend.setEnabled(false);
                    btnSend.setColorFilter(getResources().getColor(android.R.color.darker_gray));
                } else {
                    btnSend.setEnabled(true);
                    btnSend.setColorFilter(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });

        final ProgressDialog Dialog = new ProgressDialog(getActivity());
        Dialog.setMessage("Please wait..");
        Dialog.setCancelable(false);
        Dialog.show();

        final com.google.firebase.database.ValueEventListener commentValueEventListener = new com.google.firebase.database.ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                messages.clear();

                for (com.google.firebase.database.DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    System.out.println("Child: " + postSnapshot);
                    //Getting the data from snapshot
                    FirebaseMessageModel firebaseMessageModel = postSnapshot.getValue(FirebaseMessageModel.class);
                    firebaseMessageModel.setId(postSnapshot.getKey());
                    messages.add(firebaseMessageModel);
                }

                updateListView();

                if (Dialog.isShowing()) {
                    Dialog.dismiss();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                messages.clear();
                updateListView();

                if (Dialog.isShowing()) {
                    Dialog.dismiss();
                }
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        };

        final com.google.firebase.database.ValueEventListener userValueEventListener = new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                registration_ids = new JSONArray();

                for (com.google.firebase.database.DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    System.out.println("Child: " + postSnapshot);
                    //Getting the data from snapshot
                    FirebaseUserModel firebaseUserModel = postSnapshot.getValue(FirebaseUserModel.class);
                    if (!firebaseUserModel.getDeviceId().equals(user.deviceId) && !firebaseUserModel.getDeviceToken().isEmpty()) {
                        registration_ids.put(firebaseUserModel.getDeviceToken());
                    }
                }

                if (Dialog.isShowing()) {
                    Dialog.dismiss();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                registration_ids = new JSONArray();

                if (Dialog.isShowing()) {
                    Dialog.dismiss();
                }
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        };

        usersRef.addValueEventListener(userValueEventListener);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*hideKeyboard();*/

                final String wishMessage = textComment.getText().toString().trim();
                if (wishMessage.isEmpty()) {
                    return;
                } else {
                    // send text as wish

                    final FirebaseMessageModel firebaseMessageModel = new FirebaseMessageModel();
                    firebaseMessageModel.setText(wishMessage);
                    firebaseMessageModel.setSenderDeviceId(user.deviceId);
                    firebaseMessageModel.setSenderName(user.name);

                    final ProgressDialog Dialog = new ProgressDialog(getActivity());
                    Dialog.setMessage("Please wait..");
                    Dialog.setCancelable(false);
                    Dialog.show();

                    final DatabaseReference newRef = messagesRef.push();
                    newRef.setValue(firebaseMessageModel, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            Dialog.dismiss();

                            if (databaseError != null) {
                                Log.i(TAG, databaseError.toString());
                            } else {
                                textComment.setText("");

                                if (registration_ids.length() > 0) {

                                    String url = "https://fcm.googleapis.com/fcm/send";
                                    AsyncHttpClient client = new AsyncHttpClient();

                                    client.addHeader(HttpHeaders.AUTHORIZATION, "key=AIzaSyDhczg_GmSEe_yBiLCxLRxGtYI7mha7tVA");
                                    client.addHeader(HttpHeaders.CONTENT_TYPE, RequestParams.APPLICATION_JSON);

                                    try {
                                        JSONObject params = new JSONObject();

                                        params.put("registration_ids", registration_ids);

                                        JSONObject notificationObject = new JSONObject();
                                        notificationObject.put("body", wishMessage);
                                        notificationObject.put("title", user.name);

                                        params.put("notification", notificationObject);

                                        StringEntity entity = new StringEntity(params.toString());

                                        client.post(getActivity(), url, entity, RequestParams.APPLICATION_JSON, new TextHttpResponseHandler() {
                                            @Override
                                            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                                                Dialog.dismiss();
                                                Log.i(TAG, responseString);
                                            }

                                            @Override
                                            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                                                Dialog.dismiss();
                                                Log.i(TAG, responseString);
                                            }
                                        });

                                    } catch (Exception e) {

                                    }
                                }

                            }
                        }
                    });

                    messagesRef.addValueEventListener(commentValueEventListener);

                }
            }
        });

        //Value event listener for realtime data update
        messagesRef.addValueEventListener(commentValueEventListener);

        return rootview;
    }
    /*public void hideKeyboard() {
        try  {
            InputMethodManager inputManager = (InputMethodManager) AskFragment.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(AskFragment.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            Log.i(TAG, "Exception while hiding keyboard");
        }
    }*/

    public void updateListView() {
        Log.i(TAG, "Inside prepareWishList()");

        int totalWishes = messages.size();

        Log.i(TAG, "Total Wishes : " + totalWishes);

        MessageCell[] messageCells;
        messageCells = new MessageCell[totalWishes];

        for (int counter = 0; counter < totalWishes; counter++) {
            final FirebaseMessageModel firebaseMessageModel = messages.get(counter);

            MessageCell messageCell = new MessageCell(firebaseMessageModel.getSenderName() , firebaseMessageModel.getText(),  getDate(firebaseMessageModel.getCreatedDateLong()), firebaseMessageModel.getSenderDeviceId().equals(user.deviceId));

            messageCells[counter] = messageCell;
        }

        MessagesListAdapter adapter = new MessagesListAdapter(getActivity(), messageCells);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setSelection(listView.getCount() - 1);

        listView.requestFocus();
    }

    /**
     * Return date in specified format.
     * @param milliSeconds Date in milliseconds
     * @return String representing date in specified format
     */
    public static String getDate(long milliSeconds)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy, hh:mm a");

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
