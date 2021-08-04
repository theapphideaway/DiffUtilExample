package com.ianschoenrock.diffutilexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false).apply{
            val items = listOf("One", "One", "Three")
            val newItems = listOf("One", "Two", "Three")
            val mainRV = findViewById<RecyclerView>(R.id.main_rv)
            val updateB = findViewById<Button>(R.id.update_b)
            val adapter = MainAdapter()
            adapter.submitList(items)
            mainRV.adapter = adapter
            mainRV.layoutManager = LinearLayoutManager(requireContext())
            updateB.setOnClickListener {
                adapter.submitList(newItems)
            }
        }
    }
}