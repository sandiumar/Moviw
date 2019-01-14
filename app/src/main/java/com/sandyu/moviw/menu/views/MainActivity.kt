package com.sandyu.moviw.menu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandyu.moviw.R
import com.sandyu.moviw.databinding.ActivityMainBinding
import com.sandyu.moviw.menu.adapters.MovieAdapter
import com.sandyu.moviw.menu.viewmodels.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerView()
        observeLiveData()
        viewModel.getMovie()
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager = layoutManager
        adapter = MovieAdapter(this)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun observeLiveData(){
        viewModel.movies.observe(this, Observer {
            adapter.setData(it?.results!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer{
            //handle error
        })
    }
}