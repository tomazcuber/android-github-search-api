package br.com.githubsearch.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.githubsearch.data.model.entity.RepositoryTag
import br.com.tomazcuber.githubsearch.R
import com.google.android.material.textview.MaterialTextView

class RepositoryTagsAdapter(tagsData: List<RepositoryTag>) : RecyclerView.Adapter<RepositoryTagsAdapter.RepositoryTagViewHolder>() {

private var tags: List<RepositoryTag> = tagsData

    inner class RepositoryTagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tagNameTextView = itemView.findViewById<MaterialTextView>(R.id.tagNameMaterialTextView)
        private val commitShaTextView = itemView.findViewById<MaterialTextView>(R.id.commitShaMaterialTextView)
        fun bind(tag: RepositoryTag) {
            tagNameTextView.text = tag.name
            commitShaTextView.text = tag.commitSha
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryTagViewHolder {
        Log.i("Repos_RV", "onCreateViewHolder!")
        return RepositoryTagViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository_tag, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RepositoryTagViewHolder, position: Int) {
        Log.i("Repos_RV", "onBindViewHolder!")
        val tag = tags[position]
        holder.bind(tag)
    }

    override fun getItemCount() = tags.size

}