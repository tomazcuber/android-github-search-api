package br.com.githubsearch.ui.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.githubsearch.data.model.entity.Repository
import br.com.tomazcuber.githubsearch.R
import com.google.android.material.textview.MaterialTextView

class UserRepositoriesAdapter(repositoriesData: List<Repository>) :
    RecyclerView.Adapter<UserRepositoriesAdapter.UserRepositoriesViewHolder>() {

    private var repositories: List<Repository> = repositoriesData

    init {
        Log.i("Repos_RV", "UserRepositoriesAdapter created!")
    }

    inner class UserRepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val repositoryNameTextView =
            itemView.findViewById<MaterialTextView>(R.id.fullNameMaterialTextView)
        private val repositoryDescriptionTextView =
            itemView.findViewById<MaterialTextView>(R.id.descriptionMaterialTextView)
        private val starsMaterialTextView =
            itemView.findViewById<MaterialTextView>(R.id.starsMaterialTextView)
        private val forksMaterialTextView =
            itemView.findViewById<MaterialTextView>(R.id.forksMaterialTextView)

        fun bind(repository: Repository) {
            repositoryNameTextView.text = repository.name
            if (repository.description?.isNotEmpty() == true) {
                repositoryDescriptionTextView.text = repository.description
            } else {
                repositoryDescriptionTextView.visibility = View.GONE
            }
            starsMaterialTextView.text =
                itemView.context.getString(R.string.stars_descriptor, repository.stars.toString())
            forksMaterialTextView.text =
                itemView.context.getString(R.string.forks_descriptor, repository.forks.toString())

            itemView.setOnClickListener { view ->
                val action = R.id.action_userRepositoriesFragment_to_repositoryTagsFragment
                view.findNavController().navigate(action, Bundle().apply {
                    putString("repositoryName", repository.name)
                    putString("ownerUsername", repository.ownerUsername)
                })
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepositoriesViewHolder {
        Log.i("Repos_RV", "onCreateViewHolder!")
        return UserRepositoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserRepositoriesViewHolder, position: Int) {
        Log.i("Repos_RV", "onBindViewHolder!")
        val repository = repositories[position]
        holder.bind(repository)
    }

    override fun getItemCount() = repositories.size
}