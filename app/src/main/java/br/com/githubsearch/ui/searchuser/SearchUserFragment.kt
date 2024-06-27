package br.com.githubsearch.ui.searchuser

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import br.com.githubsearch.R
import br.com.githubsearch.data.model.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchUserFragment : Fragment() {
    companion object {
        fun newInstance() = SearchUserFragment()
    }

    private val viewModel: SearchUserViewModel by activityViewModels<SearchUserViewModel>()
    private lateinit var searchUserTextEdit: MaterialAutoCompleteTextView
    private lateinit var userCard: MaterialCardView
    private lateinit var usernameTextView: MaterialTextView
    private lateinit var totalReposTextView: MaterialTextView
    private lateinit var searchUserButton: ImageButton
    private lateinit var userSearchProgressIndicator: CircularProgressIndicator
    private lateinit var listReposButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_search_user, container, false)
        setupView(root)
        observeViewModel()
        return root
    }

    private fun setupView(view: View) {
        searchUserTextEdit = view.findViewById(R.id.searchUserTextEdit)
        searchUserButton = view.findViewById(R.id.searchButton)
        usernameTextView = view.findViewById(R.id.usernameTextView)
        totalReposTextView = view.findViewById(R.id.repoCountTextView)
        userSearchProgressIndicator = view.findViewById(R.id.userSearchProgressIndicator)
        listReposButton = view.findViewById(R.id.listReposButton)
        userCard = view.findViewById(R.id.userCard)


        searchUserTextEdit.setOnEditorActionListener { _, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                keyEvent == null || keyEvent.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                searchUser()
                true
            } else {
                false
            }
        }

        searchUserButton.setOnClickListener {
            searchUser()
        }
    }

    private fun observeViewModel() {
        viewModel.user.observe(viewLifecycleOwner) { user ->
            Handler(Looper.getMainLooper()).postDelayed({
                userSearchProgressIndicator.visibility = View.GONE
                if (user == null) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.no_user_found),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@postDelayed
                }
                buildUserCard(user)
            }, 2000) // delay for 2 seconds
        }
    }

    private fun searchUser() {
        val user = searchUserTextEdit.text.toString()
        userSearchProgressIndicator.visibility = View.VISIBLE
        userCard.visibility = View.INVISIBLE
        viewModel.searchUserByUsername(user)
    }

    private fun buildUserCard(user: User) {
        usernameTextView.text = user.username
        totalReposTextView.text =
            getString(R.string.public_repositories, user.totalPublicRepos.toString())
        if (user.totalPublicRepos > 0) {
            listReposButton.isEnabled = true
            listReposButton.setOnClickListener {
                Toast.makeText(requireContext(), "List Repos - WIP", Toast.LENGTH_SHORT).show()
            }
        }
        userCard.visibility = View.VISIBLE
    }
}