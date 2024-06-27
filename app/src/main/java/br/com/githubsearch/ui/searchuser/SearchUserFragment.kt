package br.com.githubsearch.ui.searchuser

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ImageButton
import android.widget.TextView
import br.com.githubsearch.R
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchUserFragment : Fragment() {
    companion object {
        fun newInstance() = SearchUserFragment()
    }

    val viewModel: SearchUserViewModel by activityViewModels<SearchUserViewModel>()
    private lateinit var searchUserTextEdit: MaterialAutoCompleteTextView
    private lateinit var usernameTextView: MaterialTextView
    private lateinit var totalReposTextView: MaterialTextView
    private lateinit var searchUserButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var root = inflater.inflate(R.layout.fragment_search_user, container, false)
        setupView(root)
        observeViewModel()
        return root
    }

    private fun setupView(view: View) {
        searchUserTextEdit = view.findViewById(R.id.searchUserTextEdit)
        searchUserButton = view.findViewById(R.id.searchButton)
        usernameTextView = view.findViewById(R.id.usernameTextView)
        totalReposTextView = view.findViewById(R.id.repoCountTextView)


        searchUserTextEdit.setOnEditorActionListener { _, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                keyEvent == null || keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
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
            if(user == null) {
                usernameTextView.text = getString(R.string.no_user_found)
                totalReposTextView.text = ""
                return@observe
            }
            usernameTextView.text = user.username
            totalReposTextView.text = getString(R.string.public_repositories, user.totalPublicRepos.toString())
        }
    }

    private fun searchUser() {
        val user = searchUserTextEdit.text.toString()
        viewModel.searchUserByUsername(user)
    }

}