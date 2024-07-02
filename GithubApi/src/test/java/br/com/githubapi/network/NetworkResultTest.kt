package br.com.githubapi.network

import org.junit.Assert.*
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.containsKey
import strikt.assertions.get
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo
import strikt.assertions.isNotEmpty
import strikt.assertions.isNotNull
import strikt.assertions.isNull

class NetworkResultTest {
    @Test
    fun `success network result with valid links header should have a valid links map`() {
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=2>; rel=\"prev\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=4>; rel=\"next\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=515>; rel=\"last\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=1>; rel=\"first\""

        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.links).isNotEmpty()
        expectThat(testSuccessResult.links) {
            containsKey("prev")
            get("prev").isEqualTo("https://api.github.com/repositories/1300192/issues?page=2")
            containsKey("next")
            get("next").isEqualTo("https://api.github.com/repositories/1300192/issues?page=4")
            containsKey("last")
            get("last").isEqualTo("https://api.github.com/repositories/1300192/issues?page=515")
            containsKey("first")
            get("first").isEqualTo("https://api.github.com/repositories/1300192/issues?page=1")
        }
    }

    @Test
    fun `success network result with no link header should have empty links map`() {
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, null)
        expectThat(testSuccessResult.links).isEmpty()
    }

    @Test
    fun `success network result with next page on links header should have valid nextPage`() {
        val testNextPage: Int = 4
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=2>; rel=\"prev\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=$testNextPage>; rel=\"next\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=515>; rel=\"last\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=1>; rel=\"first\""
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.nextPage) {
            isNotNull()
            isEqualTo(testNextPage)
        }
    }

    @Test
    fun `success network result without next page on links header should have null nextPage`() {
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=2>; rel=\"prev\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=3>; rel=\"last\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=1>; rel=\"first\""
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.nextPage) {
            isNull()
        }
    }

    @Test
    fun `success network result with prev page on links header should have valid previousPage`() {
        val testPrevPage: Int = 2
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=${testPrevPage}>; rel=\"prev\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=4>; rel=\"next\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=515>; rel=\"last\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=1>; rel=\"first\""
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.previousPage) {
            isNotNull()
            isEqualTo(testPrevPage)
        }
    }

    @Test
    fun `success network result without previous page on links header should have null previousPage`() {
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=2>; rel=\"next\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=515>; rel=\"last\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=1>; rel=\"first\""
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.previousPage) {
            isNull()
        }
    }

    @Test
    fun `success network result with last page on links header should have valid lastPage`() {
        val testLastPage: Int = 515
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=2>; rel=\"prev\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=4>; rel=\"next\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=${testLastPage}>; rel=\"last\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=1>; rel=\"first\""
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.lastPage) {
            isNotNull()
            isEqualTo(testLastPage)
        }
    }

    @Test
    fun `success network result without last page on links header should have null lastPage`() {
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=4>; rel=\"next\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=2>; rel=\"prev\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=1>; rel=\"first\""
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.lastPage) {
            isNull()
        }
    }

    @Test
    fun `success network result with first page on links header should have valid firstPage`() {
        val testFirstPage: Int = 1
        val testLinksHeader =
            "<https://api.github.com/repositories/1300192/issues?page=2>; rel=\"prev\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=4>; rel=\"next\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=515>; rel=\"last\"," +
                    "<https://api.github.com/repositories/1300192/issues?page=${testFirstPage}>; rel=\"first\""
        val testData: String = "FAKE_DATA"

        val testSuccessResult = NetworkResult.Success(testData, testLinksHeader)
        expectThat(testSuccessResult.firstPage) {
            isNotNull()
            isEqualTo(testFirstPage)
        }
    }
}
