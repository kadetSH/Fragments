package com.example.fragments

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.recyclerMy.FilmsAdapter
import com.example.fragments.recyclerMy.FilmsItem

class FilmsFragment : Fragment() {

    companion object {

        fun newInstance(list: ArrayList<FilmsItem>): FilmsFragment {
            val args = Bundle()
            args.putSerializable("spisok", list)

            val fragment = FilmsFragment()
            fragment.arguments = args
            return fragment
        }


        var adapter: FilmsAdapter? = null
    }

    var list = ArrayList<FilmsItem>()
    var filmP: String = ""
    var favoriteName: ArrayList<String> = ArrayList()






    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films_list, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        list.addAll(
//            fillArrays(
//                resources.getStringArray(R.array.film),
//                getImageId(R.array.film_image),
//                resources.getStringArray(
//                    R.array.film_description
//                )
//            )
//        )

        list = arguments?.getSerializable("spisok") as ArrayList<FilmsItem>

        adapter = FilmsAdapter(
            LayoutInflater.from(requireContext()),
            list
        ) { filmsItem: FilmsItem, position: Int, note: String ->
//            selectFavorites(filmsItem, position)
            (activity as? OnFilmLikeClickListener)?.onFilmLikeClick(filmsItem, position, note)
        }

        view.findViewById<RecyclerView>(R.id.id_recyclerView)
            .adapter = adapter
    }

    interface OnFilmLikeClickListener{
        fun onFilmLikeClick(filmsItem: FilmsItem, position: Int, note : String)
    }

//    fun newInstance(newList : ArrayList<FilmsItem>){
//
//    }

//    fun selectFavorites(spisokItem: FilmsItem, position: Int) {
//
//        var proverka: Boolean = false
//
//        if ((spisokItem.star == false) && (proverka == false)) {
//            proverka = true
//            spisokItem.star = true
////            starSpisok.add(spisokItem.nameFilm)
////            starSpisokPosition.add(position)
//            adapter?.notifyItemChanged(position)
//        }
//        if ((spisokItem.star == true) && (proverka == false)) {
//            proverka = true
//            spisokItem.star = false
////            var indexName = starSpisok.indexOf(spisokItem.nameFilm)
////            starSpisok.removeAt(indexName)
////            var indexPosition = starSpisokPosition.indexOf(position)
////            starSpisokPosition.removeAt(indexPosition)
//            adapter?.notifyItemChanged(position)
//        }
//
//    }
//
//    fun fillArrays(
//        titleArray: Array<String>,
//        filmImageArray: IntArray,
//        descriptionArray: Array<String>,
//    ): List<FilmsItem> {
//        var list = ArrayList<FilmsItem>()
//        for (i in 0..titleArray.size - 1) {
//            var shortDescription = descriptionArray[i]
//            var proverka = ""
//            if (titleArray[i].equals(filmP)) {
//                proverka = filmP
//            }
//            var idxFav = favoriteName.indexOf(titleArray[i])
//            var boolFavorite: Boolean
//
//            if (idxFav == -1) {
//                boolFavorite = false
//            } else {
//                boolFavorite = true
//            }
//            var spisokItem = FilmsItem(
//                titleArray[i], filmImageArray[i], shortDescription.substring(
//                    0,
//                    120
//                ) + "...", proverka, boolFavorite
//            )
//            list.add(spisokItem)
//        }
//        return list
//    }
//
//    fun getImageId(filmImageArrayId: Int): IntArray {
//        var iArray: TypedArray = resources.obtainTypedArray(filmImageArrayId)
//        val count = iArray.length()
//        val ids = IntArray(count)
//        for (i in ids.indices) {
//            ids[i] = iArray.getResourceId(i, 0)
//        }
//        iArray.recycle()
//        return ids
//    }

}