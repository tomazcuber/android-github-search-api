package br.com.githubsearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.githubsearch.R
import br.com.githubsearch.ui.searchuser.SearchUserFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchUserFragment.newInstance())
                .commitNow()
        }
    }
}