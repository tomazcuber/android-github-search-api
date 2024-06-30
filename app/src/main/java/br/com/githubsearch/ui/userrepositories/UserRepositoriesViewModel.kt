package br.com.githubsearch.ui.userrepositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.model.relation.UserWithRepositories
import br.com.githubsearch.data.repository.ReposRepository
import br.com.githubsearch.data.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRepositoriesViewModel @Inject constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {
    val userWithRepositories = MutableLiveData<UserWithRepositories>()

    fun getUserWithRepositories(username: String) {
        viewModelScope.launch {
            userWithRepositories.postValue(usersRepository.listUserRepositories(username))
        }
    }
}