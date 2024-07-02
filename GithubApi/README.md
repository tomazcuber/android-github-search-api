# android-github-search/GithubApi
This library provides a simple wrapper for the GitHub REST API as an Android library, written in Kotlin.
It encapsulates necessary network operations and provides an easy-to-use interface for making API requests and handling responses.

## Features
- Provides easy-to-use methods for performing GET Requests to the List users, List user's repositories and List repository tags endpoints of the Github REST API
- Each method is designed to handle network operations asynchronously using Kotlin coroutines.
- Uses a NetworkResult sealed class to encapsulate the different states of network responses: Success, Error, and Exception.
- Handles API pagination transparently with the ability to parse link headers and provide easy navigation through data pages using properties like nextPage, previousPage, etc.

## Used technologies
- HTTP Requests with Retrofit2 and OkHttp4
- Serialization and deserialization of Kotlin data classes to and from JSON with kotlinx.serialization-json
- Dependency Injection with Dagger
- Unit tests with JUnit4, MockK and Strikt
- Documentation generated with Dokka

## Getting Started

Follow these instructions to integrate the GitHub API library into your Android project.

### Prerequisites

Ensure you have the following installed:
- Android SDK with a minimum API level of 24.
- Latest version of Android Studio and Gradle.

### Installation

TBD

### Usage

#### Initialize the Library

Before making any requests to the GitHub API, you must initialize the library with the necessary configuration. Initialization typically occurs in your `Application` class or equivalent startup logic.
The initialization is performed with the `GitHubApiInitializer.initialize` method. The method receives an optional `java.io.File` argument for the path to the cache directory. If no cache directory is
specified, requests to the API will be performed without caching.

Here's how you can initialize the GitHub API:

```kotlin
import br.com.tomazcuber.githubapi.GitHubApiInitializer
import java.io.File

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        
        // Optional: Provide a cache directory
        val cacheDir = File(applicationContext.cacheDir, "githubApiCache")

        // Initialize the GitHub API
        GitHubApiInitializer.initialize(cacheDir)
    }
}
```

### Usage

Once the GitHub API library is initialized, you can utilize the `githubClient` to make API calls. The responses from these calls are encapsulated in a `NetworkResult` class, which can be one of `Success`, `Error`, or `Exception`. Handling these results properly will ensure robust and user-friendly interactions with the GitHub API.

Here’s how you can use the `githubClient` to make API calls and handle different network results:

```kotlin
val client = GitHubApiInitializer.githubClient

// Example: Search for a user on GitHub
suspend fun searchForUser(username: String) {
    when (val result = client.searchUser(username)) {
        is NetworkResult.Success -> {
            // Handle successful response
            println("User Name: ${result.data.name}")
            println("User Followers: ${result.data.followers}")
        }
        is NetworkResult.Error -> {
            // Handle API error response
            println("Error: ${result.message} (Code: ${result.code})")
        }
        is NetworkResult.Exception -> {
            // Handle unexpected exceptions
            println("Exception: ${result.exception.message}")
        }
    }
}

// Example: List a user's repositories
suspend fun listUserRepositories(username: String) {
    when (val result = client.searchUserRepositories(username)) {
        is NetworkResult.Success -> {
            // Handle successful response
            result.data.forEach { repo ->
                println("Repository Name: ${repo.name}")
                println("Repository Stars: ${repo.stars}")
            }
            // Optional: Handle pagination if applicable
            result.nextPage?.let { nextPage ->
                println("Next page: $nextPage")
            }
        }
        is NetworkResult.Error -> {
            // Handle API error response
            println("Error: ${result.message} (Code: ${result.code})")
        }
        is NetworkResult.Exception -> {
            // Handle unexpected exceptions
            println("Exception: ${result.exception.message}")
        }
    }
}

// Example: List repository tags
suspend fun listRepositoryTags(username: String, repositoryName: String) {
    when (val result = client.listRepositoryTags(username, repositoryName)) {
        is NetworkResult.Success -> {
            // Handle successful response
            result.data.forEach { tag ->
                println("Tag: ${tag.name}")
            }
        }
        is NetworkResult.Error -> {
            // Handle API error response
            println("Error: ${result.message} (Code: ${result.code})")
        }
        is NetworkResult.Exception -> {
            // Handle unexpected exceptions
            println("Exception: ${result.exception.message}")
        }
    }
}
```

### Key Points:

1. **API Calls Handling**: All network calls return a `NetworkResult` object that must be checked for its type (`Success`, `Error`, `Exception`) to handle the response appropriately.
   
2. **Successful Responses**: For `Success` results, you can access the `data` which contains the actual response object from the GitHub API. If pagination is involved, links to other pages are available (`nextPage`, `previousPage`, etc.) through the parsed link headers.

3. **Error Handling**: For `Error` results, the error code and message provide details about what went wrong with the API request.

4. **Exceptions**: For `Exception` results, an unexpected error occurred (like network failure), and the exception provides details on what went wrong.

5. **Pagination Support**: If applicable, the `Success` type also contains methods to navigate through paginated results using the available link headers (`nextPage`, `previousPage`, `firstPage`, `lastPage`).

By following these guidelines, you can effectively integrate and utilize the GitHub API in your Android applications, handling all possible network outcomes gracefully.
