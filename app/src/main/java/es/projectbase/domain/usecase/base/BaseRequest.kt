package es.projectbase.domain.usecase.base

interface BaseRequest {
    fun validate(): Boolean
}
