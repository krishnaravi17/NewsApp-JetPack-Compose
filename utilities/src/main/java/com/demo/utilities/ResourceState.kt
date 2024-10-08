package com.demo.utilities

sealed class ResourceState<T> {

    class Loading<T> : ResourceState<T>()
    data class Success<T>(var data: T) : ResourceState<T>()
    data class Error<T>(var error: Any) : ResourceState<T>()

}