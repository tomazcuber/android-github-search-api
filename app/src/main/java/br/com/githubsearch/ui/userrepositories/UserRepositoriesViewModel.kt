package br.com.githubsearch.ui.userrepositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.githubsearch.data.model.entity.Repository
import br.com.githubsearch.data.repository.ReposRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRepositoriesViewModel @Inject constructor(
    private val reposRepository: ReposRepository
) : ViewModel() {
    val reposFromUser = MutableLiveData<List<Repository>>()

    fun getUserWithRepositories(username: String) {
        viewModelScope.launch {
            reposFromUser.postValue(reposRepository.getRepositoriesByUserName(username))
        }
    }
}