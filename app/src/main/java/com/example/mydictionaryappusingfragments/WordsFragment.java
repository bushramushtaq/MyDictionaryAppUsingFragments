package com.example.mydictionaryappusingfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordsFragment extends Fragment {
    //my code
    private OnListItemClickedListener listener;
    private ListView wordsLV;

    public WordsFragment() {
        // Required empty public constructor
    }
    //my code
    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        try{
            listener=(OnListItemClickedListener)context;
        }
        catch(ClassCastException exp)
        {throw new ClassCastException(context.toString()+"must implement OnListItemClickedListener");}
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       if (getArguments() != null) {
       /*     mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmenta
        return inflater.inflate(R.layout.fragment_words, container, false);
    }
    @Override
    public void onActivityCreated(@NonNull Bundle savedInstanceStaste)
    {
        super.onActivityCreated(savedInstanceStaste);
        wordsLV=getActivity().findViewById(R.id.WordsListView); // get the listview id  from fragment_meaning.xml
        //get the string-array words and put this array in the list_item.xml file
        ArrayAdapter<String>listArrAdapter=new ArrayAdapter<String>(getContext(),
                R.layout.list_item,getResources().getStringArray(R.array.words));
        wordsLV.setAdapter(listArrAdapter);//put the resultant listArrayAdapter finally in the worsdsLV

        /* attach the OnItemClickListener with WordsLV so that as the user click any word in the list it will take
         the control to the onItemSelected() of OnListItemClickedListener which is un-implemented in this class but
          is implemented in host(MainActivity). Hence in this fragment you notice the error but don’t worry
          it will be removed as soon as you implemented it in S—MainActivity.java)*/
        wordsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });
    }
    //container Activity(MainActivity) must implement this interface
public interface OnListItemClickedListener{
    public abstract void onItemSelected(int pos);
}

}


