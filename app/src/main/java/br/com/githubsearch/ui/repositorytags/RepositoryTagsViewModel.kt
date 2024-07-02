package br.com.githubsearch.ui.repositorytags

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.githubsearch.data.model.entity.RepositoryTag
import br.com.githubsearch.data.repository.TagsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryTagsViewModel @Inject constructor(private val tagsRepository: TagsRepository) :
    ViewModel() {
    val repositoryTags = MutableLiveData<MutableList<RepositoryTag>>()

    fun getRepositoryTags(username: String, repositoryName: String) {
        viewModelScope.launch {
            repositoryTags.postValue(tagsRepository.getRepositoryTags(username, repositoryName).toMutableList())
        }
    }
}