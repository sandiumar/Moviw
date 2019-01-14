package com.sandyu.moviw.menu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sandyu.moviw.R
import com.sandyu.moviw.databinding.ItemMovieBinding
import com.sandyu.moviw.menu.models.MovieResponseModel
import com.sandyu.moviw.menu.viewmodels.ItemMovieViewModel

class MovieAdapter(val context: Context): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    protected var movies: MutableList<MovieResponseModel.Moviw> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding: ItemMovieBinding= DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.item_movie, parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bindData(movies[holder.adapterPosition])
    }

    fun setData(movie: MutableList<MovieResponseModel.Moviw>){
        this.movies = movie
    }

    class ViewHolder(private  val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(model: MovieResponseModel.Moviw){
            val viewModel = ItemMovieViewModel(model)
            binding.itemMoviw = viewModel
        }
    }
}