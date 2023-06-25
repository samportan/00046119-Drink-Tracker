package com.sportan.spoonaculartrial
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter(var recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recipeImageView: ImageView = itemView.findViewById(R.id.recipe_image_view)
        private val titleTextView: TextView = itemView.findViewById(R.id.recipe_title_view)
        private val descTextView: TextView = itemView.findViewById(R.id.recipe_desc_view)


        fun bind(recipe: Recipe) {
            titleTextView.text = recipe.title
            val summary = HtmlCompat.fromHtml(recipe.summary, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            descTextView.text = summary.substring(0, 150)
            Glide.with(itemView.context)
                .load(recipe.image)
                .placeholder(R.drawable.baseline_broken_image_24)
                .into(recipeImageView)
        }
    }
}
