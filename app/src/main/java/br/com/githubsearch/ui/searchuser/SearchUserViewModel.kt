package br.com.githubsearch.ui.searchuser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.githubsearch.data.model.entity.User
import br.com.githubsearch.data.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(private val usersRepository: UsersRepository) :
    ViewModel() {
    val user = MutableLiveData<User>()

    var showErrorSnackbar = MutableLiveData<Boolean>()
    private set

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }
    fun searchUserByUsername(username: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            user.postValue(usersRepository.getUser(username))
        }
    }
}