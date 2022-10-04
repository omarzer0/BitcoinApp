package az.zero.bitcoin.core

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResponseState(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true },
) = flow<ResponseState<ResultType>> {
    emit(ResponseState.Loading(null))
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(ResponseState.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map { ResponseState.Success(it) }
        } catch (throwable: Throwable) {
            query().map { ResponseState.Error(it, throwable.message) }
        }
    } else {
        query().map { ResponseState.Success(it) }
    }

    emitAll(flow)
}