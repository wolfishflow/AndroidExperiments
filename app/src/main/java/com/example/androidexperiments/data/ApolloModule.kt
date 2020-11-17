package com.example.androidexperiments.data

import com.apollographql.apollo.ApolloClient
import com.example.androidexperiments.BuildConfig
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

@Module
@InstallIn(ApplicationComponent::class)
class ApolloModule {

    private var apolloClient: ApolloClient? = null

    @Provides
    fun provideApolloClient(): ApolloClient {
        apolloClient?.let { return@let }
        apolloClient = createClient()
        return apolloClient as ApolloClient
    }

    private fun createClient(): ApolloClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(
                LoggingInterceptor.Builder()
                    .setLevel(Level.BODY)
                    .build()
            ).addInterceptor(
                AuthRequestInterceptor()
            ).build()

        return ApolloClient.builder()
            .serverUrl(SERVER_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

    class AuthRequestInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            return chain.proceed(
                request.newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer ${BuildConfig.GITHUB_TOKEN}"
                    )
                    .build()
            )
        }

    }

    companion object {

        private const val SERVER_URL: String = "https://api.github.com/graphql"

    }

}
