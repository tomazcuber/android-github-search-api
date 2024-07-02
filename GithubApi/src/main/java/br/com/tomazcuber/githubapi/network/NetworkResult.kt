package br.com.tomazcuber.githubapi.network

/**
 * A sealed class representing the result of a network operation.
 *
 * This class has three subclasses representing the three possible states of a network operation:
 * Success, Error, and Exception.
 *
 * @param T The type of the data returned in case of a successful network operation.
 */
sealed class NetworkResult<out T> private constructor() {
    /**
     * Represents a successful network operation.
     *
     * @property data The data returned from the network operation.
     * @property links A map of links related to the network operation.
     */
    data class Success<T : Any>(val data: T, val links: Map<String, String>) : NetworkResult<T>() {
        /**
         * Secondary constructor that parses the link header and stores the links in a map.
         *
         * @param data The data returned from the network operation.
         * @param linkHeader The link header returned from the network operation.
         */
        constructor(data: T, linkHeader: String?) : this(
            data = data,
            links = linkHeader?.parseLinks() ?: emptyMap()
        )

        /**
         * Property representing the next page from the links header
         *
         * @property nextPage The next page number from the links header.
         */
        val nextPage: Int?
            get() = links["next"]?.let { nextLink ->
                val pagePattern = "page=(\\d+)".toRegex()
                val matchResult = pagePattern.find(nextLink)
                matchResult?.groupValues?.get(1)?.toInt()
            }
        /**
         * Property representing the first page from the links header
         *
         * @property firstPage The next page number from the links header.
         */
        val firstPage: Int?
            get() = links["first"]?.let { nextLink ->
                val pagePattern = "page=(\\d+)".toRegex()
                val matchResult = pagePattern.find(nextLink)
                matchResult?.groupValues?.get(1)?.toInt()
            }
        /**
         * Property representing the last page from the links header
         *
         * @property lastPage The next page number from the links header.
         */
        val lastPage: Int?
            get() = links["last"]?.let { nextLink ->
                val pagePattern = "page=(\\d+)".toRegex()
                val matchResult = pagePattern.find(nextLink)
                matchResult?.groupValues?.get(1)?.toInt()
            }
        /**
         * Property representing the previousPage from the links header
         *
         * @property previousPage The next page number from the links header.
         */
        val previousPage: Int?
            get() = links["prev"]?.let { nextLink ->
                val pagePattern = "page=(\\d+)".toRegex()
                val matchResult = pagePattern.find(nextLink)
                matchResult?.groupValues?.get(1)?.toInt()
            }

        companion object {
            private fun String.parseLinks(): Map<String, String> {
                val linkPattern = "<(.+?)>; rel=\"(.+?)\"".toRegex()
                val links = mutableMapOf<String, String>()

                linkPattern.findAll(this).forEach { matchResult ->
                    val url = matchResult.groupValues[1]
                    val rel = matchResult.groupValues[2]
                    links[rel] = url
                }

                return links
            }
        }
    }
    /**
     * Represents a network operation that resulted in an error.
     *
     * @property code The error code.
     * @property message The error message.
     */
    data class Error<T : Any>(val code: Int, val message: String?) : NetworkResult<T>()
    /**
     * Represents a network operation that resulted in an exception.
     *
     * @property exception The exception that was thrown during the network operation.
     */
    data class Exception<T : Any>(val exception: Throwable) : NetworkResult<T>()
}
