package com.example.todayfamoussaying

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//  리사이클러뷰 공부하기 !!!!!

class QuotePageAdapter(
    private val quotes: List<Quote>,
    private val isNameRevealed: Boolean
): RecyclerView.Adapter<QuotePageAdapter.QuoteViewHolder>() {

    class QuoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        private val quoteTextView: TextView = itemView.findViewById<TextView>(R.id.quoteTextView)
        private val nameTextView: TextView = itemView.findViewById<TextView>(R.id.nameTextView)

        @SuppressLint("SetTextI18n")
        fun bind(quote: Quote, isNameRevealed: Boolean) {
            quoteTextView.text = "\"${quote.quote}\""
            if (isNameRevealed) {
                nameTextView.text = "- ${quote.name}"
                nameTextView.visibility = View.VISIBLE
            }else{
                nameTextView.visibility = View.GONE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder =
        QuoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        )

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val actualPosition = position % quotes.size
        holder.bind(quotes[actualPosition], isNameRevealed)
    }

    override fun getItemCount() = Int.MAX_VALUE

}