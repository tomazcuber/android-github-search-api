package br.com.githubsearch.ui.searchuser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(private val usersRepository: UsersRepository) :
    ViewModel() {
    val user = MutableLiveData<User>()
    fun searchUserByUsername(username: String) {
        viewModelScope.launch {
            user.postValue(usersRepository.searchUser(username))
        }
    }
}