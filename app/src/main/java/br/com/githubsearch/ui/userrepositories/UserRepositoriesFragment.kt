package br.com.githubsearch.ui.userrepositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import br.com.githubsearch.ui.adapter.UserRepositoriesAdapter
import br.com.tomazcuber.githubsearch.R
import com.bumptech.glide.Glide
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserRepositoriesFragment : Fragment() {
    private val viewModel: UserRepositoriesViewModel by activityViewModels<UserRepositoriesViewModel>()
    private lateinit var userImageView: ImageView
    private lateinit var usernameTitleTextView: MaterialTextView
    private lateinit var userRepositoriesRecyclerView: RecyclerView
    private lateinit var userRepositoriesAdapter: UserRepositoriesAdapter
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_user_repositories, container, false)

        userImageView = root.findViewById(R.id.profileImageView)
        usernameTitleTextView = root.findViewById(R.id.titleTextView)
        userRepositoriesRecyclerView = root.findViewById(R.id.repositoriesRecyclerView)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argUsername = arguments?.getString("username") ?: ""
        val argAvatarUrl = arguments?.getString("avatarUrl") ?: ""
        usernameTitleTextView.text = getString(R.string.user_repositories_title, argUsername)
        viewModel.reposFromUser.observe(viewLifecycleOwner) { reposFromUser ->
            userRepositoriesAdapter = UserRepositoriesAdapter(reposFromUser)
            userRepositoriesRecyclerView.adapter = userRepositoriesAdapter
        }
        viewModel.getUserWithRepositories(argUsername)
        Glide.with(this)
            .load(argAvatarUrl)
            .circleCrop()
            .into(userImageView)
    }
}