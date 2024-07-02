package br.com.githubsearch.ui.repositorytags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import br.com.githubsearch.ui.adapter.RepositoryTagsAdapter
import br.com.tomazcuber.githubsearch.R
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryTagsFragment : Fragment() {
    private val viewModel: RepositoryTagsViewModel by activityViewModels<RepositoryTagsViewModel>()
    private lateinit var repositoryNameTextView: MaterialTextView
    private lateinit var repositoryTagsRecyclerView: RecyclerView
    private lateinit var repositoryTagsAdapter: RepositoryTagsAdapter
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_repository_tags, container, false)

        repositoryNameTextView = root.findViewById(R.id.repositoryNameTextView)
        repositoryTagsRecyclerView = root.findViewById(R.id.repositoryTagsRecyclerView)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argRepositoryName = arguments?.getString("repositoryName") ?: ""
        val argOwnerUsername = arguments?.getString("ownerUsername") ?: ""
        repositoryNameTextView.text = getString(R.string.repository_tags_title, argRepositoryName)

        viewModel.repositoryTags.observe(viewLifecycleOwner) { tags ->
            repositoryTagsAdapter = RepositoryTagsAdapter(tags)
            repositoryTagsRecyclerView.adapter = repositoryTagsAdapter
        }

        viewModel.getRepositoryTags(argOwnerUsername, argRepositoryName)
    }
}