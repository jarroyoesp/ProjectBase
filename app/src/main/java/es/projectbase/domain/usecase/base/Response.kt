package es.projectbase.domain.usecase.base

sealed class Response<out T> {
    class Success<out T>(val data: T) : Response<T>()
    class Error(val exception: Throwable) : Response<Nothing>()
}